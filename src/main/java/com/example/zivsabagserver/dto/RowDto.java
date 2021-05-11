package com.example.zivsabagserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RowDto {
    String docType;
    int companyId;
    Date date;
    int docId;
    String sign;
    int amount;

    @Override
    public String toString() {
        return "RowDto{" +
                "docType='" + docType + '\'' +
                ", companyId=" + companyId +
                ", date=" + date +
                ", docId=" + docId +
                ", sign='" + sign + '\'' +
                ", amount=" + amount +
                '}';
    }
}
