package com.example.mockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArgmentService {


    @Test
    public void test() {
        ArrayList list = mock(ArrayList.class);
        when(list.get(eq(0))).thenReturn("wang");
        assertEquals(list.get(0), "wang");


    }

    @Test
    public void test2(){
        Foo foo = mock(Foo.class);

//        when(foo.function(isA(Parent.class))).thenReturn(100);
        when(foo.function(isA(child1.class))).thenReturn(100);
        int function = foo.function(new child2());
        assertEquals(function,0);
            reset(foo);
//        when(foo.function(new child2())).thenCallRealMethod();
//        int function = foo.function(new child2());
        when(foo.function(any())).thenReturn(200);
        System.out.println(foo.function(new child2()));
        System.out.println(foo.function(new child1()));
//        assertEquals(function,10);


//        assertEquals();

    }




}

 class Foo{

    int function(Parent parent){

        return parent.work();
    }

}

interface  Parent{

    int work();
}

class child1 implements  Parent{

    @Override
    public int work() {
        throw  new RuntimeException();
    }
}
class child2 implements  Parent{

    @Override
    public int work() {
        return 10;
    }
}

