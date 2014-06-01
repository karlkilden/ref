//package com.kildeen.ref.system;
//
//import com.kildeen.ref.module.fact.FactDTO;
//import com.kildeen.ref.module.fact.FactService;
//import org.apache.batchee.extras.typed.NoStateTypedItemWriter;
//import org.apache.deltaspike.core.api.provider.BeanProvider;
//import org.apache.deltaspike.jpa.api.transaction.Transactional;
//
//import javax.enterprise.context.Dependent;
//import javax.inject.Inject;
//import javax.inject.Named;
//import java.util.List;
//
//
//@Transactional
//@Named
//@Dependent
//public class FactImportItemWriter extends NoStateTypedItemWriter<FactDTO> {
//    @Inject
//    private FactService factService;
//
//    @Override
//    protected void doWriteItems(List<FactDTO> facts) {
//        for (FactDTO fact : facts) {
//            factService.save(fact);
//        }
//    }
//}