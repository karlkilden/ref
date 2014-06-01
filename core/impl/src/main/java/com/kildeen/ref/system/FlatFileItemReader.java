//package com.kildeen.ref.system;
//
//import com.kildeen.ref.module.fact.FactDTO;
//import org.apache.batchee.extras.typed.NoStateTypedItemReader;
//import org.apache.batchee.extras.typed.TypedItemReader;
//import org.apache.commons.lang3.RandomStringUtils;
//
//import javax.batch.api.chunk.ItemReader;
//import javax.enterprise.context.Dependent;
//import javax.inject.Named;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.Serializable;
//@Named
//@Dependent
//public class FlatFileItemReader extends NoStateTypedItemReader<String> {
//
//
//    @Override
//    protected String doRead() {
//
//        FactDTO dto = new FactDTO();
//
//        dto.setName(RandomStringUtils.random(10));
//        StringBuilder sb = new StringBuilder();
//        for (int j =0; j <10 ; j++) {
//            sb.append(RandomStringUtils.random(10)).append(" ");
//        }
//        return sb.toString();
//    }
//}