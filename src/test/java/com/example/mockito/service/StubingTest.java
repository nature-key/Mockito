package com.example.mockito.service;

import com.example.mockito.bean.AccountInfo;
import com.example.mockito.dto.AccountDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StubingTest {


    private List<String>  list;




    @BeforeEach
    public  void init(){
        list= Mockito.mock(ArrayList.class);
    }

    @Test
    public  void  test(){

        Mockito.when(list.get(0)).thenReturn("first");

        String str=list.get(0);

        Assertions.assertEquals(str,"first");


    }

    @Test
    public void test1(){
        Mockito.doNothing().when(list).clear();
        list.clear();

        Mockito.verify(list,Mockito.times(1)).clear();


        Mockito.doThrow(RuntimeException.class).when(list).clear();


        try {
            list.clear();

        }catch (Exception e){
            Assertions.assertInstanceOf(RuntimeException.class,e);
        }


    }

    @Test
    public void test2(){
        Mockito.when(list.get(0)).thenReturn("first");
        Mockito.doReturn("second").when(list).get(1);
        Assertions.assertEquals(list.get(0),"first");
        Assertions.assertEquals(list.get(1),"second");


    }

    @Test
    public  void test4(){

        Mockito.when(list.size()).thenReturn(1,2,3,4);

        Assertions.assertEquals(list.size(),1);

    }

    @Test
    public void  test5(){

        Mockito.when(list.get(Mockito.anyInt())).thenAnswer(it->{
            int index = it.getArgument(0, Integer.class);
            return String.valueOf(index*10);
        });
        Assertions.assertEquals(list.get(1),"10");
        Assertions.assertEquals(list.get(99),"990");


    }

    @Test
    public void  test6() throws  Exception{
        AccountDTO accountDTO = Mockito.mock(AccountDTO.class);

        AccountInfo login = accountDTO.login("wang", "jie");
        System.out.println(login);

        Mockito.when(accountDTO.login(Mockito.anyString(),Mockito.anyString())).thenCallRealMethod();


        AccountInfo login1 = accountDTO.login("wangxuan", "jiepi");
        System.out.println(login1);

    }

    @Test
    public void test7(){
//        List list = Mockito.spy(new ArrayList());
        List list = Mockito.spy(ArrayList.class);

        list.add("first");
        list.add("second");

        Assertions.assertEquals(list.get(0),"first");
        Assertions.assertEquals(list.get(1),"second");
        Assertions.assertEquals(list.isEmpty(),false);

        Mockito.when(list.size()).thenReturn(0);
        Mockito.when(list.isEmpty()).thenReturn(true);

        Assertions.assertEquals(list.isEmpty(),true);
        Assertions.assertEquals(list.size(),0);











    }




    @AfterEach
    public void  destory(){
        Mockito.reset(this.list);
    }



}
