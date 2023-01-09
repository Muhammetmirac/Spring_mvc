package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import java.awt.*;

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
public class AppConfiguration {

    @Bean
    public Point point(){
        return new Point(56,47);
    }


}
