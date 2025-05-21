package editlist.exceptionHandler_18.phonebookV6;

public class PhoneBookVer6 {


  public static void main(String[] args) {
    PhoneBookManager manager=PhoneBookManager.createManagerInst();
    int choice;
    while(true){
      try{
        MenuViewer.showMenu();
        choice=MenuViewer.keyboard.nextInt();
        MenuViewer.keyboard.nextLine();

        if(choice< INIT_MENU.INPUT || choice> INIT_MENU.EXIT)
          throw new MenuChoiceException(choice);

        if (choice==INIT_MENU.INPUT){
          manager.inputData();
        }else if(choice==INIT_MENU.SEARCH){
          manager.searchData();
        }else if(choice==INIT_MENU.DELETE){
          manager.deleteData();
        }else if(choice==INIT_MENU.EXIT){
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
