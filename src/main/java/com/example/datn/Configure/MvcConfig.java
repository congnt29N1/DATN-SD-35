package com.example.datn.Configure;

import com.example.datn.Utils.DateToTimestampConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        String dirName = "user-photos";
        Path nhanVienPhotosDir = Paths.get(dirName);
        String nhanVienPhotosPath = nhanVienPhotosDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/" + dirName + "/**")
                .addResourceLocations("file:/" + nhanVienPhotosPath + "/");

        String productDirName = "static/assets/products-images";
        Path productImagesDir = Paths.get(productDirName);
        String productImagesPath = productImagesDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/static/assets/images/**")
                .addResourceLocations("/static/assets/images/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateToTimestampConverter());
    }
}
