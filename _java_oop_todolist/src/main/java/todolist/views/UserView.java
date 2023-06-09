package todolist.views;

import java.util.Scanner;

import todolist.usecases.Userusecase;

public class UserView {
    public static void ShowUserMain() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("List User");

        Userusecase userusecase = new Userusecase();
        userusecase.GetUserList();

        System.out.println("===");
        System.out.println("MENU");
        System.out.println("====");
        System.out.println("[1] - Add New User Account");
        System.out.println("[2] - Change Password");
        System.out.println("[0] - Back to Welcome Page");
        System.out.println();
        System.out.println("Input Menu (Number):");
        Integer menu = inputScanner.nextInt();

        switch (menu) {
            case 0:
                WelcomeViews.ShowWelcomeView();
                break;
            case 1:
                ShowAddUser();
                break;
            case 2:
                ShowChangePassword();
                break;
        }
        inputScanner.close();
    }

    public static void ShowAddUser () {
        Scanner inputScanner = new Scanner (System.in);
        System.out.println("=========================");
        System.out.println("userid:");
        String sUserid = inputScanner.nextLine();
        System.out.println("password:");
        String sPassword = inputScanner.nextLine();

        Userusecase userusecase = new Userusecase();
        userusecase.AddUser(sUserid, sPassword);

        ShowUserMain();
        inputScanner.close();
    }

    private static void ShowChangePassword() {
        Scanner inputScanner = new Scanner (System.in);
        System.out.println("=========================");
        System.out.println("userid:");
        String sUserid = inputScanner.nextLine();
        System.out.println("password:");
        String sPassword = inputScanner.nextLine();

        Userusecase userusecase = new Userusecase();
        userusecase.ChangePasswordUser(sUserid, sPassword);

        ShowUserMain();
        inputScanner.close(); 
    }
    
}
