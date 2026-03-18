package hw7.task_01;

public class CheckoutTests {

    @Smoke
    @Regression
    public void userCanLoginWithValidCredentials() {
        System.out.println("Login");
    }
    @Smoke
    @Regression
    public void userCanLogout() {
        System.out.println("Logout");
    }

    @Regression
    public void userCanAddAvatar(){
        System.out.println("New photo is uploaded");
    }
    @Regression
    public void userCanChangeAddress() {
        System.out.println("New address is shown");
    }

    public void userCanAddProductsToTheCart() {
        System.out.println("Products are shown in the cart");
    }
}
