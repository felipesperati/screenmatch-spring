package br.com.alura.screenmatch.service.traducao;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("sk-proj-rbtZ9mxg0BIEyYvxmDynlMtj7GS3_XOHaAyLbqMyJV3i3vvcG-" +
                "are3DT6ig4dACjr53qj35u08T3BlbkFJbzFPHCPAY5xxFTvBMs4fObxZii9SXbpg_OpGkWQ_xQWd6i66JGe7t3YEvQioGwnPDYdcm" +
                "MexcA");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}