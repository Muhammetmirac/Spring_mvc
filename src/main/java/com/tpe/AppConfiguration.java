package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


import java.awt.*;
import java.util.Properties;

@Configuration // bu class konfigürasyon classı oldugu için @Configuration anostasyonunu ekledik
 /*
 @Configuration----------> Springe bu anostasyon ile bu classta benim configurasyon dosyalarım var diyoruz
 @ComponentScan---------->Spring Bu classtan alta ve yana doğru tarama yaparak @Component gördüklerini işaretleyecek ve ihtiyaç duyduğumuzda
                            çağırmamız için hazır hale getirecek
        Alt satırda parantez içerisinde yazılı olan ("com.tpe) opsiyoneldir. Default com.tpe gelir
        Hangi classtan itibaren taramsını istiyorsak ("com.tpe.app") olarak ekleme yaparız
  */
@ComponentScan("com.tpe")  // @ComponentScan default olarak com.tpe dir ancak okunurluk için yazılmalıdır
                            //ComponentScan("com.tpe.app") şeklinde yazılırsa app packageni ve alt classlarını tarar
@PropertySource("classpath:application.properties")        //
public class AppConfiguration {
    @Autowired
    Environment environment; // benim resource altına eklediğim çevre birimlerine ulaşmak için bu field oluşturulur ve kullanılır

    @Bean // Javada bizim dışımızda oluşturulmuş classları kullanmak istediğimizde başka classtan method oluşturularak üzerine de
            // @Bean anostasyonu eklenerek Springde kullanırız. Method düzeyinde bir annotationdur.
    public Point point(){
        return new Point(56,47);
    }

    @Bean // ========>  method seviye bir anostasyondur. Bizim oluşturmadığmız hazır classlardan kullanacağımız zaman bean kullanırız
    public Properties properties(){  // kendi oluşturduğumuz properties dosyamızdan değişkenleri tek tek çağırmak yerine birden fazla
                                        // çağırıp kullanmak için bu methodu oluşturduk.
        Properties properties = new Properties();
        properties.put("email",environment.getProperty("app.email"));
        properties.put("MYJAVA_HOME",environment.getProperty("JAVA_HOME"));
        return  properties;
    }


}
/*
Bean springde kullanacağımız java classlarıdır

 */