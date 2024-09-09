package com.xz.cloud;

import java.time.ZonedDateTime;

/**
 * @Author xz
 * @CreateDate 2024/8/29 15:02
 * <p>
 * description:
 */
public class main {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}
