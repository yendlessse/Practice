package com.ohgiraffers.virtualpet.util;

import com.ohgiraffers.virtualpet.domain.User;

import java.util.Scanner;

public class UserUtil {
    // 포인트 체크 및 필요 시 충전
    public static boolean checkAndRecharge(User user) {
        Scanner sc = new Scanner(System.in);
        if (user.getPoints() >= 20) {
            return true; // 충분하면 바로 사용 가능
        }

        System.out.println("⚠️ 포인트가 부족해요! 충전 후 이용해주세요 💰");
        System.out.print("✨ 충전하시겠어요? (예/아니오) 👉 ");
        String choice = sc.nextLine().trim();
        if (choice.equalsIgnoreCase("예")) {
            System.out.print("💰 충전할 포인트를 입력하세요: ");
            try {
                int rechargeAmount = Integer.parseInt(sc.nextLine().trim());
                if (rechargeAmount <= 0) {
                    System.out.println("❌ 올바른 금액을 입력해주세요. 충전 취소!");
                    return false;
                }
                user.addPoints(rechargeAmount);
                System.out.println("✅ 포인트 충전 완료! 현재 포인트: " + user.getPoints() + " 💎");
            } catch (NumberFormatException e) {
                System.out.println("❌ 잘못된 입력이에요. 충전 취소 😢");
                return false;
            }
            return user.getPoints() >= 20; // 충전 후 충분한지 확인
        } else {
            System.out.println("⏸️ 행동이 취소되었습니다. 다음에 이용해주세요!");
            return false;
        }
    }
}
