package com.kildeen.ref.application.module.fact;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * <p>File created: 2014-04-27 01:08</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class FactServiceMockTest {

    @Mock
    FactRepository mockRepo;

    @InjectMocks
    FactServiceImpl factService;

    @Test
    public void save_should_use_flush() {
        FactDTO dto = new FactDTO();
        factService.save(dto);
        verify(mockRepo, times(1)).saveAndFlush(dto);
        verifyNoMoreInteractions(mockRepo);
    }
}
