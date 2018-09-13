package com.backbase.ct.dataloader.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LegalEntityWithUsers {
    private String legalEntityExternalId;
    private String parentLegalEntityExternalId;
    private String legalEntityName;
    private String legalEntityType;

    private @Singular List<User> users;

    public List<String> getAdminUserExternalIds() {
        return filterUserExternalIdsOnRole("admin");
    }

    public List<String> getUserExternalIds() {
        List<String> externalIds = new ArrayList<>();
        if (users != null) {
            Set<String> ids = users.stream()
                .map(User::getExternalId)
                .collect(Collectors.toSet());
            externalIds.addAll(ids);
        }
        return externalIds;
    }

    /**
     * Get users that match the role.
     */
    public List<String> filterUserExternalIdsOnRole(String role) {
        List<String> externalIds = new ArrayList<>();
        if (users != null) {
            Set<String> ids = users.stream()
                .filter(user -> role.equals(user.getRole()))
                .map(User::getExternalId)
                .collect(Collectors.toSet());
            externalIds.addAll(ids);
        }
        return externalIds;
    }
}
