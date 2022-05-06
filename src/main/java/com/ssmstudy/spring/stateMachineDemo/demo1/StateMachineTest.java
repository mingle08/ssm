package com.ssmstudy.spring.stateMachineDemo.demo1;

public class StateMachineTest {
    public static void main(String[] args) {
        AppContext context = new AppContext();
        context.favorite();
        context.comment("评论: 好文章，360个赞!");
    }
}
