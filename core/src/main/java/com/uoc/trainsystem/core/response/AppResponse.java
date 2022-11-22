package com.uoc.trainsystem.core.response;

import com.uoc.trainsystem.core.dto.ErrorResponseDTO;
import com.uoc.trainsystem.core.dto.MetaDataResponseDTO;
import com.uoc.trainsystem.core.dto.PagingResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AppResponse<T> {

	private T data;
	private MetaDataResponseDTO meta;
	private ErrorResponseDTO error;
	private PagingResponseDTO paging;
	private static final Integer STATUS_CODE_SUCCESS = 1;
	private static final String STATUS_SUCCESS = "Success";
	private static final Integer STATUS_CODE_ERROR = 0;
	private static final String STATUS_ERROR = "Error";

	public static <T> AppResponse<T> ok(T data) {
		MetaDataResponseDTO metaDto = MetaDataResponseDTO.builder().code(STATUS_CODE_SUCCESS).message(STATUS_SUCCESS)
				.build();
		return AppResponse.<T>builder().data(data).meta(metaDto).build();
	}

	public static <T> AppResponse<T> okList(T dataList, int pageSize, int pageNumber, long totalRecords) {
		MetaDataResponseDTO metaDto = MetaDataResponseDTO.builder().code(STATUS_CODE_SUCCESS).message(STATUS_SUCCESS)
				.build();

		PagingResponseDTO pagingDto = PagingResponseDTO.builder().pageNumber(pageNumber).pageSize(pageSize)
				.totalRecords(totalRecords).build();

		return AppResponse.<T>builder().data(dataList).meta(metaDto).paging(pagingDto).build();
	}

	public static <T> AppResponse<T> error(String status, String source, String title, String detail) {
		MetaDataResponseDTO metaDto = MetaDataResponseDTO.builder().code(STATUS_CODE_ERROR).message(STATUS_ERROR)
				.build();

		ErrorResponseDTO errorDto = ErrorResponseDTO.builder().status(status).source(source).title(title).detail(detail)
				.build();

		return AppResponse.<T>builder().data(null).meta(metaDto).error(errorDto).build();
	}

	public static <T> AppResponse<T> error(T data, String status, String source, String title, String detail) {
		MetaDataResponseDTO metaDto = MetaDataResponseDTO.builder().code(STATUS_CODE_ERROR).message(STATUS_ERROR)
				.build();

		ErrorResponseDTO errorDto = ErrorResponseDTO.builder().status(status).source(source).title(title).detail(detail)
				.build();

		return AppResponse.<T>builder().data(data).meta(metaDto).error(errorDto).build();
	}

}
