package com.ohgiraffers.virtualpet.util;

import com.ohgiraffers.virtualpet.domain.Dog;
import com.ohgiraffers.virtualpet.domain.User;
import com.ohgiraffers.virtualpet.persistence.DogRepository;

import java.util.List;

public class ShowUtil {
    // 입양한 강아지 리스트 출력 메소드
    public static void printAdoptedDogs(DogRepository dogRepo) {
        List<Dog> dogs = dogRepo.selectAllDogs();
        if (dogs.isEmpty()) {
            System.out.println("🐶 아직 입양한 강아지가 없습니다! 먼저 입양해주세요.");
            return;
        }
        System.out.println("💖 지금까지 입양한 강아지 목록 🐶");
        for (Dog dog : dogs) {
            System.out.println(" - " + dog.getName());
        }
        System.out.println("==========================================");
    }

    // ===========================================
    // 강아지 상태 출력 메소드
    public static void printDogStatus(Dog dog) {
        System.out.println("\n🐾 " + dog.getName() + " 상태 🐾");
        System.out.println("🍖 배부름: " + dog.getHunger());
        System.out.println("😄 기분: " + dog.getMood());
        System.out.println("💤 체력: " + dog.getEnergy());
        System.out.println("==========================================\n");
    }

    public static void printDogAdopt(){
        System.out.println("            _\n" +
                "           /\\\\_\\_.-----.___  _.._\n" +
                "             / _    _      \\//   \\\n" +
                "            / /      \\       Y--  |\n" +
                "            |  /♥  ♥\\        \\ __/\n" +
                " ___________| _*/__*/_        \\_\n" +
                "/   \\\\      +----.    ____      \\_\n" +
                "\\    ||           \\__/ / /        \\\n" +
                " +---+/               / /        /\\\\\n" +
                "  \\ \\                / /       _/\n" +
                "   '-+----._____,---' /      -'  \\\n" +
                "       \\___________--'            \\\n" +
                "             /                     \\\n" +
                "            /                       \\");


    }

    public static void printDogFace(){
        System.out.println("            _\n" +
                "           /\\\\_\\_.-----.___  _.._\n" +
                "             / _    _      \\//   \\\n" +
                "            / /      \\       Y--  |\n" +
                "            |  /\\  /\\        \\ __/\n" +
                " ___________| _*/__*/_        \\_\n" +
                "/   \\\\      +----.    ____      \\_\n" +
                "\\    ||           \\__/ / /        \\\n" +
                " +---+/               / /        /\\\\\n" +
                "  \\ \\                / /       _/\n" +
                "   '-+----._____,---' /      -'  \\\n" +
                "       \\___________--'            \\\n" +
                "             /                     \\\n" +
                "            /                       \\");
    }

    public static void printsleepDog(){
        System.out.println("              _\n" +
                "            ,/A\\,\n" +
                "          .//`_`\\\\,\n" +
                "        ,//`____-`\\\\,\n" +
                "      ,//`[_ROVER_]`\\\\,\n" +
                "    ,//`=  ==  __-  _`\\\\,\n" +
                "   //|__=  __- == _  __|\\\\\n" +
                "   ` |  __ .-----.  _  | `\n" +
                "     | - _/       \\-   |\n" +
                "     |__  | .-\"-. | __=|\n" +
                "     |  _=|/)   (\\|    |\n" +
                "     |-__ (/ a a \\) -__|\n" +
                "jgs  |___ /`\\_Y_/`\\____|\n" +
                "          \\)8===8(/");
    }

    public static void printeatDog(){
        System.out.println("" +
                "(                   )            \\ \\\n" +
                " \\                 /              \\ \\\n" +
                "  \\ _ _ _ _ _ _ _ /             ___) )\n" +
                "           (__)_     ____      /     \\\n" +
                "              (_)o  /   | \\--._)     /\n" +
                "    _______       __|uu | |   \\   \\_ \\\n" +
                "   /       \\     /      | | __ \\  /_) \\\n" +
                "  /_________\\   (_)_____|_|(____)(_____)\n");
    }

    public static void printplayDog() {
        System.out.println("" +
                "                                  ____\n" +
                "                           .--\"~~\"    ~\"\\___\n" +
                "                          Y              ]  ~~\"\\\n" +
                "                          l   `v.,_    _/'      ]\n" +
                "                           \\   |   7~~\"        /'\n" +
                "                            \\  |  / /~\"------\"~\n" +
                "                          __.} l_/-^-&lt;-.\n" +
                "                     .--\"~      Y     I Y\n" +
                "                    /           l    oj-&lt;______\n" +
                "                   Y       _     ~---~   (   ^ Y\n" +
                "                   l       |~t-.__(    // \\.__.^\n" +
                "                    \\      | |    ~\\      _.^\n" +
                "                     \"-._  | |      \"---\"~\n" +
                "                         Y |-^----------..,__\n" +
                "       .                 | |--.,__   --.,__  ~\"-.\n" +
                "       \\\\                | l l    \"~--.,_  ~--.  \\\n" +
                "        \\\\    _____      |  \\ \\___,      \"-._    /\n" +
                "         \\&gt;-\"~     ~\"-.--j   ~----/          \"--\"\n" +
                "         /        ,--.           Y\n" +
                "       _Y_ /     (    )     ___  |_\n" +
                "    ,-~   \"       \"--\"     \"   ~-&lt; ~-.\n" +
                "   /                    Y         \\   \\\n" +
                "  /          /     .    l          Y  )Y\n" +
                " /     l    /-.____l    !\\,      ) ! / /\n" +
                "Y    / /\"--\" /      \\__/' \\     / /_K-~\n" +
                "`\\__K-\"\\__.-\"              ^.__K-\"");

    }
}
