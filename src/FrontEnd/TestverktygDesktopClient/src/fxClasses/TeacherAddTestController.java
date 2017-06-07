
import models.Test;
import propertymodels.Teacher;
        t.setSubject(currentTeacher.getSubject());
        t.setTotalTime(Integer.parseInt(textFieldTimeLeft.getText()));
        t.setTeacher_id(currentTeacher.getId());
        System.out.println(t.getTeacher_id() + "---------------------------");