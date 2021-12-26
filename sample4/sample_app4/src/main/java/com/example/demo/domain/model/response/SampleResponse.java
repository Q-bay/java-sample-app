package com.example.demo.domain.model.response;

import java.util.List;

import com.example.demo.domain.model.Hoge;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SampleResponse {

	private List<Hoge> hogeList;
}
