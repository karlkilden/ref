package com.kildeen.ref;

import com.kildeen.ref.com.kildeen.ref.domain.Public;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface PersonRepository extends EntityRepository<Public, Long>
{


}