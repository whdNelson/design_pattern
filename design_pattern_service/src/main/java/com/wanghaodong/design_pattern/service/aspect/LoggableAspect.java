package com.wanghaodong.design_pattern.service.aspect;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanghaodong.design_pattern.annotation.Loggable;
import com.wanghaodong.design_pattern.model.AgeLog;
import com.wanghaodong.design_pattern.service.AopVmLoggableService;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LoggableAspect {

    @Autowired
    private AopVmLoggableService aopVmLoggableService;

    /**
     * execution后表达式规则描述
     * 第一个"*":全部返回类型
     * "com.wanghaodong.design_pattern.service.impl" 包名
     * "..":当前包及其子包
     * 第二个"*":包下类
     * ".*":类下任意方法
     * (..):全部方法参数
     */
    @Pointcut("execution(* com.wanghaodong.design_pattern.service.impl..*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object exec(ProceedingJoinPoint point) throws Throwable{

        Object target = point.getTarget();//获取类成员变量
        Class clazz = target.getClass();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
                .getMethod().getParameterTypes();//获取所切方法参数的类型[]
        String methodName = point.getSignature().getName();//获取所切方法的方法名
        Method method = clazz.getMethod(methodName, parameterTypes);

        //判断方法是否带有“本功能”注解
        if (!method.isAnnotationPresent(Loggable.class)) {
            return point.proceed();
        }

        Loggable loggable = method.getAnnotation(Loggable.class);

        //生命模板参数map
        Map<String, Object> context = new HashMap<>();
        //获取方法入参列表
        Object[] parameters = point.getArgs();
        if (parameters != null && parameters.length > 0) {
            //模板内以p+序数表示入参，如:"p1"表示第一个参数
            for (int i = 0; i < parameters.length ; i++) {
                context.put("p" + (i+1), parameters[i]);
            }
        }
        //获取方法返回值
        Object ret = point.proceed();
        if (ret != null) {
            context.put("ret", ret);
        }
        //判断注解参数
        String memo = loggable.memo();
        AgeLog ageLog = new AgeLog();
        if (!StringUtils.isEmpty(memo)) {
            ageLog.setMemo(memo);
            System.out.println(memo);
        }else {
            //执行模板功能
            String templateResourceName = "templates/" + methodName + ".vm";//模板文件路径
            ageLog.setMemo(compileTemplate(templateResourceName,context));
        }
        aopVmLoggableService.create(ageLog);

        return point.proceed();

    }


    private String compileTemplate(String resource, Map<String, Object> context) throws IOException {

        ClassPathResource cp = new ClassPathResource(resource);
        if (!cp.exists()) return "";

        VelocityEngine vEngine = new VelocityEngine();
        //基础属性设置
        vEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        vEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        vEngine.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        vEngine.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        vEngine.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");

        //获取模板文件
        org.apache.velocity.Template template = vEngine.getTemplate(resource,"UTF-8");
        //模板内容格式化
        VelocityContext velocityContext=new VelocityContext(context);
        //套用模板
        Writer out = new StringWriter();
        template.merge(velocityContext, out);
        out.flush();
        return out.toString();

    }

}
