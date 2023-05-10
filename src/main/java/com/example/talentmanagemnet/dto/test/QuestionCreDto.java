package com.example.talentmanagemnet.dto.test;

import java.util.List;

public record QuestionCreDto(String name, List<AnswerCreDto> answers) {
}
