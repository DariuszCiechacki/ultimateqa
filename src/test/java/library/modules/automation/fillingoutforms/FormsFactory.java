package library.modules.automation.fillingoutforms;

import library.DefaultData;

public class FormsFactory {
    public static FormsDto createFormData(){
        FormsDto formData = new FormsDto();

        //Integrate faker with project
        formData.setName(DefaultData.name);
        formData.setMessage(DefaultData.message);

        return formData;
    }
}
