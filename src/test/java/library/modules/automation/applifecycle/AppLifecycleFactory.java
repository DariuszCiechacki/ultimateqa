package library.modules.automation.applifecycle;

import com.github.javafaker.Faker;

public class AppLifecycleFactory {
    public static AppLifecycleDto createAppLifecycleFormData(){
        AppLifecycleDto appLifecycleData = new AppLifecycleDto();
        Faker faker = new Faker();

        appLifecycleData.setFirstName(faker.name().firstName());
        appLifecycleData.setLastName(faker.name().lastName());

        return appLifecycleData;
    }
}
