package annotation;



@MyAnno(value=12,per = Person.P3,anno2 = @MyAnno2,strs={"bbb","aaa"})
@MyAnno3
public class Worker {
    @MyAnno3
    public String name = "aaa";
    @MyAnno3
    public void show(){


    }
}
