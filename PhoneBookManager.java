package editlist.fileIOstream_24chapter.streamRefactoringV8;

import java.io.*;
import java.util.*;

public class PhoneBookManager {
  private int curCnt;
  private final File datafile=new File("PhoneBook.dat");
  private static PhoneBookManager inst=null;
  private static List<PhoneInfo> infoList=new ArrayList<>();
  public PhoneBookManager() throws ClassNotFoundException {
    curCnt=0;
    readFromFile();
  }

  public static PhoneBookManager createManagerInst() throws ClassNotFoundException{
    if(inst==null){
      inst=new PhoneBookManager();
    }
    return inst;
  }

  private void readFriendInfo(PhoneInfo info) {
    System.out.print("이름: ");
    info.name = MenuViewer.keyboard.nextLine();
    System.out.print("전화번호: ");
    info.phoneNumber =MenuViewer.keyboard.nextLine();

  }

  private void readUnivFriendInfo(PhoneUnivInfo uni) {
    System.out.print("이름: ");
    uni.name = MenuViewer.keyboard.nextLine();

    System.out.println("전화번호: ");
    uni.phoneNumber = MenuViewer.keyboard.nextLine();

    System.out.print("전공: ");
    uni.major = MenuViewer.keyboard.nextLine();

    System.out.print("학년: ");
    uni.year = MenuViewer.keyboard.nextInt();
    //버퍼비우기
    MenuViewer.keyboard.nextLine();

  }

  private void readCompanyFriendInfo(PhoneCompanyInfo company) {
    System.out.print("이름: ");
    company.name = MenuViewer.keyboard.nextLine();

    System.out.println("전화번호: ");
    company.phoneNumber = MenuViewer.keyboard.nextLine();

    System.out.println("회사: ");
    company.company = MenuViewer.keyboard.nextLine();
    MenuViewer.keyboard.nextLine();

  }

  public void inputData() throws MenuChoiceException {
    System.out.println("데이터 입력을 시작합니다.");
    System.out.println("1. 일반, 2. 대학, 3. 회사");
    System.out.print("선택>> ");
    int choice = MenuViewer.keyboard.nextInt();
    MenuViewer.keyboard.nextLine();

    if(choice < INPUT_SELECT.NORMAL || choice > INPUT_SELECT.COMPANY) {
      throw new MenuChoiceException(choice);

    }
    PhoneInfo info;
      if (choice == INPUT_SELECT.NORMAL) {
        info = new PhoneInfo("", "");
        readFriendInfo(info);

      } else if (choice == INPUT_SELECT.UNIV) {
        info = new PhoneUnivInfo("", "", "", 0);
        readUnivFriendInfo((PhoneUnivInfo) info);

      } else if (choice == INPUT_SELECT.COMPANY) {
        info = new PhoneCompanyInfo("", "", "");
        readCompanyFriendInfo((PhoneCompanyInfo) info);

      } else {
        System.out.println("잘못된 선택입니다.");
        return;
      }
      infoList.add(info);
      curCnt++;
      System.out.println("데이터 입력이 완료되었습니다. \n");

  }

  public boolean deleteData() throws MenuChoiceException {
    System.out.println("데이터 삭제를 시작합니다.");
    System.out.print("이름 : ");
    String removeName = MenuViewer.keyboard.nextLine();
    for(PhoneInfo info:infoList){
      if(info.name.equals(removeName)){
        boolean remove = infoList.remove(info);
        System.out.println("데이터 삭제가 완료되었습니다. \n");
        return remove;
      }else{
        System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
      }
    }

    return false;
  }

  private int search(String name) {
    for (int idx = 0; idx < infoList.size(); idx++) {
      PhoneInfo curInfo = infoList.get(idx);
      if (name.equals(curInfo.name)) {
        return idx;
      }
    }
    return -1;
  }

  public void searchData() {
    System.out.println("데이터 검색을 시작합니다.");
    System.out.print("이름 : ");
    String searchNumber = MenuViewer.keyboard.nextLine();
    int dataIdx = search(searchNumber);
    if (dataIdx >= 0) {
      infoList.get(dataIdx).showPhoneInfo();
      System.out.println("데이터 검색이 완료되었습니다. \n");
    } else {
      System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
    }
  }

  public void saveToFile(){
    try{
      FileOutputStream file=new FileOutputStream(datafile);
      ObjectOutputStream out=new ObjectOutputStream(file);

      for (PhoneInfo info :PhoneBookManager.infoList) {
        out.writeObject(info);
      }
    }catch(IOException e){
      throw new RuntimeException(e);
    }
  }

  public void readFromFile() throws ClassNotFoundException {
    if(!datafile.exists()){
      return;
    }
    try{
      FileInputStream file=new FileInputStream(datafile);
      ObjectInputStream in=new ObjectInputStream(file);
      while(true){
        PhoneInfo info=(PhoneInfo)in.readObject();
        infoList.add(info);
      }
    } catch (EOFException e){//데이터더이상 없을때 EOFException e만으로도종료, 아무것도안에 안써줌!!
    }catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
