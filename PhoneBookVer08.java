package editlist.fileIOstream_24chapter.streamRefactoringV8;


import java.io.IOException;

public class PhoneBookVer08 {

  public static void main(String[] args) throws ClassNotFoundException,IOException {
    PhoneBookManager manager= PhoneBookManager.createManagerInst();
    int choice;
    while(true){
      try{
        MenuViewer.showMenu();
        choice= MenuViewer.keyboard.nextInt();
        MenuViewer.keyboard.nextLine();

        if(choice< INIT_MENU.INPUT || choice> INIT_MENU.EXIT)
          throw new MenuChoiceException(choice);

        if (choice== INIT_MENU.INPUT){
          manager.inputData();
        }else if(choice== INIT_MENU.SEARCH) {
          manager.searchData();
        }else if(choice== INIT_MENU.DELETE) {
          manager.deleteData();
        } else if(choice== INIT_MENU.EXIT){
          manager.saveToFile();
          System.out.println("프로그램을 종료합니다. ");
          return;
        }
      }catch(MenuChoiceException e){
        e.showWrongChoice();
        System.out.println("메뉴 선택을 처음부터 다시 진행합니다.\n");
      }
    }
  }
}
