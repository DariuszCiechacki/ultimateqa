package library.modules.automation.applifecycle.forms.sprint2;

import library.modules.automation.applifecycle.AppLifecycleData;

public class Sprint2Form implements Sprint2Interface{
    @Override
    public Sprint2Form enterFirstName(String firstName) {
        new AppLifecycleData().enterFirstName(firstName);

        return this;
    }

    @Override
    public Sprint2Form enterLastName(String lastName) {
        new AppLifecycleData().enterLastName(lastName);

        return this;
    }
}
