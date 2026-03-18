package hw7.task_02;

public class AdminService {

    @RequiresRole({"ADMIN"})
    public void deleteUser(String id){
        System.out.println("User was deleted");
    }

    @RequiresRole({"ADMIN","MANAGER"})
    public void viewReport(String id) {
        System.out.println("Report is shown");
    }
    @RequiresRole({"ADMIN","MANAGER","ANALYST"})
    public void exportData() {
        System.out.println("Data is exported");
    }

    public void getPublicInfo(){
        System.out.println("Public info is available for all users");
    }
}
