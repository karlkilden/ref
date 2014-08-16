package com.kildeen.ref.module.fact;

import com.kildeen.ref.application.MapperUtil;
import com.kildeen.ref.domain.Fact;
import com.kildeen.ref.domain.Word;
import com.kildeen.ref.domain.WordOccurrence;
import com.kildeen.ref.module.authorization.BaseMapper;
import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class FactMapper extends BaseMapper<Fact, FactDTO> {

    @Inject
    private WordService wordService;

    @Inject
    private FactService factService;

    @Inject
    private EntityManager em;

    @Override
    protected Object getPrimaryKey(final FactDTO factDTO) {
        return factDTO.getId();
    }

    @Override
    public FactDTO toDto(final Fact fact) {
        final FactDTO factDTO = new FactDTO();

        MapperUtil.toAuditDTO(factDTO, fact);

        factDTO.setName(fact.getName());
        if (fact.getWordOccurrences() != null) {

            StringBuilder sb = new StringBuilder();
            for (WordOccurrence wordOccurrence : fact.getWordOccurrences()) {
                sb.append(wordOccurrence.getWord().getString()).append(" ");
            }
            factDTO.setContent(sb.toString().trim());
        }
        return factDTO;
    }


    @Override
    public Fact toEntity(final Fact fact, final FactDTO dto) {
        MapperUtil.toAuditEntity(fact, dto);
        fact.setName(dto.getName());
        if (dto.getContent() != null) {
            String[] words = dto.getContent().split(" ");

            int index = 0;
            for (String word : words) {
                Word w = wordService.retrieveByString(word);
                fact.addWord(new WordOccurrence(w, index));
            }
        }

        return fact;
    }

}