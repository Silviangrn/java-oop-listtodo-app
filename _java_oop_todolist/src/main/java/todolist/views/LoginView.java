package todolist.views;

import java.util.Scanner;

import todolist.usecases.LoginUsecase;

public class LoginView {
    public static void ShowLoginPage() {
        Scanner inputScanner = new Scanner (System.in);
        System.out.println("==========================");
        System.out.println("Login Page");
        System.out.println("==========================");

        System.out.println("USER ID:");
        String userid = inputScanner.nextLine();

        System.out.println("PASSWORD ID:");
        String pass = inputScanner.nextLine();

        LoginUsecase loginUsecase = new LoginUsecase();
        String sValidate = loginUsecase.LoginValidate(userid,pass);

        if (sValidate.equals("")) {
            System.out.println("LOGIN SUCCESS !!");
            TaskView.ShowListtodo(userid);
        }else {
            System.out.println();
            System.out.println("LOGIN FAILED -" + sValidate);
        }

        System.out.println("===");
        System.out.println("MENU");
        System.out.println("===");
        System.out.println("[1] - Login Page");
        System.out.println("[0] - Back to Welcome Page");   
        System.out.println();
        System.out.println("Input Menu (Number):");
        Integer menu = inputScanner.nextInt();

        switch (menu) {
            case 0:
                WelcomeViews.ShowWelcomeView();
                break;
            case 1:
                ShowLoginPage();
                break;
 
        }
        
        inputScanner.close();


    }
}
