package com.logicmonitor.research.logserver.streams;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.logicmonitor.research.logserver.indexer.IndexSet;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Strings.emptyToNull;


public interface Stream {
    String DEFAULT_STREAM_ID = "000000000000000000000001";

    enum MatchingType {
        AND,
        OR;

        public static final MatchingType DEFAULT = AND;

        @JsonCreator
        public static MatchingType valueOfOrDefault(String name) {
            return (emptyToNull(name) == null ? DEFAULT : valueOf(name));
        }
    }

    String getTitle();

    String getDescription();

    Boolean getDisabled();

    String getContentPack();

    void setTitle(String title);

    void setDescription(String description);

    void setDisabled(Boolean disabled);

    void setContentPack(String contentPack);

    void setMatchingType(MatchingType matchingType);

    Boolean isPaused();

    Map<String, List<String>> getAlertReceivers();

    Map<String, Object> asMap(List<StreamRule> streamRules);

    List<StreamRule> getStreamRules();

    Set<Output> getOutputs();

    MatchingType getMatchingType();

    boolean isDefaultStream();

    void setDefaultStream(boolean defaultStream);

    boolean getRemoveMatchesFromDefaultStream();

    void setRemoveMatchesFromDefaultStream(boolean removeMatchesFromDefaultStream);

    IndexSet getIndexSet();

    String getIndexSetId();

    void setIndexSetId(String indexSetId);
}
