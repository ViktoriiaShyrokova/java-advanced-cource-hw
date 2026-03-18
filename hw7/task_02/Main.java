package hw7.task_02;

public class Main {

    public static void main(String[] args) {

        try {

            System.out.println(AccessChecker.canAccess(AdminService.class, "deleteUser", "ADMIN"));
            System.out.println(AccessChecker.canAccess(AdminService.class, "deleteUser", ""));
            System.out.println(AccessChecker.canAccess(AdminService.class, "deleteUser", "MANAGER"));
            System.out.println(AccessChecker.canAccess(AdminService.class, "viewReport", "MANAGER"));
            System.out.println(AccessChecker.canAccess(AdminService.class, "viewReport", "MANAGER"));
            System.out.println(AccessChecker.canAccess(AdminService.class, "viewReport", "ANALYST"));
            System.out.println(AccessChecker.canAccess(AdminService.class, "exportData", "ANALYST"));
            System.out.println(AccessChecker.canAccess(AdminService.class, "getPublicInfo", ""));

        } catch (NoSuchMethodException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
