package com.example.talentmanagemnet.dto.test;

import java.util.List;

public record TestCreDto(String name, int passScore, String time, boolean skill, List<QuestionCreDto> questions) {
}
