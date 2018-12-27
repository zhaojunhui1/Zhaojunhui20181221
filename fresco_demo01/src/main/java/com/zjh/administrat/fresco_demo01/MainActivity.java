package com.zjh.administrat.fresco_demo01;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView simpleDraweeView;
    private SimpleDraweeView simpleDrawee_background;
    private Class<?> clazz;
    /*   private Method[] methodArray;
    private Method m;
    private Class stuClass;
    private Student student;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleDraweeView = findViewById(R.id.fresco);
        simpleDrawee_background = findViewById(R.id.fresco_background);

        try {
            Uri uri1 = Uri.parse("http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg");
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri1).setPostprocessor(new IterativeBoxBlurPostProcessor(1, 30)).build();
            AbstractDraweeController controller = Fresco.newDraweeControllerBuilder().setOldController(simpleDraweeView.getController()).setImageRequest(request).build();
            simpleDrawee_background.setController(controller);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Uri uri = Uri.parse("http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg");
        simpleDraweeView.setImageURI(uri);

        //反射机制
      /*  Student stu = new Student();
        Class stuClass = stu.getClass();
        Toast.makeText(this, stuClass.getName(), Toast.LENGTH_SHORT).show();*/

      /*  try {
            Student stu = new Student();
            Class stuClass = stu.getClass();
            Class aClass = Class.forName(stuClass.getName());
            Constructor[] conArray = aClass.getConstructors();
            for (Constructor con : conArray){
                Log.i("TAG", con+"");
            }

            Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor com : declaredConstructors){
                Log.i("TAG", com+"");
            }

            Field f = stuClass.getField("name");
            Log.i("TAG", ""+f);
            Object obj = aClass.getConstructor().newInstance();
            f.set(obj, "赑屃");
            Constructor declared = aClass.getDeclaredConstructor(Student.class);
            declared.setAccessible(true);
            Student student = (Student) obj;
            Log.i("TAG", "验证姓名："+student.getName());


        } catch (Exception e) {
            e.printStackTrace();
        }
*/
      /*  *******************************************
        try {
            student = new Student();
            stuClass = Class.forName("com.zjh.administrat.fresco_demo01.Student");
            //2.获取所有公有方法
            System.out.println("***************获取所有的”公有“方法*******************");
            stuClass.getMethods();
            methodArray = stuClass.getMethods();
            for(Method m : methodArray){
                System.out.println(m);
            }
            System.out.println("***************获取所有的方法，包括私有的*******************");
            methodArray = stuClass.getDeclaredMethods();
            for(Method m : methodArray){
                System.out.println(m);
            }
            System.out.println("***************获取公有的show1()方法*******************");
            m = stuClass.getMethod("show1", String.class);
            System.out.println(m);
            //实例化一个Student对象
            Object obj = stuClass.getConstructor().newInstance();
            m.invoke(student, "改变后的数据！！！！！！");


            System.out.println("***************获取私有的show2()方法******************");
            m = stuClass.getDeclaredMethod("show2", int.class);
            System.out.println(m);
            m.setAccessible(true);
            Object result = m.invoke(student, 20000);

            System.out.println("返回值：" + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
*/
      reflexStudent();

    }

    @SuppressLint("NewApi")
    private void reflexStudent() {
        try {
            Student student = new Student();
            clazz = Class.forName("com.zjh.administrat.fresco_demo01.Student");
            Field[] fields = clazz.getDeclaredFields();
            Student student1=new Student();
            StringBuffer stringBuffer = new StringBuffer();
           // stringBuffer.append(Modifier.toString(student.getClass().getModifiers()));

            for (Field field : fields){
                field.setAccessible(true);


                //stringBuffer.append(field.getDeclaringClass());
                 stringBuffer.append(field.getName()+"\n");

              /*  field.set(student, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                Object o = field.get(student);*/

            }

            Log.i("TAG", stringBuffer+"");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
