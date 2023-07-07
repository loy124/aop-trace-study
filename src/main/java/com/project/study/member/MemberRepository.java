package com.project.study.member;

import com.project.study.utils.annotation.TimeTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class MemberRepository {

    @TimeTrace
    public void findAll(){
        sleep(1500);
    }

    private void sleep(int mills) {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
