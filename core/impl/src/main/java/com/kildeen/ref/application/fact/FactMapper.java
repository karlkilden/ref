package com.kildeen.ref.application.fact;

import com.kildeen.ref.domain.Fact;
import com.kildeen.ref.domain.Word;
import com.kildeen.ref.domain.WordOccurrence;
import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FactMapper extends SimpleQueryInOutMapperBase<Fact, FactDTO> {

    @Inject
    private WordRepository wordRepository;

    @Override
    protected FactDTO toDto(final Fact fact) {
        final FactDTO factDTO = new FactDTO();

        factDTO.setName(fact.getName());

        factDTO.setId(fact.getId());

        factDTO.setVersion(fact.getVersion());

        StringBuilder sb = new StringBuilder();
        for (WordOccurrence wordOccurrence : fact.getWordOccurrences()) {
            sb.append(wordOccurrence.getWord().getString()).append(" ");
        }
        factDTO.setContent(sb.toString().trim());
        return factDTO;
    }

    @Override
    protected Fact toEntity(final FactDTO dto) {
        final Fact fact = new Fact();
        fact.setName(dto.getName());
        if (dto.getContent() != null) {


            String[] words = dto.getContent().split(" ");

            int index = 0;
            for (String word : words) {
                Word w = wordRepository.findOptionalByStringEqual(word.toLowerCase());
                if (w == null) {
                    w = new Word();
                    w.setString(word);
                    wordRepository.save(w);
                }
                fact.addWord(new WordOccurrence(w, index));
            }
        }
        return fact;
    }
}