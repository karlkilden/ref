///*
//* Licensed to the Apache Software Foundation (ASF) under one or more
//* contributor license agreements.  See the NOTICE file distributed with
//* this work for additional information regarding copyright ownership.
//* The ASF licenses this file to You under the Apache License, Version 2.0
//* (the "License"); you may not use this file except in compliance with
//* the License.  You may obtain a copy of the License at
//*
//*   http://www.apache.org/licenses/LICENSE-2.0
//*
//* Unless required by applicable law or agreed to in writing, software
//* distributed under the License is distributed on an "AS IS" BASIS,
//* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//* See the License for the specific language governing permissions and
//* limitations under the License.
//*/
//package com.kildeen.ref.system;
//
//import javax.enterprise.context.Dependent;
//import javax.inject.Named;
//
//import com.kildeen.ref.module.fact.FactDTO;
//import org.apache.batchee.extras.typed.TypedItemProcessor;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
//* @author <a href="mailto:struberg@yahoo.de">Mark Struberg</a>
//*/
//@Named
//@Dependent
//public class CustomerImportItemProcessor extends TypedItemProcessor<String, FactDTO> {
//
//    @Override
//    protected FactDTO doProcessItem(final String s) {
//        FactDTO dto = new FactDTO();
//        dto.setName(RandomStringUtils.random(4));
//        dto.setContent(s);
//        return dto;
//    }
//}