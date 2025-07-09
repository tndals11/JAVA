package org.example.chapter08;

// 추상 클래스
// : 모바일 애플리케이션
abstract class MobileApp {
    // 추상 메서드 : 실행에 대한 동작 정의
    // - 각 앱 마다 '고유한 실행' 정의 (상속받은 클래스에서 구현)
    abstract void execute();

    // 일반 (구현) 메서드
    void appInfo() {
        System.out.println("This is a mobile app");
    }
}

// == SNS 애플리케이션 == //
class SocialApp extends MobileApp {
    String name; // 인스턴스 필드 (각 객체가 가질 이름 EX. 인스타그램, 카카오톡)
    
    // 초기화
    SocialApp(String name) {
        this.name = name;
    }

    @Override
    void execute() { //실행하다
        System.out.println(name + "app executes");
    }

    @Override
    void appInfo() {
        System.out.println(name + "app is most popular social app");
    }
    
    // 고유한 메서드
    void shareContent(String content) {
        System.out.println(name + "shares : " + content);
    }
}

// == Game 애플리케이션 == //
class GameApp extends MobileApp {
    @Override
    void execute() {
        System.out.println("Game app executes");
    }
}

public class F_Practice {
    public static void main(String[] args) {
        // == 다형성 적용 == //
        // : 업캐스팅
        MobileApp gameApp = new GameApp();
        MobileApp socialApp = new SocialApp("인스타그램");

        // 다형성 적용에 의해 공통된 메서드 호출 가능
        gameApp.execute(); // Game app executes
        gameApp.appInfo(); // (재정의 x, 부모의 행위를 출력)

        socialApp.execute();
        socialApp.appInfo();


        // socialApp.shareContent("images");
        // 업캐스팅 시 하위 클래스의 고유 메서드에 접근 불가

        // == 형 변환 == //
        if (socialApp instanceof GameApp) {
            System.out.println("socialApp이 GameApp 타입의 객체");
            GameApp onlyGame = (GameApp) socialApp;
        } else if (socialApp instanceof SocialApp) {
            System.out.println("socialApp이 SocialApp 타입의 객체");
            SocialApp onlySocial = (SocialApp) socialApp;

            onlySocial.shareContent("images");
        }

        // == 객체 배열 & 다형성 적용 == //
        MobileApp[] apps = {
                new GameApp(),
                new SocialApp("Facebook"),
                new SocialApp("kakaoTalk")
        }; // new Mobile[] 객체가 생성
        
        for (MobileApp app : apps) {
            app.execute();
            app.appInfo();
            
            // MobileApp이 SocialApp을 참조하고 있으면 true값을 반환
            if (app instanceof SocialApp) {
                // 다운 캐스팅
                // MobileApp에는 shareContent가 없으므로 사용을 하려면 SocialApp 으로 다운 캐스팅을 해야한다
                SocialApp specificSocial = (SocialApp) app;
                specificSocial.shareContent("Files");
            }
        }


    }
}
