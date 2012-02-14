package com.abner.fence.resources;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public final class Messages {
	private static final String BUNDLE_NAME = "com.abner.fence.resources.message";
	private static ResourceBundle bundle;

	static {
		bundle = ResourceBundle.getBundle(BUNDLE_NAME,Locale.ENGLISH);
	}

	public static String getMessage(String name) {
		String value = bundle.getString(name);
		return value == null ? "%" + name + "%" : bundle.getString(name);
	}

	public static String getMessage(String name, Object... param) {
		String pattern = bundle.getString(name);
		if (pattern == null)
			return "%" + name + "%";
		return MessageFormat.format(pattern, param);
	}

	public static String BUNDLE_MAP_NO_PUT_VALUE = "BUNDLE_MAP_NO_PUT_VALUE";
	public static String BUNDLE_MAP_NO_REMOVE_VALUE = "BUNDLE_MAP_NO_REMOVE_VALUE";
	public static String NO_CONVERTER_REGISTERED = "NO_CONVERTER_REGISTERED";
	public static String FOR_TARGETS_NO_AJAX_CONTAINER = "FOR_TARGETS_NO_AJAX_CONTAINER";
	public static String VAR_MUST_BE_LITERAL = "VAR_MUST_BE_LITERAL";
	public static String EVENT_MUST_BE_LITERAL = "EVENT_MUST_BE_LITERAL";
	public static String CREATE_JAVASCRIPT_EVENT = "CREATE_JAVASCRIPT_EVENT";
	public static String CALLED_SET_PARENT = "CALLED_SET_PARENT";
	public static String DETECT_NEW_COMPONENT = "DETECT_NEW_COMPONENT";
	public static String SET_VALUE_BINDING_FOR_EVENT = "SET_VALUE_BINDING_FOR_EVENT";
	public static String COULD_NOT_LOAD_RESOURCE_BUNDLE = "COULD_NOT_LOAD_RESOURCE_BUNDLE";
	public static String FACES_CONTEXT_NOT_CREATED = "FACES_CONTEXT_NOT_CREATED";
	public static String FACES_CONTEXT_HAS_NOT_EXTERNAL = "FACES_CONTEXT_HAS_NOT_EXTERNAL";
	public static String FACES_CONTEXT_HAS_NOT_RESPONSE = "FACES_CONTEXT_HAS_NOT_RESPONSE";
	public static String CREATE_ALTERNATE_HANDLER = "CREATE_ALTERNATE_HANDLER";
	public static String ALTERNATE_HANDLER_CONSTRUCTOR_WARNING = "ALTERNATE_HANDLER_CONSTRUCTOR_WARNING";
	public static String VIEW_HANDLER_INSTANTIATION_ERROR = "VIEW_HANDLER_INSTANTIATION_ERROR";
	public static String ERROR_ON_PAGE = "ERROR_ON_PAGE";
	public static String LIFECYCLE_ERROR = "LIFECYCLE_ERROR";
	public static String LIFECYCLE_ERROR_AT_PHASE = "LIFECYCLE_ERROR_AT_PHASE";
	public static String COMPONENT_TREE_NOT_CREATED = "COMPONENT_TREE_NOT_CREATED";
	public static String SET_AJAX_LISTENER = "SET_AJAX_LISTENER";
	public static String ADD_AJAX_AREA = "ADD_AJAX_AREA";
	public static String ADD_AJAX_AREAS = "ADD_AJAX_AREAS";
	public static String SET_AJAX_REQUEST = "SET_AJAX_REQUEST";
	public static String SUBMITTED_AJAX_REQUEST = "SUBMITTED_AJAX_REQUEST";
	public static String SEND_EVENT_TO_AJAX_LISTENER = "SEND_EVENT_TO_AJAX_LISTENER";
	public static String RENDER_AJAX_REQUEST = "RENDER_AJAX_REQUEST";
	public static String RENDERING_AJAX_REGION_ERROR = "RENDERING_AJAX_REGION_ERROR";
	public static String RESTORE_AJAX_COMPONENT_STATE = "RESTORE_AJAX_COMPONENT_STATE";
	public static String SAVE_AJAX_COMPONENT_STATE = "SAVE_AJAX_COMPONENT_STATE";
	public static String CREATE_AJAX_AREAS_SET_TO_RENDER = "CREATE_AJAX_AREAS_SET_TO_RENDER";
	public static String ARGUMENT_IS_NOT_AJAX_REGION_ERROR = "ARGUMENT_IS_NOT_AJAX_REGION_ERROR";
	public static String NULL_EVENT_SUBMITTED_ERROR = "NULL_EVENT_SUBMITTED_ERROR";
	public static String CONTENT_TYPE_ENCODING = "CONTENT_TYPE_ENCODING";
	public static String CONTENT_TYPE_NO_ENCODING = "CONTENT_TYPE_NO_ENCODING";
	public static String FILTER_START_INFO = "FILTER_START_INFO";
	public static String FILTER_XML_OUTPUT = "FILTER_XML_OUTPUT";
	public static String FILTER_NO_XML_CHAIN = "FILTER_NO_XML_CHAIN";
	public static String FILTER_NO_XML_CHAIN_2 = "FILTER_NO_XML_CHAIN_2";
	public static String FILTER_STOP_INFO = "FILTER_STOP_INFO";
	public static String PARSER_NOT_INSTANTIATED_ERROR = "PARSER_NOT_INSTANTIATED_ERROR";
	public static String PARSING_TIME_INFO = "PARSING_TIME_INFO";
	public static String JTIDY_PARSING_ERROR = "JTIDY_PARSING_ERROR";
	public static String COMPONENT_NOT_FOUND = "COMPONENT_NOT_FOUND";
	public static String EVENT_IS_READ_ONLY = "EVENT_IS_READ_ONLY";
	public static String FLUSH_BUFFERED_STREAM_ERROR = "FLUSH_BUFFERED_STREAM_ERROR";
	public static String UNSUPPORTED_ENCODING_WARNING = "UNSUPPORTED_ENCODING_WARNING";
	public static String UNSUPPORTED_ENCODING_WARNING_2 = "UNSUPPORTED_ENCODING_WARNING_2";
	public static String NO_WRITER_CALLED_INFO = "NO_WRITER_CALLED_INFO";
	public static String PARSE_XML_DOCUMENT_INFO = "PARSE_XML_DOCUMENT_INFO";
	public static String NO_WRITER_POSSIBLE_ERROR = "NO_WRITER_POSSIBLE_ERROR";
	public static String CREATE_WRITER_INFO = "CREATE_WRITER_INFO";
	public static String NO_STREAM_POSSIBLE_ERROR = "NO_STREAM_POSSIBLE_ERROR";
	public static String CREATE_STREAM_INFO = "CREATE_STREAM_INFO";
	public static String OPEN_CLOSE_TAGS_DO_NOT_MATCH_ERROR = "OPEN_CLOSE_TAGS_DO_NOT_MATCH_ERROR";
	public static String VARIABLE_SUBSTITUTION_WARNING = "VARIABLE_SUBSTITUTION_WARNING";
	public static String START_DOCUMENT_SAX_EXCEPTION = "START_DOCUMENT_SAX_EXCEPTION";
	public static String COMMENT_SAX_EXCEPTION = "COMMENT_SAX_EXCEPTION";
	public static String END_ELEMENT_SAX_EXCEPTION = "END_ELEMENT_SAX_EXCEPTION";
	public static String END_DOCUMENT_SAX_EXCEPTION = "END_DOCUMENT_SAX_EXCEPTION";
	public static String START_ELEMENT_SAX_EXCEPTION = "START_ELEMENT_SAX_EXCEPTION";
	public static String TEXT_SAX_EXCEPTION = "TEXT_SAX_EXCEPTION";
	public static String MESSAGE_PARSING_INFO = "MESSAGE_PARSING_INFO";
	public static String CREATE_JTIDY_INFO = "CREATE_JTIDY_INFO";
	public static String READING_TIDY_PROPERTIES_ERROR = "READING_TIDY_PROPERTIES_ERROR";
	public static String ILLEGAL_METHOD_STATE = "ILLEGAL_METHOD_STATE";
	public static String WRAPPED_RULES_NULL_ERROR = "WRAPPED_RULES_NULL_ERROR";
	public static String NO_NAME_ATTRIBUTE_ERROR = "NO_NAME_ATTRIBUTE_ERROR";
	public static String ENCODE_COMPILED_TEMPLATE_INFO = "ENCODE_COMPILED_TEMPLATE_INFO";
	public static String ENCODING_TEMPLATE_TERMINATED_INFO = "ENCODING_TEMPLATE_TERMINATED_INFO";
	public static String ENCODE_COMPILED_TEMPLATE_INFO2 = "ENCODE_COMPILED_TEMPLATE_INFO2";
	public static String CONVERTING_NON_VALUE_HOLDER_COMPONENT_ERROR = "CONVERTING_NON_VALUE_HOLDER_COMPONENT_ERROR";
	public static String COMPONENT_CLASS_ERROR = "COMPONENT_CLASS_ERROR";
	public static String CONTEXT_NULL_ERROR = "CONTEXT_NULL_ERROR";
	public static String COMPONENT_NULL_ERROR = "COMPONENT_NULL_ERROR";
	public static String START_DECODING_COMPONENT_INFO = "START_DECODING_COMPONENT_INFO";
	public static String START_ENCODING_COMPONENT_INFO = "START_ENCODING_COMPONENT_INFO";
	public static String FINISH_ENCODING_COMPONENT_INFO = "FINISH_ENCODING_COMPONENT_INFO";
	public static String NAMESPACE_NOT_RECOGNIZED_ERROR = "NAMESPACE_NOT_RECOGNIZED_ERROR";
	public static String RENDERER_METHOD_NOT_SET_ERROR = "RENDERER_METHOD_NOT_SET_ERROR";
	public static String METHOD_CALL_ERROR_1 = "METHOD_CALL_ERROR_1";
	public static String METHOD_CALL_ERROR_2 = "METHOD_CALL_ERROR_2";
	public static String METHOD_CALL_ERROR_3 = "METHOD_CALL_ERROR_3";
	public static String METHOD_CALL_ERROR_4 = "METHOD_CALL_ERROR_4";
	public static String METHOD_CALL_ERROR_5 = "METHOD_CALL_ERROR_5";
	public static String METHOD_CALL_ERROR_6 = "METHOD_CALL_ERROR_6";
	public static String METHOD_CALL_ERROR_1a = "METHOD_CALL_ERROR_1a";
	public static String METHOD_CALL_ERROR_2a = "METHOD_CALL_ERROR_2a";
	public static String METHOD_CALL_ERROR_3a = "METHOD_CALL_ERROR_3a";
	public static String METHOD_CALL_ERROR_4a = "METHOD_CALL_ERROR_4a";
	public static String METHOD_CALL_ERROR_5a = "METHOD_CALL_ERROR_5a";
	public static String METHOD_CALL_ERROR_6a = "METHOD_CALL_ERROR_6a";
	public static String PARSING_TEMPLATE_ERROR = "PARSING_TEMPLATE_ERROR";
	public static String TEMPLATE_IO_ERROR = "TEMPLATE_IO_ERROR";
	public static String PARSING_TEMPLATE_ERROR_2 = "PARSING_TEMPLATE_ERROR_2";
	public static String START_COMPILE_TEMPLATE_INFO = "START_COMPILE_TEMPLATE_INFO";
	public static String PARSING_TEMPLATE_ERROR_a = "PARSING_TEMPLATE_ERROR_a";
	public static String TEMPLATE_IO_ERROR_a = "TEMPLATE_IO_ERROR_a";
	public static String PARSING_TEMPLATE_ERROR_2a = "PARSING_TEMPLATE_ERROR_2a";
	public static String FINISH_COMPILE_TEMPLATE_INFO = "FINISH_COMPILE_TEMPLATE_INFO";
	public static String TEMPLATE_NOT_COMPILED_ERROR = "TEMPLATE_NOT_COMPILED_ERROR";
	public static String NO_CHILD_ALLOWED = "NO_CHILD_ALLOWED";
	public static String NO_FACET_NAME_ATTRIBUTE = "NO_FACET_NAME_ATTRIBUTE";
	public static String BREAKPOINTS_UNSUPPORTED_ERROR = "BREAKPOINTS_UNSUPPORTED_ERROR";
	public static String BREAKPOINT_NOT_REGISTERED_ERROR = "BREAKPOINT_NOT_REGISTERED_ERROR";
	public static String CHILD_NOT_ALLOWED_ERROR = "CHILD_NOT_ALLOWED_ERROR";
	public static String INVOKE_RENDERER_METHOD_ERROR = "INVOKE_RENDERER_METHOD_ERROR";
	public static String METHOD_CALL_ERROR_2b = "METHOD_CALL_ERROR_2b";
	public static String METHOD_CALL_ERROR_4b = "METHOD_CALL_ERROR_4b";
	public static String METHOD_CALL_ERROR_6b = "METHOD_CALL_ERROR_6b";
	public static String STYLE_ATTRIBUTE_ERROR = "STYLE_ATTRIBUTE_ERROR";
	public static String BREAKPOINTS_UNSUPPORTED_ERROR_2 = "BREAKPOINTS_UNSUPPORTED_ERROR_2";
	public static String BREAKPOINTS_UNSUPPORTED_ERROR_3 = "BREAKPOINTS_UNSUPPORTED_ERROR_3";
	public static String REQUEST_CHAMELEON_RENDER_KIT_INFO = "REQUEST_CHAMELEON_RENDER_KIT_INFO";
	public static String GET_DEFAULT_RENDER_KIT_ERROR = "GET_DEFAULT_RENDER_KIT_ERROR";
	public static String DEFAULT_RENDER_KIT_INFO = "DEFAULT_RENDER_KIT_INFO";
	public static String AJAX_RESPONSE_NOT_RENDERED_INFO = "AJAX_RESPONSE_NOT_RENDERED_INFO";
	public static String ENTER_BEFORE_RENDER_VIEW_PHASE = "ENTER_BEFORE_RENDER_VIEW_PHASE";
	public static String SET_RENDER_KIT_ID_INFO = "SET_RENDER_KIT_ID_INFO";
	public static String PROCESS_AJAX_EVENTS_INFO = "PROCESS_AJAX_EVENTS_INFO";
	public static String DELEGATE_AJAX_PROCESSING_INFO = "DELEGATE_AJAX_PROCESSING_INFO";
	public static String BREAKPOINTS_UNSUPPORTED_INSIDE_ATTRIBUTE_ERROR = "BREAKPOINTS_UNSUPPORTED_INSIDE_ATTRIBUTE_ERROR";
	public static String BUILD_ONCLICK_INFO = "BUILD_ONCLICK_INFO";
	public static String UNNAMED_PARAMETER_ERROR = "UNNAMED_PARAMETER_ERROR";
	public static String AJAX_STATUS_COMPONENT_NOT_FOWND_WARNING = "AJAX_STATUS_COMPONENT_NOT_FOWND_WARNING";
	public static String COMPONENT_NULL_ERROR_2 = "COMPONENT_NULL_ERROR_2";
	public static String CALCULATE_COMPONENT_ID_INFO = "CALCULATE_COMPONENT_ID_INFO";
	public static String DETECTING_ENCODING_DISABLED_ERROR = "DETECTING_ENCODING_DISABLED_ERROR";
	public static String OBTAIN_RESPONSE_SET_HEADER_ERROR = "OBTAIN_RESPONSE_SET_HEADER_ERROR";
	public static String INVOKE_AJAX_REGION_LISTENER = "INVOKE_AJAX_REGION_LISTENER";
	public static String APPENDING_AJAX_REGION_TO_NON_AJAX_CONTAINER_WARNING = "APPENDING_AJAX_REGION_TO_NON_AJAX_CONTAINER_WARNING";
	public static String RENDER_CHILDREN_NON_AJAX_INFO = "RENDER_CHILDREN_NON_AJAX_INFO";
	public static String RENDER_CHILDREN_AJAX_INFO = "RENDER_CHILDREN_AJAX_INFO";
	public static String ENCODE_CHILD_AJAX_INFO = "ENCODE_CHILD_AJAX_INFO";
	public static String RENDER_AJAX_AREA_INFO = "RENDER_AJAX_AREA_INFO";
	public static String DECODE_AJAX_REQUEST_STATUS_INFO = "DECODE_AJAX_REQUEST_STATUS_INFO";
	public static String REQUEST_PARAMETERS_MAP = "REQUEST_PARAMETERS_MAP";
	public static String SET_MYFACES_SEQUENCE_INFO = "SET_MYFACES_SEQUENCE_INFO";
	public static String SKIP_ENCODING_HTML_INFO = "SKIP_ENCODING_HTML_INFO";
	public static String SKIP_ENCODE_BEGIN_HTML_INFO = "SKIP_ENCODE_BEGIN_HTML_INFO";
	public static String SKIP_ENCODE_END_HTML_INFO = "SKIP_ENCODE_END_HTML_INFO";
	public static String QUERY_STRING_BUILDING_ERROR = "QUERY_STRING_BUILDING_ERROR";
	public static String BUILD_RESOURCE_URI_INFO = "BUILD_RESOURCE_URI_INFO";
	public static String RESTORE_DATA_FROM_RESOURCE_URI_INFO = "RESTORE_DATA_FROM_RESOURCE_URI_INFO";
	public static String DESERIALIZE_DATA_INPUT_ERROR = "DESERIALIZE_DATA_INPUT_ERROR";
	public static String DATA_CLASS_NOT_FOUND_ERROR = "DATA_CLASS_NOT_FOUND_ERROR";
	public static String METHOD_NOT_IMPLEMENTED = "METHOD_NOT_IMPLEMENTED";
	public static String ENCODE_HTML_INFO = "ENCODE_HTML_INFO";
	public static String ENCODE_HTML_INFO_2 = "ENCODE_HTML_INFO_2";
	public static String ENCODE_BEGIN_HTML_INFO = "ENCODE_BEGIN_HTML_INFO";
	public static String ENCODE_END_HTML_INFO = "ENCODE_END_HTML_INFO";
	public static String SEND_CONTENT_INFO = "SEND_CONTENT_INFO";
	public static String NO_INPUT_STREAM_ERROR = "NO_INPUT_STREAM_ERROR";
	public static String SET_RESPONSE_HEADERS_INFO = "SET_RESPONSE_HEADERS_INFO";
	public static String BUILD_RESOURCE_INFO = "BUILD_RESOURCE_INFO";
	public static String NO_RESOURCE_REGISTERED_ERROR = "NO_RESOURCE_REGISTERED_ERROR";
	public static String NO_RESOURCE_REGISTERED_ERROR_2 = "NO_RESOURCE_REGISTERED_ERROR_2";
	public static String NO_RESOURCE_EXISTS_ERROR = "NO_RESOURCE_EXISTS_ERROR";
	public static String INSTANTIATE_RESOURCE_ERROR = "INSTANTIATE_RESOURCE_ERROR";
	public static String INSTANTIATE_CLASS_ERROR = "INSTANTIATE_CLASS_ERROR";
	public static String STATIC_RESOURCE_NOT_FOUND_ERROR = "STATIC_RESOURCE_NOT_FOUND_ERROR";
	public static String PARSING_IF_MODIFIED_SINCE_WARNING = "PARSING_IF_MODIFIED_SINCE_WARNING";
	public static String GET_CONTENT_FROM_CACHE_INFO = "GET_CONTENT_FROM_CACHE_INFO";
	public static String CONTENT_NOT_FOUND_ERROR = "CONTENT_NOT_FOUND_ERROR";
	public static String SEND_RESOURCE_ERROR = "SEND_RESOURCE_ERROR";
	public static String SEND_RESOURCE_ERROR_2 = "SEND_RESOURCE_ERROR_2";
	public static String READING_PROPERTIES_ERROR = "READING_PROPERTIES_ERROR";
	public static String SEND_IMAGE_ERROR = "SEND_IMAGE_ERROR";
	public static String SEND_IMAGE_ERROR_2 = "SEND_IMAGE_ERROR_2";
	public static String SKIP_ENCODE_BEGIN_HTML_INFO_2 = "SKIP_ENCODE_BEGIN_HTML_INFO_2";
	public static String MARK_AS_RENDERED_INFO = "MARK_AS_RENDERED_INFO";
	public static String SKIP_ENCODE_END_HTML_INFO_2 = "SKIP_ENCODE_END_HTML_INFO_2";
	public static String VARIABLE_SUBSTITUTION_ERROR = "VARIABLE_SUBSTITUTION_ERROR";
	public static String SET_SKIN_FACTORY_INFO = "SET_SKIN_FACTORY_INFO";
	public static String CREATING_SKIN_FACTORY_ERROR = "CREATING_SKIN_FACTORY_ERROR";
	public static String NULL_SKIN_NAME_ERROR = "NULL_SKIN_NAME_ERROR";
	public static String CREATE_SKIN_INFO = "CREATE_SKIN_INFO";
	public static String DEFAULT_PROPERTIES_NOT_FOUND_ERROR = "DEFAULT_PROPERTIES_NOT_FOUND_ERROR";
	public static String SKIN_PROPERTIES_IO_ERROR = "SKIN_PROPERTIES_IO_ERROR";
	public static String SKIN_NOT_FOUND_ERROR = "SKIN_NOT_FOUND_ERROR";
	public static String ACESSING_SKIN_PROPERTY_AS_ARRAY_ERROR = "ACESSING_SKIN_PROPERTY_AS_ARRAY_ERROR";
	public static String ACESSING_SKIN_PROPERTY_ERROR = "ACESSING_SKIN_PROPERTY_ERROR";
	public static String SKIN_PROPERTIES_READ_ONLY_ERROR = "SKIN_PROPERTIES_READ_ONLY_ERROR";
	public static String NO_VALUE_HOLDER_ERROR = "NO_VALUE_HOLDER_ERROR";
	public static String NO_EDITABLE_VALUE_HOLDER_ERROR = "NO_EDITABLE_VALUE_HOLDER_ERROR";
	public static String INVALID_VALIDATION_EXPRESSION = "INVALID_VALIDATION_EXPRESSION";
	public static String NO_ACTION_SOURCE_ERROR = "NO_ACTION_SOURCE_ERROR";
	public static String INVALID_ACTION_LISTENER = "INVALID_ACTION_LISTENER";
	public static String INVALID_VALUE_CHANGE_LISTENER = "INVALID_VALUE_CHANGE_LISTENER";
	public static String NO_VALUE_REFERENCE_ERROR = "NO_VALUE_REFERENCE_ERROR";
	public static String NO_BYTE_ARRAY_ERROR = "NO_BYTE_ARRAY_ERROR";
	public static String BUFFER_TYPE_ERROR = "BUFFER_TYPE_ERROR";
	public static String IMAGE_ERROR = "IMAGE_ERROR";
	public static String CANNOT_WRITE_RASTERS = "CANNOT_WRITE_RASTERS";
	public static String NULL_OUTPUT_ERROR = "NULL_OUTPUT_ERROR";
	public static String IMAGE_NOT_BUFFERED_ERROR = "IMAGE_NOT_BUFFERED_ERROR";
	public static String NOT_DATA_OUTPUT_ERROR = "NOT_DATA_OUTPUT_ERROR";
	public static String NULL_COLOR_PARAMETER_ERROR = "NULL_COLOR_PARAMETER_ERROR";
	public static String DECODE_COLOR_PARAMETER_ERROR = "DECODE_COLOR_PARAMETER_ERROR";
	public static String NULL_COLOR_PARAMETER_ERROR_2 = "NULL_COLOR_PARAMETER_ERROR_2";
	public static String DECODE_PARAMETER_ERROR = "DECODE_PARAMETER_ERROR";
	public static String IMAGE_GENERATOR_CLASS_NOT_FOUND = "IMAGE_GENERATOR_CLASS_NOT_FOUND";
	public static String CREATING_IMAGE_GENERATOR_ERROR = "CREATING_IMAGE_GENERATOR_ERROR";
	public static String INVALID_COMMENT_INDEX = "INVALID_COMMENT_INDEX";
	public static String LOADING_IMAGE_ERROR = "LOADING_IMAGE_ERROR";
	public static String NOT_INDEXED_IMAGE_ERROR = "NOT_INDEXED_IMAGE_ERROR";
	public static String INVALID_RADIUS = "INVALID_RADIUS";
	public static String INVALID_ATTRIBUTE_VALUE = "INVALID_ATTRIBUTE_VALUE";
	public static String VALUE_BINDING_TYPE_ERROR = "VALUE_BINDING_TYPE_ERROR";
	public static String NO_CONVERTER_FOUND_ERROR = "NO_CONVERTER_FOUND_ERROR";
	public static String GRABBER_ERROR = "GRABBER_ERROR";
	public static String TOOMANY_COLORS_ERROR = "TOOMANY_COLORS_ERROR";
	public static String GET_RESOURCE_AS_STREAM_ERROR = "GET_RESOURCE_AS_STREAM_ERROR";
	public static String PARSING_WEB_XML_IO_ERROR = "PARSING_WEB_XML_IO_ERROR";
	public static String PARSING_WEB_XML_SAX_ERROR = "PARSING_WEB_XML_SAX_ERROR";
	public static String NULL_FILTER_NAME_WARNING = "NULL_FILTER_NAME_WARNING";
	public static String FILTER_NOT_FOUND_ERROR = "FILTER_NOT_FOUND_ERROR";
	public static String FILTER_NOT_CONFIGURED_ERROR = "FILTER_NOT_CONFIGURED_ERROR";
	public static String NO_PREFIX_OR_SUFFIX_IN_FILTER_MAPPING_ERROR = "NO_PREFIX_OR_SUFFIX_IN_FILTER_MAPPING_ERROR";
	public static String CONFIG_INITIALIZATION_ERROR = "CONFIG_INITIALIZATION_ERROR";
	public static String FIELD_READING_ERROR = "FIELD_READING_ERROR";
	public static String CONFIG_INITIALIZATION_ERROR_2 = "CONFIG_INITIALIZATION_ERROR_2";
	public static String DOM_METHOD_NOT_SUPPORTED = "DOM_METHOD_NOT_SUPPORTED";
	public static String METHOD_NOT_SUPPORTED = "METHOD_NOT_SUPPORTED";
	public static String NAMED_ITEM_NOT_FOUND_ERROR = "NAMED_ITEM_NOT_FOUND_ERROR";
	public static String AJAX_SUPPORT_REQUEST_PARAMETER_INFO = "AJAX_SUPPORT_REQUEST_PARAMETER_INFO";
	public static String COMMAND_LINK_SUBMIT_INFO = "COMMAND_LINK_SUBMIT_INFO";
	public static String COMMAND_LINK_NOT_IN_FORM_WARNING = "COMMAND_LINK_NOT_IN_FORM_WARNING";
	public static String MUST_BE_EXPRESSION_ERROR = "MUST_BE_EXPRESSION_ERROR";
	public static String NOT_PARENT_AJAX_CONTAINER_ERROR = "NOT_PARENT_AJAX_CONTAINER_ERROR";
	public static String MUST_BE_LITERAL_ERROR = "MUST_BE_LITERAL_ERROR";
	public static String FACET_TAG_MANY_CHILDREN_ERROR = "FACET_TAG_MANY_CHILDREN_ERROR";
	public static String NO_UI_COMPONENT_TAG_ANCESTOR_ERROR = "NO_UI_COMPONENT_TAG_ANCESTOR_ERROR";
	public static String NO_VALUE_REFERENCE_ERROR_2 = "NO_VALUE_REFERENCE_ERROR_2";
	public static String NULL_TYPE_ATTRIBUTE_ERROR = "NULL_TYPE_ATTRIBUTE_ERROR";
	public static final String NULL_ATTRIBUTE_ERROR = "NULL_ATTRIBUTE_ERROR";
	public static final String AJAX_VIEW_EXPIRED = "AJAX_VIEW_EXPIRED";
	public static final String SKIN_CYCLIC_REFERENCE = "SKIN_CYCLIC_REFERENCE";
	public static final String SKIN_ILLEGAL_REFERENCE = "SKIN_ILLEGAL_REFERENCE";
	public static final String NAME_MUST_BE_LITERAL = "NAME_MUST_BE_LITERAL";
	public static String INSTANTIATE_LISTENER_ERROR = "INSTANTIATE_LISTENER_ERROR";
	public static String NOT_AJAX_CONTAINER_ERROR = "NOT_AJAX_CONTAINER_ERROR";
	public static String INVALID_EXPRESSION = "INVALID_EXPRESSION";
	public static String NOT_INSTANCE_OF_ERROR = "NOT_INSTANCE_OF_ERROR";
	public static String UNSUPPORTED_ENCODING_ERROR = "UNSUPPORTED_ENCODING_ERROR";
	public static String UNSUPPORTED_INPUT_SOURCE_ERROR = "UNSUPPORTED_INPUT_SOURCE_ERROR";
	public static String STRING_CONVERSION_ERROR = "STRING_CONVERSION_ERROR";
	public static String UTF_CONVERSION_ERROR = "UTF_CONVERSION_ERROR";
	public static String READ_ONLY_NODE_ERROR = "READ_ONLY_NODE_ERROR";

	public static void main(String[] args) {
		String m = getMessage(INVALID_ATTRIBUTE_VALUE, "A", "B");
		System.out.println(m);
	}
}
