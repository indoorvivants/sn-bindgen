package libnuklear

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*

object predef:  
  abstract class CEnum[T](using eq: T =:= Int):
    given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
    extension (t: T) def int: CInt = eq.apply(t)
  
  abstract class CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
        
object types:
  import predef.*
  opaque type nk_allocation_type = CUnsignedInt
  object nk_allocation_type extends CEnumU[nk_allocation_type]:
    inline def define(inline a: Long): nk_allocation_type = a.toUInt
    val NK_BUFFER_FIXED = define(0)
    val NK_BUFFER_DYNAMIC = define(1)

  opaque type nk_anti_aliasing = CUnsignedInt
  object nk_anti_aliasing extends CEnumU[nk_anti_aliasing]:
    inline def define(inline a: Long): nk_anti_aliasing = a.toUInt
    val NK_ANTI_ALIASING_OFF = define(0)
    val NK_ANTI_ALIASING_ON = define(1)

  opaque type nk_buffer_allocation_type = CUnsignedInt
  object nk_buffer_allocation_type extends CEnumU[nk_buffer_allocation_type]:
    inline def define(inline a: Long): nk_buffer_allocation_type = a.toUInt
    val NK_BUFFER_FRONT = define(0)
    val NK_BUFFER_BACK = define(1)
    val NK_BUFFER_MAX = define(2)

  opaque type nk_button_behavior = CUnsignedInt
  object nk_button_behavior extends CEnumU[nk_button_behavior]:
    inline def define(inline a: Long): nk_button_behavior = a.toUInt
    val NK_BUTTON_DEFAULT = define(0)
    val NK_BUTTON_REPEATER = define(1)

  opaque type nk_buttons = CUnsignedInt
  object nk_buttons extends CEnumU[nk_buttons]:
    inline def define(inline a: Long): nk_buttons = a.toUInt
    val NK_BUTTON_LEFT = define(0)
    val NK_BUTTON_MIDDLE = define(1)
    val NK_BUTTON_RIGHT = define(2)
    val NK_BUTTON_DOUBLE = define(3)
    val NK_BUTTON_MAX = define(4)

  opaque type nk_chart_event = CUnsignedInt
  object nk_chart_event extends CEnumU[nk_chart_event]:
    inline def define(inline a: Long): nk_chart_event = a.toUInt
    val NK_CHART_HOVERING = define(1)
    val NK_CHART_CLICKED = define(2)

  opaque type nk_chart_type = CUnsignedInt
  object nk_chart_type extends CEnumU[nk_chart_type]:
    inline def define(inline a: Long): nk_chart_type = a.toUInt
    val NK_CHART_LINES = define(0)
    val NK_CHART_COLUMN = define(1)
    val NK_CHART_MAX = define(2)

  opaque type nk_collapse_states = CUnsignedInt
  object nk_collapse_states extends CEnumU[nk_collapse_states]:
    inline def define(inline a: Long): nk_collapse_states = a.toUInt
    val NK_MINIMIZED = define(0)
    val NK_MAXIMIZED = define(1)

  opaque type nk_color_format = CUnsignedInt
  object nk_color_format extends CEnumU[nk_color_format]:
    inline def define(inline a: Long): nk_color_format = a.toUInt
    val NK_RGB = define(0)
    val NK_RGBA = define(1)

  opaque type nk_command_clipping = CUnsignedInt
  object nk_command_clipping extends CEnumU[nk_command_clipping]:
    inline def define(inline a: Long): nk_command_clipping = a.toUInt
    val NK_CLIPPING_OFF = define(0)
    val NK_CLIPPING_ON = define(1)

  opaque type nk_command_type = CUnsignedInt
  object nk_command_type extends CEnumU[nk_command_type]:
    inline def define(inline a: Long): nk_command_type = a.toUInt
    val NK_COMMAND_NOP = define(0)
    val NK_COMMAND_SCISSOR = define(1)
    val NK_COMMAND_LINE = define(2)
    val NK_COMMAND_CURVE = define(3)
    val NK_COMMAND_RECT = define(4)
    val NK_COMMAND_RECT_FILLED = define(5)
    val NK_COMMAND_RECT_MULTI_COLOR = define(6)
    val NK_COMMAND_CIRCLE = define(7)
    val NK_COMMAND_CIRCLE_FILLED = define(8)
    val NK_COMMAND_ARC = define(9)
    val NK_COMMAND_ARC_FILLED = define(10)
    val NK_COMMAND_TRIANGLE = define(11)
    val NK_COMMAND_TRIANGLE_FILLED = define(12)
    val NK_COMMAND_POLYGON = define(13)
    val NK_COMMAND_POLYGON_FILLED = define(14)
    val NK_COMMAND_POLYLINE = define(15)
    val NK_COMMAND_TEXT = define(16)
    val NK_COMMAND_IMAGE = define(17)
    val NK_COMMAND_CUSTOM = define(18)

  opaque type nk_convert_result = CUnsignedInt
  object nk_convert_result extends CEnumU[nk_convert_result]:
    inline def define(inline a: Long): nk_convert_result = a.toUInt
    val NK_CONVERT_SUCCESS = define(0)
    val NK_CONVERT_INVALID_PARAM = define(1)
    val NK_CONVERT_COMMAND_BUFFER_FULL = define(2)
    val NK_CONVERT_VERTEX_BUFFER_FULL = define(4)
    val NK_CONVERT_ELEMENT_BUFFER_FULL = define(8)

  opaque type nk_edit_events = CUnsignedInt
  object nk_edit_events extends CEnumU[nk_edit_events]:
    inline def define(inline a: Long): nk_edit_events = a.toUInt
    val NK_EDIT_ACTIVE = define(1)
    val NK_EDIT_INACTIVE = define(2)
    val NK_EDIT_ACTIVATED = define(4)
    val NK_EDIT_DEACTIVATED = define(8)
    val NK_EDIT_COMMITED = define(16)

  opaque type nk_edit_flags = CUnsignedInt
  object nk_edit_flags extends CEnumU[nk_edit_flags]:
    inline def define(inline a: Long): nk_edit_flags = a.toUInt
    val NK_EDIT_DEFAULT = define(0)
    val NK_EDIT_READ_ONLY = define(1)
    val NK_EDIT_AUTO_SELECT = define(2)
    val NK_EDIT_SIG_ENTER = define(4)
    val NK_EDIT_ALLOW_TAB = define(8)
    val NK_EDIT_NO_CURSOR = define(16)
    val NK_EDIT_SELECTABLE = define(32)
    val NK_EDIT_CLIPBOARD = define(64)
    val NK_EDIT_CTRL_ENTER_NEWLINE = define(128)
    val NK_EDIT_NO_HORIZONTAL_SCROLL = define(256)
    val NK_EDIT_ALWAYS_INSERT_MODE = define(512)
    val NK_EDIT_MULTILINE = define(1024)
    val NK_EDIT_GOTO_END_ON_ACTIVATE = define(2048)

  opaque type nk_edit_types = CUnsignedInt
  object nk_edit_types extends CEnumU[nk_edit_types]:
    inline def define(inline a: Long): nk_edit_types = a.toUInt
    val NK_EDIT_SIMPLE = define(512)
    val NK_EDIT_FIELD = define(608)
    val NK_EDIT_BOX = define(1640)
    val NK_EDIT_EDITOR = define(1128)

  opaque type nk_heading = CUnsignedInt
  object nk_heading extends CEnumU[nk_heading]:
    inline def define(inline a: Long): nk_heading = a.toUInt
    val NK_UP = define(0)
    val NK_RIGHT = define(1)
    val NK_DOWN = define(2)
    val NK_LEFT = define(3)

  opaque type nk_keys = CUnsignedInt
  object nk_keys extends CEnumU[nk_keys]:
    inline def define(inline a: Long): nk_keys = a.toUInt
    val NK_KEY_NONE = define(0)
    val NK_KEY_SHIFT = define(1)
    val NK_KEY_CTRL = define(2)
    val NK_KEY_DEL = define(3)
    val NK_KEY_ENTER = define(4)
    val NK_KEY_TAB = define(5)
    val NK_KEY_BACKSPACE = define(6)
    val NK_KEY_COPY = define(7)
    val NK_KEY_CUT = define(8)
    val NK_KEY_PASTE = define(9)
    val NK_KEY_UP = define(10)
    val NK_KEY_DOWN = define(11)
    val NK_KEY_LEFT = define(12)
    val NK_KEY_RIGHT = define(13)
    val NK_KEY_TEXT_INSERT_MODE = define(14)
    val NK_KEY_TEXT_REPLACE_MODE = define(15)
    val NK_KEY_TEXT_RESET_MODE = define(16)
    val NK_KEY_TEXT_LINE_START = define(17)
    val NK_KEY_TEXT_LINE_END = define(18)
    val NK_KEY_TEXT_START = define(19)
    val NK_KEY_TEXT_END = define(20)
    val NK_KEY_TEXT_UNDO = define(21)
    val NK_KEY_TEXT_REDO = define(22)
    val NK_KEY_TEXT_SELECT_ALL = define(23)
    val NK_KEY_TEXT_WORD_LEFT = define(24)
    val NK_KEY_TEXT_WORD_RIGHT = define(25)
    val NK_KEY_SCROLL_START = define(26)
    val NK_KEY_SCROLL_END = define(27)
    val NK_KEY_SCROLL_DOWN = define(28)
    val NK_KEY_SCROLL_UP = define(29)
    val NK_KEY_MAX = define(30)

  opaque type nk_layout_format = CUnsignedInt
  object nk_layout_format extends CEnumU[nk_layout_format]:
    inline def define(inline a: Long): nk_layout_format = a.toUInt
    val NK_DYNAMIC = define(0)
    val NK_STATIC = define(1)

  opaque type nk_modify = CUnsignedInt
  object nk_modify extends CEnumU[nk_modify]:
    inline def define(inline a: Long): nk_modify = a.toUInt
    val NK_FIXED = define(0)
    val NK_MODIFIABLE = define(1)

  opaque type nk_orientation = CUnsignedInt
  object nk_orientation extends CEnumU[nk_orientation]:
    inline def define(inline a: Long): nk_orientation = a.toUInt
    val NK_VERTICAL = define(0)
    val NK_HORIZONTAL = define(1)

  opaque type nk_panel_flags = CUnsignedInt
  object nk_panel_flags extends CEnumU[nk_panel_flags]:
    inline def define(inline a: Long): nk_panel_flags = a.toUInt
    val NK_WINDOW_BORDER = define(1)
    val NK_WINDOW_MOVABLE = define(2)
    val NK_WINDOW_SCALABLE = define(4)
    val NK_WINDOW_CLOSABLE = define(8)
    val NK_WINDOW_MINIMIZABLE = define(16)
    val NK_WINDOW_NO_SCROLLBAR = define(32)
    val NK_WINDOW_TITLE = define(64)
    val NK_WINDOW_SCROLL_AUTO_HIDE = define(128)
    val NK_WINDOW_BACKGROUND = define(256)
    val NK_WINDOW_SCALE_LEFT = define(512)
    val NK_WINDOW_NO_INPUT = define(1024)

  opaque type nk_panel_row_layout_type = CUnsignedInt
  object nk_panel_row_layout_type extends CEnumU[nk_panel_row_layout_type]:
    inline def define(inline a: Long): nk_panel_row_layout_type = a.toUInt
    val NK_LAYOUT_DYNAMIC_FIXED = define(0)
    val NK_LAYOUT_DYNAMIC_ROW = define(1)
    val NK_LAYOUT_DYNAMIC_FREE = define(2)
    val NK_LAYOUT_DYNAMIC = define(3)
    val NK_LAYOUT_STATIC_FIXED = define(4)
    val NK_LAYOUT_STATIC_ROW = define(5)
    val NK_LAYOUT_STATIC_FREE = define(6)
    val NK_LAYOUT_STATIC = define(7)
    val NK_LAYOUT_TEMPLATE = define(8)
    val NK_LAYOUT_COUNT = define(9)

  opaque type nk_panel_set = CUnsignedInt
  object nk_panel_set extends CEnumU[nk_panel_set]:
    inline def define(inline a: Long): nk_panel_set = a.toUInt
    val NK_PANEL_SET_NONBLOCK = define(240)
    val NK_PANEL_SET_POPUP = define(244)
    val NK_PANEL_SET_SUB = define(246)

  opaque type nk_panel_type = CUnsignedInt
  object nk_panel_type extends CEnumU[nk_panel_type]:
    inline def define(inline a: Long): nk_panel_type = a.toUInt
    val NK_PANEL_NONE = define(0)
    val NK_PANEL_WINDOW = define(1)
    val NK_PANEL_GROUP = define(2)
    val NK_PANEL_POPUP = define(4)
    val NK_PANEL_CONTEXTUAL = define(16)
    val NK_PANEL_COMBO = define(32)
    val NK_PANEL_MENU = define(64)
    val NK_PANEL_TOOLTIP = define(128)

  opaque type nk_popup_type = CUnsignedInt
  object nk_popup_type extends CEnumU[nk_popup_type]:
    inline def define(inline a: Long): nk_popup_type = a.toUInt
    val NK_POPUP_STATIC = define(0)
    val NK_POPUP_DYNAMIC = define(1)

  opaque type nk_show_states = CUnsignedInt
  object nk_show_states extends CEnumU[nk_show_states]:
    inline def define(inline a: Long): nk_show_states = a.toUInt
    val NK_HIDDEN = define(0)
    val NK_SHOWN = define(1)

  opaque type nk_style_colors = CUnsignedInt
  object nk_style_colors extends CEnumU[nk_style_colors]:
    inline def define(inline a: Long): nk_style_colors = a.toUInt
    val NK_COLOR_TEXT = define(0)
    val NK_COLOR_WINDOW = define(1)
    val NK_COLOR_HEADER = define(2)
    val NK_COLOR_BORDER = define(3)
    val NK_COLOR_BUTTON = define(4)
    val NK_COLOR_BUTTON_HOVER = define(5)
    val NK_COLOR_BUTTON_ACTIVE = define(6)
    val NK_COLOR_TOGGLE = define(7)
    val NK_COLOR_TOGGLE_HOVER = define(8)
    val NK_COLOR_TOGGLE_CURSOR = define(9)
    val NK_COLOR_SELECT = define(10)
    val NK_COLOR_SELECT_ACTIVE = define(11)
    val NK_COLOR_SLIDER = define(12)
    val NK_COLOR_SLIDER_CURSOR = define(13)
    val NK_COLOR_SLIDER_CURSOR_HOVER = define(14)
    val NK_COLOR_SLIDER_CURSOR_ACTIVE = define(15)
    val NK_COLOR_PROPERTY = define(16)
    val NK_COLOR_EDIT = define(17)
    val NK_COLOR_EDIT_CURSOR = define(18)
    val NK_COLOR_COMBO = define(19)
    val NK_COLOR_CHART = define(20)
    val NK_COLOR_CHART_COLOR = define(21)
    val NK_COLOR_CHART_COLOR_HIGHLIGHT = define(22)
    val NK_COLOR_SCROLLBAR = define(23)
    val NK_COLOR_SCROLLBAR_CURSOR = define(24)
    val NK_COLOR_SCROLLBAR_CURSOR_HOVER = define(25)
    val NK_COLOR_SCROLLBAR_CURSOR_ACTIVE = define(26)
    val NK_COLOR_TAB_HEADER = define(27)
    val NK_COLOR_COUNT = define(28)

  opaque type nk_style_cursor = CUnsignedInt
  object nk_style_cursor extends CEnumU[nk_style_cursor]:
    inline def define(inline a: Long): nk_style_cursor = a.toUInt
    val NK_CURSOR_ARROW = define(0)
    val NK_CURSOR_TEXT = define(1)
    val NK_CURSOR_MOVE = define(2)
    val NK_CURSOR_RESIZE_VERTICAL = define(3)
    val NK_CURSOR_RESIZE_HORIZONTAL = define(4)
    val NK_CURSOR_RESIZE_TOP_LEFT_DOWN_RIGHT = define(5)
    val NK_CURSOR_RESIZE_TOP_RIGHT_DOWN_LEFT = define(6)
    val NK_CURSOR_COUNT = define(7)

  opaque type nk_style_header_align = CUnsignedInt
  object nk_style_header_align extends CEnumU[nk_style_header_align]:
    inline def define(inline a: Long): nk_style_header_align = a.toUInt
    val NK_HEADER_LEFT = define(0)
    val NK_HEADER_RIGHT = define(1)

  opaque type nk_style_item_type = CUnsignedInt
  object nk_style_item_type extends CEnumU[nk_style_item_type]:
    inline def define(inline a: Long): nk_style_item_type = a.toUInt
    val NK_STYLE_ITEM_COLOR = define(0)
    val NK_STYLE_ITEM_IMAGE = define(1)
    val NK_STYLE_ITEM_NINE_SLICE = define(2)

  opaque type nk_symbol_type = CUnsignedInt
  object nk_symbol_type extends CEnumU[nk_symbol_type]:
    inline def define(inline a: Long): nk_symbol_type = a.toUInt
    val NK_SYMBOL_NONE = define(0)
    val NK_SYMBOL_X = define(1)
    val NK_SYMBOL_UNDERSCORE = define(2)
    val NK_SYMBOL_CIRCLE_SOLID = define(3)
    val NK_SYMBOL_CIRCLE_OUTLINE = define(4)
    val NK_SYMBOL_RECT_SOLID = define(5)
    val NK_SYMBOL_RECT_OUTLINE = define(6)
    val NK_SYMBOL_TRIANGLE_UP = define(7)
    val NK_SYMBOL_TRIANGLE_DOWN = define(8)
    val NK_SYMBOL_TRIANGLE_LEFT = define(9)
    val NK_SYMBOL_TRIANGLE_RIGHT = define(10)
    val NK_SYMBOL_PLUS = define(11)
    val NK_SYMBOL_MINUS = define(12)
    val NK_SYMBOL_MAX = define(13)

  opaque type nk_text_align = CUnsignedInt
  object nk_text_align extends CEnumU[nk_text_align]:
    inline def define(inline a: Long): nk_text_align = a.toUInt
    val NK_TEXT_ALIGN_LEFT = define(1)
    val NK_TEXT_ALIGN_CENTERED = define(2)
    val NK_TEXT_ALIGN_RIGHT = define(4)
    val NK_TEXT_ALIGN_TOP = define(8)
    val NK_TEXT_ALIGN_MIDDLE = define(16)
    val NK_TEXT_ALIGN_BOTTOM = define(32)

  opaque type nk_text_alignment = CUnsignedInt
  object nk_text_alignment extends CEnumU[nk_text_alignment]:
    inline def define(inline a: Long): nk_text_alignment = a.toUInt
    val NK_TEXT_LEFT = define(17)
    val NK_TEXT_CENTERED = define(18)
    val NK_TEXT_RIGHT = define(20)

  opaque type nk_text_edit_mode = CUnsignedInt
  object nk_text_edit_mode extends CEnumU[nk_text_edit_mode]:
    inline def define(inline a: Long): nk_text_edit_mode = a.toUInt
    val NK_TEXT_EDIT_MODE_VIEW = define(0)
    val NK_TEXT_EDIT_MODE_INSERT = define(1)
    val NK_TEXT_EDIT_MODE_REPLACE = define(2)

  opaque type nk_text_edit_type = CUnsignedInt
  object nk_text_edit_type extends CEnumU[nk_text_edit_type]:
    inline def define(inline a: Long): nk_text_edit_type = a.toUInt
    val NK_TEXT_EDIT_SINGLE_LINE = define(0)
    val NK_TEXT_EDIT_MULTI_LINE = define(1)

  opaque type nk_tree_type = CUnsignedInt
  object nk_tree_type extends CEnumU[nk_tree_type]:
    inline def define(inline a: Long): nk_tree_type = a.toUInt
    val NK_TREE_NODE = define(0)
    val NK_TREE_TAB = define(1)

  opaque type nk_widget_layout_states = CUnsignedInt
  object nk_widget_layout_states extends CEnumU[nk_widget_layout_states]:
    inline def define(inline a: Long): nk_widget_layout_states = a.toUInt
    val NK_WIDGET_INVALID = define(0)
    val NK_WIDGET_VALID = define(1)
    val NK_WIDGET_ROM = define(2)

  opaque type nk_widget_states = CUnsignedInt
  object nk_widget_states extends CEnumU[nk_widget_states]:
    inline def define(inline a: Long): nk_widget_states = a.toUInt
    val NK_WIDGET_STATE_MODIFIED = define(2)
    val NK_WIDGET_STATE_INACTIVE = define(4)
    val NK_WIDGET_STATE_ENTERED = define(8)
    val NK_WIDGET_STATE_HOVER = define(16)
    val NK_WIDGET_STATE_ACTIVED = define(32)
    val NK_WIDGET_STATE_LEFT = define(64)
    val NK_WIDGET_STATE_HOVERED = define(18)
    val NK_WIDGET_STATE_ACTIVE = define(34)

  opaque type nk_window_flags = CUnsignedInt
  object nk_window_flags extends CEnumU[nk_window_flags]:
    inline def define(inline a: Long): nk_window_flags = a.toUInt
    val NK_WINDOW_PRIVATE = define(2048)
    val NK_WINDOW_DYNAMIC = define(2048)
    val NK_WINDOW_ROM = define(4096)
    val NK_WINDOW_NOT_INTERACTIVE = define(5120)
    val NK_WINDOW_HIDDEN = define(8192)
    val NK_WINDOW_CLOSED = define(16384)
    val NK_WINDOW_MINIMIZED = define(32768)
    val NK_WINDOW_REMOVE_ROM = define(65536)

  opaque type __builtin_va_list = CString
  object __builtin_va_list: 
    given _tag: Tag[__builtin_va_list] = Tag.Ptr[CChar](Tag.Byte)
    inline def apply(inline o: CString): __builtin_va_list = o

  opaque type _dummy_array428 = CArray[CChar, Nat._1]
  object _dummy_array428: 
    given _tag: Tag[_dummy_array428] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array428 = o

  opaque type _dummy_array429 = CArray[CChar, Nat._1]
  object _dummy_array429: 
    given _tag: Tag[_dummy_array429] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array429 = o

  opaque type _dummy_array430 = CArray[CChar, Nat._1]
  object _dummy_array430: 
    given _tag: Tag[_dummy_array430] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array430 = o

  opaque type _dummy_array431 = CArray[CChar, Nat._1]
  object _dummy_array431: 
    given _tag: Tag[_dummy_array431] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array431 = o

  opaque type _dummy_array432 = CArray[CChar, Nat._1]
  object _dummy_array432: 
    given _tag: Tag[_dummy_array432] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array432 = o

  opaque type _dummy_array433 = CArray[CChar, Nat._1]
  object _dummy_array433: 
    given _tag: Tag[_dummy_array433] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array433 = o

  opaque type _dummy_array434 = CArray[CChar, Nat._1]
  object _dummy_array434: 
    given _tag: Tag[_dummy_array434] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array434 = o

  opaque type _dummy_array435 = CInt
  object _dummy_array435: 
    given _tag: Tag[_dummy_array435] = Tag.Int
    inline def apply(inline o: CInt): _dummy_array435 = o

  opaque type _dummy_array436 = CInt
  object _dummy_array436: 
    given _tag: Tag[_dummy_array436] = Tag.Int
    inline def apply(inline o: CInt): _dummy_array436 = o

  opaque type _dummy_array440 = CArray[CChar, Nat._1]
  object _dummy_array440: 
    given _tag: Tag[_dummy_array440] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array440 = o

  opaque type nk_bool = CInt
  object nk_bool: 
    given _tag: Tag[nk_bool] = Tag.Int
    inline def apply(inline o: CInt): nk_bool = o

  opaque type nk_byte = CUnsignedChar
  object nk_byte: 
    given _tag: Tag[nk_byte] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): nk_byte = o

  opaque type nk_char = CChar
  object nk_char: 
    given _tag: Tag[nk_char] = Tag.Byte
    inline def apply(inline o: CChar): nk_char = o

  opaque type nk_command_custom_callback = Ptr[CFuncPtr6[Ptr[Byte], CShort, CShort, CUnsignedShort, CUnsignedShort, nk_handle, Unit]]
  object nk_command_custom_callback: 
    given _tag: Tag[nk_command_custom_callback] = Tag.Ptr[CFuncPtr6[Ptr[Byte], CShort, CShort, CUnsignedShort, CUnsignedShort, nk_handle, Unit]](Tag.materializeCFuncPtr6[Ptr[Byte], CShort, CShort, CUnsignedShort, CUnsignedShort, nk_handle, Unit])
    inline def apply(inline o: Ptr[CFuncPtr6[Ptr[Byte], CShort, CShort, CUnsignedShort, CUnsignedShort, nk_handle, Unit]]): nk_command_custom_callback = o

  type nk_flags = nk_uint
  object nk_flags: 
    given _tag: Tag[nk_flags] = nk_uint._tag

  opaque type nk_glyph = CArray[CChar, Nat._4]
  object nk_glyph: 
    given _tag: Tag[nk_glyph] = Tag.CArray[CChar, Nat._4](Tag.Byte, Tag.Nat4)
    inline def apply(inline o: CArray[CChar, Nat._4]): nk_glyph = o

  type nk_hash = nk_uint
  object nk_hash: 
    given _tag: Tag[nk_hash] = nk_uint._tag

  opaque type nk_int = CInt
  object nk_int: 
    given _tag: Tag[nk_int] = Tag.Int
    inline def apply(inline o: CInt): nk_int = o

  opaque type nk_plugin_alloc = Ptr[CFuncPtr3[nk_handle, Ptr[Byte], nk_size, Ptr[Byte]]]
  object nk_plugin_alloc: 
    given _tag: Tag[nk_plugin_alloc] = Tag.Ptr[CFuncPtr3[nk_handle, Ptr[Byte], nk_size, Ptr[Byte]]](Tag.materializeCFuncPtr3[nk_handle, Ptr[Byte], nk_size, Ptr[Byte]])
    inline def apply(inline o: Ptr[CFuncPtr3[nk_handle, Ptr[Byte], nk_size, Ptr[Byte]]]): nk_plugin_alloc = o

  opaque type nk_plugin_copy = Ptr[CFuncPtr3[nk_handle, CString, CInt, Unit]]
  object nk_plugin_copy: 
    given _tag: Tag[nk_plugin_copy] = Tag.Ptr[CFuncPtr3[nk_handle, CString, CInt, Unit]](Tag.materializeCFuncPtr3[nk_handle, CString, CInt, Unit])
    inline def apply(inline o: Ptr[CFuncPtr3[nk_handle, CString, CInt, Unit]]): nk_plugin_copy = o

  opaque type nk_plugin_filter = Ptr[CFuncPtr2[Ptr[nk_text_edit], nk_rune, nk_bool]]
  object nk_plugin_filter: 
    given _tag: Tag[nk_plugin_filter] = Tag.Ptr[CFuncPtr2[Ptr[nk_text_edit], nk_rune, nk_bool]](Tag.materializeCFuncPtr2[Ptr[nk_text_edit], nk_rune, nk_bool])
    inline def apply(inline o: Ptr[CFuncPtr2[Ptr[nk_text_edit], nk_rune, nk_bool]]): nk_plugin_filter = o

  opaque type nk_plugin_free = Ptr[CFuncPtr2[nk_handle, Ptr[Byte], Unit]]
  object nk_plugin_free: 
    given _tag: Tag[nk_plugin_free] = Tag.Ptr[CFuncPtr2[nk_handle, Ptr[Byte], Unit]](Tag.materializeCFuncPtr2[nk_handle, Ptr[Byte], Unit])
    inline def apply(inline o: Ptr[CFuncPtr2[nk_handle, Ptr[Byte], Unit]]): nk_plugin_free = o

  opaque type nk_plugin_paste = Ptr[CFuncPtr2[nk_handle, Ptr[nk_text_edit], Unit]]
  object nk_plugin_paste: 
    given _tag: Tag[nk_plugin_paste] = Tag.Ptr[CFuncPtr2[nk_handle, Ptr[nk_text_edit], Unit]](Tag.materializeCFuncPtr2[nk_handle, Ptr[nk_text_edit], Unit])
    inline def apply(inline o: Ptr[CFuncPtr2[nk_handle, Ptr[nk_text_edit], Unit]]): nk_plugin_paste = o

  opaque type nk_ptr = CUnsignedInt
  object nk_ptr: 
    given _tag: Tag[nk_ptr] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): nk_ptr = o

  opaque type nk_query_font_glyph_f = Ptr[CFuncPtr5[nk_handle, Float, Ptr[nk_user_font_glyph], nk_rune, nk_rune, Unit]]
  object nk_query_font_glyph_f: 
    given _tag: Tag[nk_query_font_glyph_f] = Tag.Ptr[CFuncPtr5[nk_handle, Float, Ptr[nk_user_font_glyph], nk_rune, nk_rune, Unit]](Tag.materializeCFuncPtr5[nk_handle, Float, Ptr[nk_user_font_glyph], nk_rune, nk_rune, Unit])
    inline def apply(inline o: Ptr[CFuncPtr5[nk_handle, Float, Ptr[nk_user_font_glyph], nk_rune, nk_rune, Unit]]): nk_query_font_glyph_f = o

  type nk_rune = nk_uint
  object nk_rune: 
    given _tag: Tag[nk_rune] = nk_uint._tag

  opaque type nk_short = CShort
  object nk_short: 
    given _tag: Tag[nk_short] = Tag.Short
    inline def apply(inline o: CShort): nk_short = o

  opaque type nk_size = CUnsignedInt
  object nk_size: 
    given _tag: Tag[nk_size] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): nk_size = o

  opaque type nk_text_width_f = Ptr[CFuncPtr4[nk_handle, Float, CString, CInt, Float]]
  object nk_text_width_f: 
    given _tag: Tag[nk_text_width_f] = Tag.Ptr[CFuncPtr4[nk_handle, Float, CString, CInt, Float]](Tag.materializeCFuncPtr4[nk_handle, Float, CString, CInt, Float])
    inline def apply(inline o: Ptr[CFuncPtr4[nk_handle, Float, CString, CInt, Float]]): nk_text_width_f = o

  opaque type nk_uchar = CUnsignedChar
  object nk_uchar: 
    given _tag: Tag[nk_uchar] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): nk_uchar = o

  opaque type nk_uint = CUnsignedInt
  object nk_uint: 
    given _tag: Tag[nk_uint] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): nk_uint = o

  opaque type nk_ushort = CUnsignedShort
  object nk_ushort: 
    given _tag: Tag[nk_ushort] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): nk_ushort = o
  opaque type nk_allocator = CStruct0
  object nk_allocator:
    given _tag: Tag[nk_allocator] = Tag.materializeCStruct0Tag

  opaque type nk_buffer = CStruct0
  object nk_buffer:
    given _tag: Tag[nk_buffer] = Tag.materializeCStruct0Tag

  opaque type nk_buffer_marker = CStruct2[nk_bool, nk_size]
  object nk_buffer_marker:
    given _tag: Tag[nk_buffer_marker] = Tag.materializeCStruct2Tag[nk_bool, nk_size]
    extension (struct: nk_buffer_marker)
      def active: nk_bool = struct._1
      def offset: nk_size = struct._2

  opaque type nk_chart = CStruct6[CInt, Float, Float, Float, Float, CArray[nk_chart_slot, Nat._4]]
  object nk_chart:
    given _tag: Tag[nk_chart] = Tag.materializeCStruct6Tag[CInt, Float, Float, Float, Float, CArray[nk_chart_slot, Nat._4]]
    extension (struct: nk_chart)
      def slot: CInt = struct._1
      def x: Float = struct._2
      def y: Float = struct._3
      def w: Float = struct._4
      def h: Float = struct._5
      def slots: CArray[nk_chart_slot, Nat._4] = struct._6

  opaque type nk_chart_slot = CStruct9[nk_chart_type, nk_color, nk_color, Float, Float, Float, CInt, nk_vec2, CInt]
  object nk_chart_slot:
    given _tag: Tag[nk_chart_slot] = Tag.materializeCStruct9Tag[nk_chart_type, nk_color, nk_color, Float, Float, Float, CInt, nk_vec2, CInt]
    extension (struct: nk_chart_slot)
      def `type`: nk_chart_type = struct._1
      def color: nk_color = struct._2
      def highlight: nk_color = struct._3
      def min: Float = struct._4
      def max: Float = struct._5
      def range: Float = struct._6
      def count: CInt = struct._7
      def last: nk_vec2 = struct._8
      def index: CInt = struct._9

  opaque type nk_clipboard = CStruct3[nk_handle, nk_plugin_paste, nk_plugin_copy]
  object nk_clipboard:
    given _tag: Tag[nk_clipboard] = Tag.materializeCStruct3Tag[nk_handle, nk_plugin_paste, nk_plugin_copy]
    extension (struct: nk_clipboard)
      def userdata: nk_handle = struct._1
      def paste: nk_plugin_paste = struct._2
      def copy: nk_plugin_copy = struct._3

  opaque type nk_color = CStruct4[nk_byte, nk_byte, nk_byte, nk_byte]
  object nk_color:
    given _tag: Tag[nk_color] = Tag.materializeCStruct4Tag[nk_byte, nk_byte, nk_byte, nk_byte]
    extension (struct: nk_color)
      def r: nk_byte = struct._1
      def g: nk_byte = struct._2
      def b: nk_byte = struct._3
      def a: nk_byte = struct._4

  opaque type nk_colorf = CStruct4[Float, Float, Float, Float]
  object nk_colorf:
    given _tag: Tag[nk_colorf] = Tag.materializeCStruct4Tag[Float, Float, Float, Float]
    extension (struct: nk_colorf)
      def r: Float = struct._1
      def g: Float = struct._2
      def b: Float = struct._3
      def a: Float = struct._4

  opaque type nk_command = CStruct0
  object nk_command:
    given _tag: Tag[nk_command] = Tag.materializeCStruct0Tag

  opaque type nk_command_arc = CStruct7[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, CArray[Float, Nat._2], nk_color]
  object nk_command_arc:
    given _tag: Tag[nk_command_arc] = Tag.materializeCStruct7Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, CArray[Float, Nat._2], nk_color]
    extension (struct: nk_command_arc)
      def header: nk_command = struct._1
      def cx: CShort = struct._2
      def cy: CShort = struct._3
      def r: CUnsignedShort = struct._4
      def line_thickness: CUnsignedShort = struct._5
      def a: CArray[Float, Nat._2] = struct._6
      def color: nk_color = struct._7

  opaque type nk_command_arc_filled = CStruct6[nk_command, CShort, CShort, CUnsignedShort, CArray[Float, Nat._2], nk_color]
  object nk_command_arc_filled:
    given _tag: Tag[nk_command_arc_filled] = Tag.materializeCStruct6Tag[nk_command, CShort, CShort, CUnsignedShort, CArray[Float, Nat._2], nk_color]
    extension (struct: nk_command_arc_filled)
      def header: nk_command = struct._1
      def cx: CShort = struct._2
      def cy: CShort = struct._3
      def r: CUnsignedShort = struct._4
      def a: CArray[Float, Nat._2] = struct._5
      def color: nk_color = struct._6

  opaque type nk_command_buffer = CStruct0
  object nk_command_buffer:
    given _tag: Tag[nk_command_buffer] = Tag.materializeCStruct0Tag

  opaque type nk_command_circle = CStruct7[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, CUnsignedShort, nk_color]
  object nk_command_circle:
    given _tag: Tag[nk_command_circle] = Tag.materializeCStruct7Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, CUnsignedShort, nk_color]
    extension (struct: nk_command_circle)
      def header: nk_command = struct._1
      def x: CShort = struct._2
      def y: CShort = struct._3
      def line_thickness: CUnsignedShort = struct._4
      def w: CUnsignedShort = struct._5
      def h: CUnsignedShort = struct._6
      def color: nk_color = struct._7

  opaque type nk_command_circle_filled = CStruct6[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color]
  object nk_command_circle_filled:
    given _tag: Tag[nk_command_circle_filled] = Tag.materializeCStruct6Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color]
    extension (struct: nk_command_circle_filled)
      def header: nk_command = struct._1
      def x: CShort = struct._2
      def y: CShort = struct._3
      def w: CUnsignedShort = struct._4
      def h: CUnsignedShort = struct._5
      def color: nk_color = struct._6

  opaque type nk_command_curve = CStruct6[nk_command, CUnsignedShort, nk_vec2i, nk_vec2i, CArray[nk_vec2i, Nat._2], nk_color]
  object nk_command_curve:
    given _tag: Tag[nk_command_curve] = Tag.materializeCStruct6Tag[nk_command, CUnsignedShort, nk_vec2i, nk_vec2i, CArray[nk_vec2i, Nat._2], nk_color]
    extension (struct: nk_command_curve)
      def header: nk_command = struct._1
      def line_thickness: CUnsignedShort = struct._2
      def begin: nk_vec2i = struct._3
      def end: nk_vec2i = struct._4
      def ctrl: CArray[nk_vec2i, Nat._2] = struct._5
      def color: nk_color = struct._6

  opaque type nk_command_custom = CStruct7[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_handle, nk_command_custom_callback]
  object nk_command_custom:
    given _tag: Tag[nk_command_custom] = Tag.materializeCStruct7Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_handle, nk_command_custom_callback]
    extension (struct: nk_command_custom)
      def header: nk_command = struct._1
      def x: CShort = struct._2
      def y: CShort = struct._3
      def w: CUnsignedShort = struct._4
      def h: CUnsignedShort = struct._5
      def callback_data: nk_handle = struct._6
      def callback: nk_command_custom_callback = struct._7

  opaque type nk_command_image = CStruct7[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_image, nk_color]
  object nk_command_image:
    given _tag: Tag[nk_command_image] = Tag.materializeCStruct7Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_image, nk_color]
    extension (struct: nk_command_image)
      def header: nk_command = struct._1
      def x: CShort = struct._2
      def y: CShort = struct._3
      def w: CUnsignedShort = struct._4
      def h: CUnsignedShort = struct._5
      def img: nk_image = struct._6
      def col: nk_color = struct._7

  opaque type nk_command_line = CStruct5[nk_command, CUnsignedShort, nk_vec2i, nk_vec2i, nk_color]
  object nk_command_line:
    given _tag: Tag[nk_command_line] = Tag.materializeCStruct5Tag[nk_command, CUnsignedShort, nk_vec2i, nk_vec2i, nk_color]
    extension (struct: nk_command_line)
      def header: nk_command = struct._1
      def line_thickness: CUnsignedShort = struct._2
      def begin: nk_vec2i = struct._3
      def end: nk_vec2i = struct._4
      def color: nk_color = struct._5

  opaque type nk_command_polygon = CStruct5[nk_command, nk_color, CUnsignedShort, CUnsignedShort, CArray[nk_vec2i, Nat._1]]
  object nk_command_polygon:
    given _tag: Tag[nk_command_polygon] = Tag.materializeCStruct5Tag[nk_command, nk_color, CUnsignedShort, CUnsignedShort, CArray[nk_vec2i, Nat._1]]
    extension (struct: nk_command_polygon)
      def header: nk_command = struct._1
      def color: nk_color = struct._2
      def line_thickness: CUnsignedShort = struct._3
      def point_count: CUnsignedShort = struct._4
      def points: CArray[nk_vec2i, Nat._1] = struct._5

  opaque type nk_command_polygon_filled = CStruct4[nk_command, nk_color, CUnsignedShort, CArray[nk_vec2i, Nat._1]]
  object nk_command_polygon_filled:
    given _tag: Tag[nk_command_polygon_filled] = Tag.materializeCStruct4Tag[nk_command, nk_color, CUnsignedShort, CArray[nk_vec2i, Nat._1]]
    extension (struct: nk_command_polygon_filled)
      def header: nk_command = struct._1
      def color: nk_color = struct._2
      def point_count: CUnsignedShort = struct._3
      def points: CArray[nk_vec2i, Nat._1] = struct._4

  opaque type nk_command_polyline = CStruct5[nk_command, nk_color, CUnsignedShort, CUnsignedShort, CArray[nk_vec2i, Nat._1]]
  object nk_command_polyline:
    given _tag: Tag[nk_command_polyline] = Tag.materializeCStruct5Tag[nk_command, nk_color, CUnsignedShort, CUnsignedShort, CArray[nk_vec2i, Nat._1]]
    extension (struct: nk_command_polyline)
      def header: nk_command = struct._1
      def color: nk_color = struct._2
      def line_thickness: CUnsignedShort = struct._3
      def point_count: CUnsignedShort = struct._4
      def points: CArray[nk_vec2i, Nat._1] = struct._5

  opaque type nk_command_rect = CStruct8[nk_command, CUnsignedShort, CUnsignedShort, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color]
  object nk_command_rect:
    given _tag: Tag[nk_command_rect] = Tag.materializeCStruct8Tag[nk_command, CUnsignedShort, CUnsignedShort, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color]
    extension (struct: nk_command_rect)
      def header: nk_command = struct._1
      def rounding: CUnsignedShort = struct._2
      def line_thickness: CUnsignedShort = struct._3
      def x: CShort = struct._4
      def y: CShort = struct._5
      def w: CUnsignedShort = struct._6
      def h: CUnsignedShort = struct._7
      def color: nk_color = struct._8

  opaque type nk_command_rect_filled = CStruct7[nk_command, CUnsignedShort, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color]
  object nk_command_rect_filled:
    given _tag: Tag[nk_command_rect_filled] = Tag.materializeCStruct7Tag[nk_command, CUnsignedShort, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color]
    extension (struct: nk_command_rect_filled)
      def header: nk_command = struct._1
      def rounding: CUnsignedShort = struct._2
      def x: CShort = struct._3
      def y: CShort = struct._4
      def w: CUnsignedShort = struct._5
      def h: CUnsignedShort = struct._6
      def color: nk_color = struct._7

  opaque type nk_command_rect_multi_color = CStruct9[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color, nk_color, nk_color, nk_color]
  object nk_command_rect_multi_color:
    given _tag: Tag[nk_command_rect_multi_color] = Tag.materializeCStruct9Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color, nk_color, nk_color, nk_color]
    extension (struct: nk_command_rect_multi_color)
      def header: nk_command = struct._1
      def x: CShort = struct._2
      def y: CShort = struct._3
      def w: CUnsignedShort = struct._4
      def h: CUnsignedShort = struct._5
      def left: nk_color = struct._6
      def top: nk_color = struct._7
      def bottom: nk_color = struct._8
      def right: nk_color = struct._9

  opaque type nk_command_scissor = CStruct5[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort]
  object nk_command_scissor:
    given _tag: Tag[nk_command_scissor] = Tag.materializeCStruct5Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort]
    extension (struct: nk_command_scissor)
      def header: nk_command = struct._1
      def x: CShort = struct._2
      def y: CShort = struct._3
      def w: CUnsignedShort = struct._4
      def h: CUnsignedShort = struct._5

  opaque type nk_command_text = CStruct11[nk_command, Ptr[nk_user_font], nk_color, nk_color, CShort, CShort, CUnsignedShort, CUnsignedShort, Float, CInt, CArray[CChar, Nat._1]]
  object nk_command_text:
    given _tag: Tag[nk_command_text] = Tag.materializeCStruct11Tag[nk_command, Ptr[nk_user_font], nk_color, nk_color, CShort, CShort, CUnsignedShort, CUnsignedShort, Float, CInt, CArray[CChar, Nat._1]]
    extension (struct: nk_command_text)
      def header: nk_command = struct._1
      def font: Ptr[nk_user_font] = struct._2
      def background: nk_color = struct._3
      def foreground: nk_color = struct._4
      def x: CShort = struct._5
      def y: CShort = struct._6
      def w: CUnsignedShort = struct._7
      def h: CUnsignedShort = struct._8
      def height: Float = struct._9
      def length: CInt = struct._10
      def string: CArray[CChar, Nat._1] = struct._11

  opaque type nk_command_triangle = CStruct6[nk_command, CUnsignedShort, nk_vec2i, nk_vec2i, nk_vec2i, nk_color]
  object nk_command_triangle:
    given _tag: Tag[nk_command_triangle] = Tag.materializeCStruct6Tag[nk_command, CUnsignedShort, nk_vec2i, nk_vec2i, nk_vec2i, nk_color]
    extension (struct: nk_command_triangle)
      def header: nk_command = struct._1
      def line_thickness: CUnsignedShort = struct._2
      def a: nk_vec2i = struct._3
      def b: nk_vec2i = struct._4
      def c: nk_vec2i = struct._5
      def color: nk_color = struct._6

  opaque type nk_command_triangle_filled = CStruct5[nk_command, nk_vec2i, nk_vec2i, nk_vec2i, nk_color]
  object nk_command_triangle_filled:
    given _tag: Tag[nk_command_triangle_filled] = Tag.materializeCStruct5Tag[nk_command, nk_vec2i, nk_vec2i, nk_vec2i, nk_color]
    extension (struct: nk_command_triangle_filled)
      def header: nk_command = struct._1
      def a: nk_vec2i = struct._2
      def b: nk_vec2i = struct._3
      def c: nk_vec2i = struct._4
      def color: nk_color = struct._5

  opaque type nk_config_stack_button_behavior = CStruct2[CInt, CArray[nk_config_stack_button_behavior_element, Nat._8]]
  object nk_config_stack_button_behavior:
    given _tag: Tag[nk_config_stack_button_behavior] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_button_behavior_element, Nat._8]]
    extension (struct: nk_config_stack_button_behavior)
      def head: CInt = struct._1
      def elements: CArray[nk_config_stack_button_behavior_element, Nat._8] = struct._2

  opaque type nk_config_stack_button_behavior_element = CStruct2[Ptr[nk_button_behavior], nk_button_behavior]
  object nk_config_stack_button_behavior_element:
    given _tag: Tag[nk_config_stack_button_behavior_element] = Tag.materializeCStruct2Tag[Ptr[nk_button_behavior], nk_button_behavior]
    extension (struct: nk_config_stack_button_behavior_element)
      def address: Ptr[nk_button_behavior] = struct._1
      def old_value: nk_button_behavior = struct._2

  opaque type nk_config_stack_color = CStruct2[CInt, CArray[nk_config_stack_color_element, Nat.Digit2[Nat._3, Nat._2]]]
  object nk_config_stack_color:
    given _tag: Tag[nk_config_stack_color] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_color_element, Nat.Digit2[Nat._3, Nat._2]]]
    extension (struct: nk_config_stack_color)
      def head: CInt = struct._1
      def elements: CArray[nk_config_stack_color_element, Nat.Digit2[Nat._3, Nat._2]] = struct._2

  opaque type nk_config_stack_color_element = CStruct2[Ptr[nk_color], nk_color]
  object nk_config_stack_color_element:
    given _tag: Tag[nk_config_stack_color_element] = Tag.materializeCStruct2Tag[Ptr[nk_color], nk_color]
    extension (struct: nk_config_stack_color_element)
      def address: Ptr[nk_color] = struct._1
      def old_value: nk_color = struct._2

  opaque type nk_config_stack_flags = CStruct2[CInt, CArray[nk_config_stack_flags_element, Nat.Digit2[Nat._3, Nat._2]]]
  object nk_config_stack_flags:
    given _tag: Tag[nk_config_stack_flags] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_flags_element, Nat.Digit2[Nat._3, Nat._2]]]
    extension (struct: nk_config_stack_flags)
      def head: CInt = struct._1
      def elements: CArray[nk_config_stack_flags_element, Nat.Digit2[Nat._3, Nat._2]] = struct._2

  opaque type nk_config_stack_flags_element = CStruct2[Ptr[nk_flags], nk_flags]
  object nk_config_stack_flags_element:
    given _tag: Tag[nk_config_stack_flags_element] = Tag.materializeCStruct2Tag[Ptr[nk_flags], nk_flags]
    extension (struct: nk_config_stack_flags_element)
      def address: Ptr[nk_flags] = struct._1
      def old_value: nk_flags = struct._2

  opaque type nk_config_stack_float = CStruct2[CInt, CArray[nk_config_stack_float_element, Nat.Digit2[Nat._3, Nat._2]]]
  object nk_config_stack_float:
    given _tag: Tag[nk_config_stack_float] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_float_element, Nat.Digit2[Nat._3, Nat._2]]]
    extension (struct: nk_config_stack_float)
      def head: CInt = struct._1
      def elements: CArray[nk_config_stack_float_element, Nat.Digit2[Nat._3, Nat._2]] = struct._2

  opaque type nk_config_stack_float_element = CStruct2[Ptr[Float], Float]
  object nk_config_stack_float_element:
    given _tag: Tag[nk_config_stack_float_element] = Tag.materializeCStruct2Tag[Ptr[Float], Float]
    extension (struct: nk_config_stack_float_element)
      def address: Ptr[Float] = struct._1
      def old_value: Float = struct._2

  opaque type nk_config_stack_style_item = CStruct2[CInt, CArray[nk_config_stack_style_item_element, Nat.Digit2[Nat._1, Nat._6]]]
  object nk_config_stack_style_item:
    given _tag: Tag[nk_config_stack_style_item] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_style_item_element, Nat.Digit2[Nat._1, Nat._6]]]
    extension (struct: nk_config_stack_style_item)
      def head: CInt = struct._1
      def elements: CArray[nk_config_stack_style_item_element, Nat.Digit2[Nat._1, Nat._6]] = struct._2

  opaque type nk_config_stack_style_item_element = CStruct2[Ptr[nk_style_item], nk_style_item]
  object nk_config_stack_style_item_element:
    given _tag: Tag[nk_config_stack_style_item_element] = Tag.materializeCStruct2Tag[Ptr[nk_style_item], nk_style_item]
    extension (struct: nk_config_stack_style_item_element)
      def address: Ptr[nk_style_item] = struct._1
      def old_value: nk_style_item = struct._2

  opaque type nk_config_stack_user_font = CStruct2[CInt, CArray[nk_config_stack_user_font_element, Nat._8]]
  object nk_config_stack_user_font:
    given _tag: Tag[nk_config_stack_user_font] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_user_font_element, Nat._8]]
    extension (struct: nk_config_stack_user_font)
      def head: CInt = struct._1
      def elements: CArray[nk_config_stack_user_font_element, Nat._8] = struct._2

  opaque type nk_config_stack_user_font_element = CStruct2[Ptr[Ptr[nk_user_font]], Ptr[nk_user_font]]
  object nk_config_stack_user_font_element:
    given _tag: Tag[nk_config_stack_user_font_element] = Tag.materializeCStruct2Tag[Ptr[Ptr[nk_user_font]], Ptr[nk_user_font]]
    extension (struct: nk_config_stack_user_font_element)
      def address: Ptr[Ptr[nk_user_font]] = struct._1
      def old_value: Ptr[nk_user_font] = struct._2

  opaque type nk_config_stack_vec2 = CStruct2[CInt, CArray[nk_config_stack_vec2_element, Nat.Digit2[Nat._1, Nat._6]]]
  object nk_config_stack_vec2:
    given _tag: Tag[nk_config_stack_vec2] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_vec2_element, Nat.Digit2[Nat._1, Nat._6]]]
    extension (struct: nk_config_stack_vec2)
      def head: CInt = struct._1
      def elements: CArray[nk_config_stack_vec2_element, Nat.Digit2[Nat._1, Nat._6]] = struct._2

  opaque type nk_config_stack_vec2_element = CStruct2[Ptr[nk_vec2], nk_vec2]
  object nk_config_stack_vec2_element:
    given _tag: Tag[nk_config_stack_vec2_element] = Tag.materializeCStruct2Tag[Ptr[nk_vec2], nk_vec2]
    extension (struct: nk_config_stack_vec2_element)
      def address: Ptr[nk_vec2] = struct._1
      def old_value: nk_vec2 = struct._2

  opaque type nk_configuration_stacks = CStruct7[nk_config_stack_style_item, nk_config_stack_float, nk_config_stack_vec2, nk_config_stack_flags, nk_config_stack_color, nk_config_stack_user_font, nk_config_stack_button_behavior]
  object nk_configuration_stacks:
    given _tag: Tag[nk_configuration_stacks] = Tag.materializeCStruct7Tag[nk_config_stack_style_item, nk_config_stack_float, nk_config_stack_vec2, nk_config_stack_flags, nk_config_stack_color, nk_config_stack_user_font, nk_config_stack_button_behavior]
    extension (struct: nk_configuration_stacks)
      def style_items: nk_config_stack_style_item = struct._1
      def floats: nk_config_stack_float = struct._2
      def vectors: nk_config_stack_vec2 = struct._3
      def flags: nk_config_stack_flags = struct._4
      def colors: nk_config_stack_color = struct._5
      def fonts: nk_config_stack_user_font = struct._6
      def button_behaviors: nk_config_stack_button_behavior = struct._7

  opaque type nk_context = CStruct0
  object nk_context:
    given _tag: Tag[nk_context] = Tag.materializeCStruct0Tag

  opaque type nk_convert_config = CStruct0
  object nk_convert_config:
    given _tag: Tag[nk_convert_config] = Tag.materializeCStruct0Tag

  opaque type nk_cursor = CStruct3[nk_image, nk_vec2, nk_vec2]
  object nk_cursor:
    given _tag: Tag[nk_cursor] = Tag.materializeCStruct3Tag[nk_image, nk_vec2, nk_vec2]
    extension (struct: nk_cursor)
      def img: nk_image = struct._1
      def size: nk_vec2 = struct._2
      def offset: nk_vec2 = struct._3

  opaque type nk_draw_command = CStruct0
  object nk_draw_command:
    given _tag: Tag[nk_draw_command] = Tag.materializeCStruct0Tag

  opaque type nk_draw_list = CStruct0
  object nk_draw_list:
    given _tag: Tag[nk_draw_list] = Tag.materializeCStruct0Tag

  opaque type nk_draw_null_texture = CStruct2[nk_handle, nk_vec2]
  object nk_draw_null_texture:
    given _tag: Tag[nk_draw_null_texture] = Tag.materializeCStruct2Tag[nk_handle, nk_vec2]
    extension (struct: nk_draw_null_texture)
      def texture: nk_handle = struct._1
      def uv: nk_vec2 = struct._2

  opaque type nk_draw_vertex_layout_element = CStruct0
  object nk_draw_vertex_layout_element:
    given _tag: Tag[nk_draw_vertex_layout_element] = Tag.materializeCStruct0Tag

  opaque type nk_edit_state = CStruct11[nk_hash, CUnsignedInt, CUnsignedInt, CInt, CInt, CInt, CInt, CInt, nk_scroll, CUnsignedChar, CUnsignedChar]
  object nk_edit_state:
    given _tag: Tag[nk_edit_state] = Tag.materializeCStruct11Tag[nk_hash, CUnsignedInt, CUnsignedInt, CInt, CInt, CInt, CInt, CInt, nk_scroll, CUnsignedChar, CUnsignedChar]
    extension (struct: nk_edit_state)
      def name: nk_hash = struct._1
      def seq: CUnsignedInt = struct._2
      def old: CUnsignedInt = struct._3
      def active: CInt = struct._4
      def prev: CInt = struct._5
      def cursor: CInt = struct._6
      def sel_start: CInt = struct._7
      def sel_end: CInt = struct._8
      def scrollbar: nk_scroll = struct._9
      def mode: CUnsignedChar = struct._10
      def single_line: CUnsignedChar = struct._11

  opaque type nk_image = CStruct4[nk_handle, nk_ushort, nk_ushort, CArray[nk_ushort, Nat._4]]
  object nk_image:
    given _tag: Tag[nk_image] = Tag.materializeCStruct4Tag[nk_handle, nk_ushort, nk_ushort, CArray[nk_ushort, Nat._4]]
    extension (struct: nk_image)
      def handle: nk_handle = struct._1
      def w: nk_ushort = struct._2
      def h: nk_ushort = struct._3
      def region: CArray[nk_ushort, Nat._4] = struct._4

  opaque type nk_input = CStruct2[nk_keyboard, nk_mouse]
  object nk_input:
    given _tag: Tag[nk_input] = Tag.materializeCStruct2Tag[nk_keyboard, nk_mouse]
    extension (struct: nk_input)
      def keyboard: nk_keyboard = struct._1
      def mouse: nk_mouse = struct._2

  opaque type nk_key = CStruct2[nk_bool, CUnsignedInt]
  object nk_key:
    given _tag: Tag[nk_key] = Tag.materializeCStruct2Tag[nk_bool, CUnsignedInt]
    extension (struct: nk_key)
      def down: nk_bool = struct._1
      def clicked: CUnsignedInt = struct._2

  opaque type nk_keyboard = CStruct3[CArray[nk_key, Nat.Digit2[Nat._3, Nat._0]], CArray[CChar, Nat.Digit2[Nat._1, Nat._6]], CInt]
  object nk_keyboard:
    given _tag: Tag[nk_keyboard] = Tag.materializeCStruct3Tag[CArray[nk_key, Nat.Digit2[Nat._3, Nat._0]], CArray[CChar, Nat.Digit2[Nat._1, Nat._6]], CInt]
    extension (struct: nk_keyboard)
      def keys: CArray[nk_key, Nat.Digit2[Nat._3, Nat._0]] = struct._1
      def text: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def text_len: CInt = struct._3

  opaque type nk_list_view = CStruct7[CInt, CInt, CInt, CInt, Ptr[nk_context], Ptr[nk_uint], nk_uint]
  object nk_list_view:
    given _tag: Tag[nk_list_view] = Tag.materializeCStruct7Tag[CInt, CInt, CInt, CInt, Ptr[nk_context], Ptr[nk_uint], nk_uint]
    extension (struct: nk_list_view)
      def begin: CInt = struct._1
      def end: CInt = struct._2
      def count: CInt = struct._3
      def total_height: CInt = struct._4
      def ctx: Ptr[nk_context] = struct._5
      def scroll_pointer: Ptr[nk_uint] = struct._6
      def scroll_value: nk_uint = struct._7

  opaque type nk_memory = CStruct2[Ptr[Byte], nk_size]
  object nk_memory:
    given _tag: Tag[nk_memory] = Tag.materializeCStruct2Tag[Ptr[Byte], nk_size]
    extension (struct: nk_memory)
      def ptr: Ptr[Byte] = struct._1
      def size: nk_size = struct._2

  opaque type nk_memory_status = CStruct6[Ptr[Byte], CUnsignedInt, nk_size, nk_size, nk_size, nk_size]
  object nk_memory_status:
    given _tag: Tag[nk_memory_status] = Tag.materializeCStruct6Tag[Ptr[Byte], CUnsignedInt, nk_size, nk_size, nk_size, nk_size]
    extension (struct: nk_memory_status)
      def memory: Ptr[Byte] = struct._1
      def `type`: CUnsignedInt = struct._2
      def size: nk_size = struct._3
      def allocated: nk_size = struct._4
      def needed: nk_size = struct._5
      def calls: nk_size = struct._6

  opaque type nk_menu_state = CStruct5[Float, Float, Float, Float, nk_scroll]
  object nk_menu_state:
    given _tag: Tag[nk_menu_state] = Tag.materializeCStruct5Tag[Float, Float, Float, Float, nk_scroll]
    extension (struct: nk_menu_state)
      def x: Float = struct._1
      def y: Float = struct._2
      def w: Float = struct._3
      def h: Float = struct._4
      def offset: nk_scroll = struct._5

  opaque type nk_mouse = CStruct8[CArray[nk_mouse_button, Nat._4], nk_vec2, nk_vec2, nk_vec2, nk_vec2, CUnsignedChar, CUnsignedChar, CUnsignedChar]
  object nk_mouse:
    given _tag: Tag[nk_mouse] = Tag.materializeCStruct8Tag[CArray[nk_mouse_button, Nat._4], nk_vec2, nk_vec2, nk_vec2, nk_vec2, CUnsignedChar, CUnsignedChar, CUnsignedChar]
    extension (struct: nk_mouse)
      def buttons: CArray[nk_mouse_button, Nat._4] = struct._1
      def pos: nk_vec2 = struct._2
      def prev: nk_vec2 = struct._3
      def delta: nk_vec2 = struct._4
      def scroll_delta: nk_vec2 = struct._5
      def grab: CUnsignedChar = struct._6
      def grabbed: CUnsignedChar = struct._7
      def ungrab: CUnsignedChar = struct._8

  opaque type nk_mouse_button = CStruct3[nk_bool, CUnsignedInt, nk_vec2]
  object nk_mouse_button:
    given _tag: Tag[nk_mouse_button] = Tag.materializeCStruct3Tag[nk_bool, CUnsignedInt, nk_vec2]
    extension (struct: nk_mouse_button)
      def down: nk_bool = struct._1
      def clicked: CUnsignedInt = struct._2
      def clicked_pos: nk_vec2 = struct._3

  opaque type nk_nine_slice = CStruct5[nk_image, nk_ushort, nk_ushort, nk_ushort, nk_ushort]
  object nk_nine_slice:
    given _tag: Tag[nk_nine_slice] = Tag.materializeCStruct5Tag[nk_image, nk_ushort, nk_ushort, nk_ushort, nk_ushort]
    extension (struct: nk_nine_slice)
      def img: nk_image = struct._1
      def l: nk_ushort = struct._2
      def t: nk_ushort = struct._3
      def r: nk_ushort = struct._4
      def b: nk_ushort = struct._5

  opaque type nk_page = CStruct3[CUnsignedInt, Ptr[Byte], CArray[nk_page_element, Nat._1]]
  object nk_page:
    given _tag: Tag[nk_page] = Tag.materializeCStruct3Tag[CUnsignedInt, Ptr[Byte], CArray[nk_page_element, Nat._1]]
    extension (struct: nk_page)
      def size: CUnsignedInt = struct._1
      def next: Ptr[nk_page] = struct._2.asInstanceOf[Ptr[nk_page]]
      def win: CArray[nk_page_element, Nat._1] = struct._3

  opaque type nk_page_element = CStruct3[nk_page_data, Ptr[Byte], Ptr[Byte]]
  object nk_page_element:
    given _tag: Tag[nk_page_element] = Tag.materializeCStruct3Tag[nk_page_data, Ptr[Byte], Ptr[Byte]]
    extension (struct: nk_page_element)
      def data: nk_page_data = struct._1
      def next: Ptr[nk_page_element] = struct._2.asInstanceOf[Ptr[nk_page_element]]
      def prev: Ptr[nk_page_element] = struct._3.asInstanceOf[Ptr[nk_page_element]]

  opaque type nk_panel = CStruct0
  object nk_panel:
    given _tag: Tag[nk_panel] = Tag.materializeCStruct0Tag

  opaque type nk_pool = CStruct8[nk_allocator, nk_allocation_type, CUnsignedInt, Ptr[nk_page], Ptr[nk_page_element], CUnsignedInt, nk_size, nk_size]
  object nk_pool:
    given _tag: Tag[nk_pool] = Tag.materializeCStruct8Tag[nk_allocator, nk_allocation_type, CUnsignedInt, Ptr[nk_page], Ptr[nk_page_element], CUnsignedInt, nk_size, nk_size]
    extension (struct: nk_pool)
      def alloc: nk_allocator = struct._1
      def `type`: nk_allocation_type = struct._2
      def page_count: CUnsignedInt = struct._3
      def pages: Ptr[nk_page] = struct._4
      def freelist: Ptr[nk_page_element] = struct._5
      def capacity: CUnsignedInt = struct._6
      def size: nk_size = struct._7
      def cap: nk_size = struct._8

  opaque type nk_popup_buffer = CStruct5[nk_size, nk_size, nk_size, nk_size, nk_bool]
  object nk_popup_buffer:
    given _tag: Tag[nk_popup_buffer] = Tag.materializeCStruct5Tag[nk_size, nk_size, nk_size, nk_size, nk_bool]
    extension (struct: nk_popup_buffer)
      def begin: nk_size = struct._1
      def parent: nk_size = struct._2
      def last: nk_size = struct._3
      def end: nk_size = struct._4
      def active: nk_bool = struct._5

  opaque type nk_popup_state = CStruct10[Ptr[nk_window], nk_panel_type, nk_popup_buffer, nk_hash, nk_bool, CUnsignedInt, CUnsignedInt, CUnsignedInt, CUnsignedInt, nk_rect]
  object nk_popup_state:
    given _tag: Tag[nk_popup_state] = Tag.materializeCStruct10Tag[Ptr[nk_window], nk_panel_type, nk_popup_buffer, nk_hash, nk_bool, CUnsignedInt, CUnsignedInt, CUnsignedInt, CUnsignedInt, nk_rect]
    extension (struct: nk_popup_state)
      def win: Ptr[nk_window] = struct._1
      def `type`: nk_panel_type = struct._2
      def buf: nk_popup_buffer = struct._3
      def name: nk_hash = struct._4
      def active: nk_bool = struct._5
      def combo_count: CUnsignedInt = struct._6
      def con_count: CUnsignedInt = struct._7
      def con_old: CUnsignedInt = struct._8
      def active_con: CUnsignedInt = struct._9
      def header: nk_rect = struct._10

  opaque type nk_property_state = CStruct11[CInt, CInt, CArray[CChar, Nat.Digit2[Nat._6, Nat._4]], CInt, CInt, CInt, CInt, nk_hash, CUnsignedInt, CUnsignedInt, CInt]
  object nk_property_state:
    given _tag: Tag[nk_property_state] = Tag.materializeCStruct11Tag[CInt, CInt, CArray[CChar, Nat.Digit2[Nat._6, Nat._4]], CInt, CInt, CInt, CInt, nk_hash, CUnsignedInt, CUnsignedInt, CInt]
    extension (struct: nk_property_state)
      def active: CInt = struct._1
      def prev: CInt = struct._2
      def buffer: CArray[CChar, Nat.Digit2[Nat._6, Nat._4]] = struct._3
      def length: CInt = struct._4
      def cursor: CInt = struct._5
      def select_start: CInt = struct._6
      def select_end: CInt = struct._7
      def name: nk_hash = struct._8
      def seq: CUnsignedInt = struct._9
      def old: CUnsignedInt = struct._10
      def state: CInt = struct._11

  opaque type nk_rect = CStruct4[Float, Float, Float, Float]
  object nk_rect:
    given _tag: Tag[nk_rect] = Tag.materializeCStruct4Tag[Float, Float, Float, Float]
    extension (struct: nk_rect)
      def x: Float = struct._1
      def y: Float = struct._2
      def w: Float = struct._3
      def h: Float = struct._4

  opaque type nk_recti = CStruct4[CShort, CShort, CShort, CShort]
  object nk_recti:
    given _tag: Tag[nk_recti] = Tag.materializeCStruct4Tag[CShort, CShort, CShort, CShort]
    extension (struct: nk_recti)
      def x: CShort = struct._1
      def y: CShort = struct._2
      def w: CShort = struct._3
      def h: CShort = struct._4

  opaque type nk_row_layout = CStruct13[nk_panel_row_layout_type, CInt, Float, Float, CInt, Ptr[Float], Float, Float, Float, Float, nk_rect, CInt, CArray[Float, Nat.Digit2[Nat._1, Nat._6]]]
  object nk_row_layout:
    given _tag: Tag[nk_row_layout] = Tag.materializeCStruct13Tag[nk_panel_row_layout_type, CInt, Float, Float, CInt, Ptr[Float], Float, Float, Float, Float, nk_rect, CInt, CArray[Float, Nat.Digit2[Nat._1, Nat._6]]]
    extension (struct: nk_row_layout)
      def `type`: nk_panel_row_layout_type = struct._1
      def index: CInt = struct._2
      def height: Float = struct._3
      def min_height: Float = struct._4
      def columns: CInt = struct._5
      def ratio: Ptr[Float] = struct._6
      def item_width: Float = struct._7
      def item_height: Float = struct._8
      def item_offset: Float = struct._9
      def filled: Float = struct._10
      def item: nk_rect = struct._11
      def tree_depth: CInt = struct._12
      def templates: CArray[Float, Nat.Digit2[Nat._1, Nat._6]] = struct._13

  opaque type nk_scroll = CStruct2[nk_uint, nk_uint]
  object nk_scroll:
    given _tag: Tag[nk_scroll] = Tag.materializeCStruct2Tag[nk_uint, nk_uint]
    extension (struct: nk_scroll)
      def x: nk_uint = struct._1
      def y: nk_uint = struct._2

  opaque type nk_str = CStruct2[nk_buffer, CInt]
  object nk_str:
    given _tag: Tag[nk_str] = Tag.materializeCStruct2Tag[nk_buffer, CInt]
    extension (struct: nk_str)
      def buffer: nk_buffer = struct._1
      def len: CInt = struct._2

  opaque type nk_style = CStruct22[Ptr[nk_user_font], CArray[Ptr[nk_cursor], Nat._7], Ptr[nk_cursor], Ptr[nk_cursor], CInt, nk_style_text, nk_style_button, nk_style_button, nk_style_button, nk_style_toggle, nk_style_toggle, nk_style_selectable, nk_style_slider, nk_style_progress, nk_style_property, nk_style_edit, nk_style_chart, nk_style_scrollbar, nk_style_scrollbar, nk_style_tab, nk_style_combo, nk_style_window]
  object nk_style:
    given _tag: Tag[nk_style] = Tag.materializeCStruct22Tag[Ptr[nk_user_font], CArray[Ptr[nk_cursor], Nat._7], Ptr[nk_cursor], Ptr[nk_cursor], CInt, nk_style_text, nk_style_button, nk_style_button, nk_style_button, nk_style_toggle, nk_style_toggle, nk_style_selectable, nk_style_slider, nk_style_progress, nk_style_property, nk_style_edit, nk_style_chart, nk_style_scrollbar, nk_style_scrollbar, nk_style_tab, nk_style_combo, nk_style_window]
    extension (struct: nk_style)
      def font: Ptr[nk_user_font] = struct._1
      def cursors: CArray[Ptr[nk_cursor], Nat._7] = struct._2
      def cursor_active: Ptr[nk_cursor] = struct._3
      def cursor_last: Ptr[nk_cursor] = struct._4
      def cursor_visible: CInt = struct._5
      def text: nk_style_text = struct._6
      def button: nk_style_button = struct._7
      def contextual_button: nk_style_button = struct._8
      def menu_button: nk_style_button = struct._9
      def option: nk_style_toggle = struct._10
      def checkbox: nk_style_toggle = struct._11
      def selectable: nk_style_selectable = struct._12
      def slider: nk_style_slider = struct._13
      def progress: nk_style_progress = struct._14
      def property: nk_style_property = struct._15
      def edit: nk_style_edit = struct._16
      def chart: nk_style_chart = struct._17
      def scrollh: nk_style_scrollbar = struct._18
      def scrollv: nk_style_scrollbar = struct._19
      def tab: nk_style_tab = struct._20
      def combo: nk_style_combo = struct._21
      def window: nk_style_window = struct._22

  opaque type nk_style_button = CStruct0
  object nk_style_button:
    given _tag: Tag[nk_style_button] = Tag.materializeCStruct0Tag

  opaque type nk_style_chart = CStruct0
  object nk_style_chart:
    given _tag: Tag[nk_style_chart] = Tag.materializeCStruct0Tag

  opaque type nk_style_combo = CStruct0
  object nk_style_combo:
    given _tag: Tag[nk_style_combo] = Tag.materializeCStruct0Tag

  opaque type nk_style_edit = CStruct0
  object nk_style_edit:
    given _tag: Tag[nk_style_edit] = Tag.materializeCStruct0Tag

  opaque type nk_style_item = CStruct0
  object nk_style_item:
    given _tag: Tag[nk_style_item] = Tag.materializeCStruct0Tag

  opaque type nk_style_progress = CStruct0
  object nk_style_progress:
    given _tag: Tag[nk_style_progress] = Tag.materializeCStruct0Tag

  opaque type nk_style_property = CStruct0
  object nk_style_property:
    given _tag: Tag[nk_style_property] = Tag.materializeCStruct0Tag

  opaque type nk_style_scrollbar = CStruct0
  object nk_style_scrollbar:
    given _tag: Tag[nk_style_scrollbar] = Tag.materializeCStruct0Tag

  opaque type nk_style_selectable = CStruct0
  object nk_style_selectable:
    given _tag: Tag[nk_style_selectable] = Tag.materializeCStruct0Tag

  opaque type nk_style_slide = CStruct0
  object nk_style_slide:
    given _tag: Tag[nk_style_slide] = Tag.materializeCStruct0Tag

  opaque type nk_style_slider = CArray[Byte, Nat.Digit2[Nat._9, Nat._6]]
  object nk_style_slider:
    given _tag: Tag[nk_style_slider] = Tag.CArray[CChar, Nat.Digit2[Nat._9, Nat._6]](Tag.Byte, Tag.Digit2[Nat._9, Nat._6](Tag.Nat9, Tag.Nat6))
    extension (struct: nk_style_slider)
      def normal: nk_style_item = !struct.at(0).asInstanceOf[Ptr[nk_style_item]]
      def hover: nk_style_item = !struct.at(0).asInstanceOf[Ptr[nk_style_item]]
      def active: nk_style_item = !struct.at(0).asInstanceOf[Ptr[nk_style_item]]
      def border_color: nk_color = !struct.at(0).asInstanceOf[Ptr[nk_color]]
      def bar_normal: nk_color = !struct.at(4).asInstanceOf[Ptr[nk_color]]
      def bar_hover: nk_color = !struct.at(8).asInstanceOf[Ptr[nk_color]]
      def bar_active: nk_color = !struct.at(12).asInstanceOf[Ptr[nk_color]]
      def bar_filled: nk_color = !struct.at(16).asInstanceOf[Ptr[nk_color]]
      def cursor_normal: nk_style_item = !struct.at(20).asInstanceOf[Ptr[nk_style_item]]
      def cursor_hover: nk_style_item = !struct.at(20).asInstanceOf[Ptr[nk_style_item]]
      def cursor_active: nk_style_item = !struct.at(20).asInstanceOf[Ptr[nk_style_item]]
      def border: Float = !struct.at(20).asInstanceOf[Ptr[Float]]
      def rounding: Float = !struct.at(24).asInstanceOf[Ptr[Float]]
      def bar_height: Float = !struct.at(28).asInstanceOf[Ptr[Float]]
      def padding: nk_vec2 = !struct.at(32).asInstanceOf[Ptr[nk_vec2]]
      def spacing: nk_vec2 = !struct.at(40).asInstanceOf[Ptr[nk_vec2]]
      def cursor_size: nk_vec2 = !struct.at(48).asInstanceOf[Ptr[nk_vec2]]
      def show_buttons: CInt = !struct.at(56).asInstanceOf[Ptr[CInt]]
      def inc_button: nk_style_button = !struct.at(60).asInstanceOf[Ptr[nk_style_button]]
      def dec_button: nk_style_button = !struct.at(60).asInstanceOf[Ptr[nk_style_button]]
      def inc_symbol: nk_symbol_type = !struct.at(60).asInstanceOf[Ptr[nk_symbol_type]]
      def dec_symbol: nk_symbol_type = !struct.at(64).asInstanceOf[Ptr[nk_symbol_type]]
      def userdata: nk_handle = !struct.at(68).asInstanceOf[Ptr[nk_handle]]
      def draw_begin: Ptr[CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]] = !struct.at(80).asInstanceOf[Ptr[Ptr[CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]]]
      def draw_end: Ptr[CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]] = !struct.at(88).asInstanceOf[Ptr[Ptr[CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]]]

  opaque type nk_style_tab = CStruct0
  object nk_style_tab:
    given _tag: Tag[nk_style_tab] = Tag.materializeCStruct0Tag

  opaque type nk_style_text = CStruct2[nk_color, nk_vec2]
  object nk_style_text:
    given _tag: Tag[nk_style_text] = Tag.materializeCStruct2Tag[nk_color, nk_vec2]
    extension (struct: nk_style_text)
      def color: nk_color = struct._1
      def padding: nk_vec2 = struct._2

  opaque type nk_style_toggle = CStruct0
  object nk_style_toggle:
    given _tag: Tag[nk_style_toggle] = Tag.materializeCStruct0Tag

  opaque type nk_style_window = CStruct0
  object nk_style_window:
    given _tag: Tag[nk_style_window] = Tag.materializeCStruct0Tag

  opaque type nk_style_window_header = CStruct0
  object nk_style_window_header:
    given _tag: Tag[nk_style_window_header] = Tag.materializeCStruct0Tag

  opaque type nk_table = CStruct0
  object nk_table:
    given _tag: Tag[nk_table] = Tag.materializeCStruct0Tag

  opaque type nk_text_edit = CStruct0
  object nk_text_edit:
    given _tag: Tag[nk_text_edit] = Tag.materializeCStruct0Tag

  opaque type nk_text_undo_record = CStruct4[CInt, CShort, CShort, CShort]
  object nk_text_undo_record:
    given _tag: Tag[nk_text_undo_record] = Tag.materializeCStruct4Tag[CInt, CShort, CShort, CShort]
    extension (struct: nk_text_undo_record)
      def where: CInt = struct._1
      def insert_length: CShort = struct._2
      def delete_length: CShort = struct._3
      def char_storage: CShort = struct._4

  opaque type nk_text_undo_state = CStruct6[CArray[nk_text_undo_record, Nat.Digit2[Nat._9, Nat._9]], CArray[nk_rune, Nat.Digit3[Nat._9, Nat._9, Nat._9]], CShort, CShort, CShort, CShort]
  object nk_text_undo_state:
    given _tag: Tag[nk_text_undo_state] = Tag.materializeCStruct6Tag[CArray[nk_text_undo_record, Nat.Digit2[Nat._9, Nat._9]], CArray[nk_rune, Nat.Digit3[Nat._9, Nat._9, Nat._9]], CShort, CShort, CShort, CShort]
    extension (struct: nk_text_undo_state)
      def undo_rec: CArray[nk_text_undo_record, Nat.Digit2[Nat._9, Nat._9]] = struct._1
      def undo_char: CArray[nk_rune, Nat.Digit3[Nat._9, Nat._9, Nat._9]] = struct._2
      def undo_point: CShort = struct._3
      def redo_point: CShort = struct._4
      def undo_char_point: CShort = struct._5
      def redo_char_point: CShort = struct._6

  opaque type nk_user_font = CStruct0
  object nk_user_font:
    given _tag: Tag[nk_user_font] = Tag.materializeCStruct0Tag

  opaque type nk_user_font_glyph = CStruct0
  object nk_user_font_glyph:
    given _tag: Tag[nk_user_font_glyph] = Tag.materializeCStruct0Tag

  opaque type nk_vec2 = CStruct2[Float, Float]
  object nk_vec2:
    given _tag: Tag[nk_vec2] = Tag.materializeCStruct2Tag[Float, Float]
    extension (struct: nk_vec2)
      def x: Float = struct._1
      def y: Float = struct._2

  opaque type nk_vec2i = CStruct2[CShort, CShort]
  object nk_vec2i:
    given _tag: Tag[nk_vec2i] = Tag.materializeCStruct2Tag[CShort, CShort]
    extension (struct: nk_vec2i)
      def x: CShort = struct._1
      def y: CShort = struct._2

  opaque type nk_window = CStruct0
  object nk_window:
    given _tag: Tag[nk_window] = Tag.materializeCStruct0Tag
  opaque type nk_handle = CArray[Byte, Nat._8]
  object nk_handle:
    given _tag: Tag[nk_handle] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
    extension (struct: nk_handle)
      def ptr: Ptr[Byte] = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]]
      def id: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]

  opaque type nk_page_data = CArray[Byte, Nat._0]
  object nk_page_data:
    given _tag: Tag[nk_page_data] = Tag.CArray[CChar, Nat._0](Tag.Byte, Tag.Nat0)
    extension (struct: nk_page_data)
      def tbl: nk_table = !struct.at(0).asInstanceOf[Ptr[nk_table]]
      def pan: nk_panel = !struct.at(0).asInstanceOf[Ptr[nk_panel]]
      def win: nk_window = !struct.at(0).asInstanceOf[Ptr[nk_window]]

  opaque type nk_style_item_data = CArray[Byte, Nat.Digit2[Nat._2, Nat._8]]
  object nk_style_item_data:
    given _tag: Tag[nk_style_item_data] = Tag.CArray[CChar, Nat.Digit2[Nat._2, Nat._8]](Tag.Byte, Tag.Digit2[Nat._2, Nat._8](Tag.Nat2, Tag.Nat8))
    extension (struct: nk_style_item_data)
      def color: nk_color = !struct.at(0).asInstanceOf[Ptr[nk_color]]
      def image: nk_image = !struct.at(0).asInstanceOf[Ptr[nk_image]]
      def slice: nk_nine_slice = !struct.at(0).asInstanceOf[Ptr[nk_nine_slice]]
@link("nuklear")
@extern
object functions: 
  import types.*

  def nk_str_delete_runes(_0: Ptr[nk_str], pos: CInt, len: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_menu_item_image_label(_0: Ptr[nk_context], _1: nk_image, _2: CString, alignment: nk_flags): nk_bool = extern

  def nk_prog(_0: Ptr[nk_context], cur: nk_size, max: nk_size, modifyable: nk_bool): nk_size = extern

  def nk_layout_row_static(ctx: Ptr[nk_context], height: Float, item_width: CInt, cols: CInt): Unit = extern

  def nk_slider_float(_0: Ptr[nk_context], min: Float, `val`: Ptr[Float], max: Float, step: Float): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_nine_slice_ptr(_0: Ptr[Byte], l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort): nk_nine_slice = extern

  def nk_button_symbol_styled(_0: Ptr[nk_context], _1: Ptr[nk_style_button], _2: nk_symbol_type): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_draw_nine_slice(_0: Ptr[nk_command_buffer], _1: nk_rect, _2: Ptr[nk_nine_slice], _3: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hsv_f(out_h: Ptr[Float], out_s: Ptr[Float], out_v: Ptr[Float], _3: nk_color): Unit = extern

  def nk_tooltip_end(_0: Ptr[nk_context]): Unit = extern

  def nk_str_len_char(_0: Ptr[nk_str]): CInt = extern

  def nk_filter_float(_0: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_colorf_hsva_fv(hsva: Ptr[Float], in: nk_colorf): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_nine_slice_id(_0: CInt, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort): nk_nine_slice = extern

  def nk_tree_state_pop(_0: Ptr[nk_context]): Unit = extern

  def nk_widget_has_mouse_click_down(_0: Ptr[nk_context], _1: nk_buttons, down: nk_bool): nk_bool = extern

  def nk_clear(_0: Ptr[nk_context]): Unit = extern

  def nk_input_char(_0: Ptr[nk_context], _1: CChar): Unit = extern

  def nk_window_is_collapsed(ctx: Ptr[nk_context], name: CString): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_fill_triangle(_0: Ptr[nk_command_buffer], x0: Float, y0: Float, x1: Float, y1: Float, x2: Float, y2: Float, _7: nk_color): Unit = extern

  def nk_spacing(_0: Ptr[nk_context], cols: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_picker(_0: Ptr[nk_context], _1: nk_colorf, _2: nk_color_format): nk_colorf = extern

  def nk_style_default(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_begin_label(_0: Ptr[nk_context], selected: CString, size: nk_vec2): nk_bool = extern

  def nk_label(_0: Ptr[nk_context], _1: CString, align: nk_flags): Unit = extern

  def nk_str_at_char_const(_0: Ptr[nk_str], pos: CInt): CString = extern

  def nk_style_pop_style_item(_0: Ptr[nk_context]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_style_item_color(_0: nk_color): nk_style_item = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgb_f(r: Float, g: Float, b: Float): nk_color = extern

  def nk_layout_row_template_push_dynamic(_0: Ptr[nk_context]): Unit = extern

  def nk_buffer_reset(_0: Ptr[nk_buffer], `type`: nk_buffer_allocation_type): Unit = extern

  def nk_color_pick(_0: Ptr[nk_context], _1: Ptr[nk_colorf], _2: nk_color_format): nk_bool = extern

  def nk_widget_height(_0: Ptr[nk_context]): Float = extern

  def nk_input_is_key_pressed(_0: Ptr[nk_input], _1: nk_keys): nk_bool = extern

  def nk_selectable_text(_0: Ptr[nk_context], _1: CString, _2: CInt, align: nk_flags, value: Ptr[nk_bool]): nk_bool = extern

  def nk_buffer_free(_0: Ptr[nk_buffer]): Unit = extern

  def nk_widget(_0: Ptr[nk_rect], _1: Ptr[nk_context]): nk_widget_layout_states = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_window_get_bounds(ctx: Ptr[nk_context]): nk_rect = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgb_hex(rgb: CString): nk_color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_button_image_styled(_0: Ptr[nk_context], _1: Ptr[nk_style_button], img: nk_image): nk_bool = extern

  def nk_combo_item_symbol_text(_0: Ptr[nk_context], _1: nk_symbol_type, _2: CString, _3: CInt, alignment: nk_flags): nk_bool = extern

  def nk_contextual_item_text(_0: Ptr[nk_context], _1: CString, _2: CInt, align: nk_flags): nk_bool = extern

  def nk_style_pop_float(_0: Ptr[nk_context]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hsva_f(out_h: Ptr[Float], out_s: Ptr[Float], out_v: Ptr[Float], out_a: Ptr[Float], _4: nk_color): Unit = extern

  def nk_window_get_height(_0: Ptr[nk_context]): Float = extern

  def nk_button_set_behavior(_0: Ptr[nk_context], _1: nk_button_behavior): Unit = extern

  def nk_slide_float(_0: Ptr[nk_context], min: Float, `val`: Float, max: Float, step: Float): Float = extern

  def nk_filter_default(_0: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_property_double(_0: Ptr[nk_context], name: CString, min: Double, `val`: Ptr[Double], max: Double, step: Double, inc_per_pixel: Float): Unit = extern

  def nk_tree_element_push_hashed(_0: Ptr[nk_context], _1: nk_tree_type, title: CString, initial_state: nk_collapse_states, selected: Ptr[nk_bool], hash: CString, len: CInt, seed: CInt): nk_bool = extern

  def nk_check_flags_text(_0: Ptr[nk_context], _1: CString, _2: CInt, flags: CUnsignedInt, value: CUnsignedInt): CUnsignedInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_begin_titled(ctx: Ptr[nk_context], name: CString, title: CString, bounds: nk_rect, flags: nk_flags): nk_bool = extern

  def nk_tree_element_pop(_0: Ptr[nk_context]): Unit = extern

  def nk_filter_ascii(_0: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_style_pop_font(_0: Ptr[nk_context]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_hsva_colorfv(c: Ptr[Float]): nk_colorf = extern

  def nk_filter_decimal(_0: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_chart_end(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_item_image_label(_0: Ptr[nk_context], _1: nk_image, _2: CString, alignment: nk_flags): nk_bool = extern

  def nk_button_symbol_text(_0: Ptr[nk_context], _1: nk_symbol_type, _2: CString, _3: CInt, alignment: nk_flags): nk_bool = extern

  def nk_layout_row_push(_0: Ptr[nk_context], value: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_label_colored(_0: Ptr[nk_context], _1: CString, align: nk_flags, _3: nk_color): Unit = extern

  def nk_menubar_begin(_0: Ptr[nk_context]): Unit = extern

  def nk_select_label(_0: Ptr[nk_context], _1: CString, align: nk_flags, value: nk_bool): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_contextual_begin(_0: Ptr[nk_context], _1: nk_flags, _2: nk_vec2, trigger_bounds: nk_rect): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_cf(_0: nk_color): nk_colorf = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_layout_space_rect_to_local(_0: Ptr[nk_context], _1: nk_rect): nk_rect = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_stroke_arc(_0: Ptr[nk_command_buffer], cx: Float, cy: Float, radius: Float, a_min: Float, a_max: Float, line_thickness: Float, _7: nk_color): Unit = extern

  def nk_checkbox_flags_label(_0: Ptr[nk_context], _1: CString, flags: Ptr[CUnsignedInt], value: CUnsignedInt): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_layout_space_bounds(_0: Ptr[nk_context]): nk_rect = extern

  def nk_layout_reset_min_row_height(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgba_hex(rgb: CString): nk_color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_selectable_image_text(_0: Ptr[nk_context], _1: nk_image, _2: CString, _3: CInt, align: nk_flags, value: Ptr[nk_bool]): nk_bool = extern

  def nk_radio_text(_0: Ptr[nk_context], _1: CString, _2: CInt, active: Ptr[nk_bool]): nk_bool = extern

  def nk_layout_set_min_row_height(_0: Ptr[nk_context], height: Float): Unit = extern

  def nk_propertyi(_0: Ptr[nk_context], name: CString, min: CInt, `val`: CInt, max: CInt, step: CInt, inc_per_pixel: Float): CInt = extern

  def nk_input_motion(_0: Ptr[nk_context], x: CInt, y: CInt): Unit = extern

  def nk_strmatch_fuzzy_text(txt: CString, txt_len: CInt, pattern: CString, out_score: Ptr[CInt]): CInt = extern

  def nk_filter_hex(_0: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_window_get_width(_0: Ptr[nk_context]): Float = extern

  def nk_str_at_char(_0: Ptr[nk_str], pos: CInt): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_vec2i(x: CInt, y: CInt): nk_vec2 = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgb_iv(rgb: Ptr[CInt]): nk_color = extern

  def nk_plot(_0: Ptr[nk_context], _1: nk_chart_type, values: Ptr[Float], count: CInt, offset: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_menu_begin_text(_0: Ptr[nk_context], title: CString, title_len: CInt, align: nk_flags, size: nk_vec2): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_dv(rgba_out: Ptr[Double], _1: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_hsva_bv(hsva: Ptr[nk_byte]): nk_color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_hsva_iv(hsva: Ptr[CInt]): nk_color = extern

  def nk_checkbox_text(_0: Ptr[nk_context], _1: CString, _2: CInt, active: Ptr[nk_bool]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_sub9slice_ptr(_0: Ptr[Byte], w: nk_ushort, h: nk_ushort, sub_region: nk_rect, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort): nk_nine_slice = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_subimage_handle(_0: nk_handle, w: nk_ushort, h: nk_ushort, sub_region: nk_rect): nk_image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_input_is_mouse_click_down_in_rect(i: Ptr[nk_input], id: nk_buttons, b: nk_rect, down: nk_bool): nk_bool = extern

  def nk_style_pop_color(_0: Ptr[nk_context]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_menu_begin_image(_0: Ptr[nk_context], _1: CString, _2: nk_image, size: nk_vec2): nk_bool = extern

  def nk_contextual_item_symbol_label(_0: Ptr[nk_context], _1: nk_symbol_type, _2: CString, alignment: nk_flags): nk_bool = extern

  def nk_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_init_fixed(_0: Ptr[nk_context], memory: Ptr[Byte], size: nk_size, _3: Ptr[nk_user_font]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_button_image_text(_0: Ptr[nk_context], img: nk_image, _2: CString, _3: CInt, alignment: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_layout_space_to_local(_0: Ptr[nk_context], _1: nk_vec2): nk_vec2 = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_triangle_from_direction(result: Ptr[nk_vec2], r: nk_rect, pad_x: Float, pad_y: Float, _4: nk_heading): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_window_set_bounds(_0: Ptr[nk_context], name: CString, bounds: nk_rect): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_style_push_vec2(_0: Ptr[nk_context], _1: Ptr[nk_vec2], _2: nk_vec2): nk_bool = extern

  def nk_init(_0: Ptr[nk_context], _1: Ptr[nk_allocator], _2: Ptr[nk_user_font]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_style_push_color(_0: Ptr[nk_context], _1: Ptr[nk_color], _2: nk_color): nk_bool = extern

  def nk_group_scrolled_begin(_0: Ptr[nk_context], off: Ptr[nk_scroll], title: CString, _3: nk_flags): nk_bool = extern

  def nk_edit_string(_0: Ptr[nk_context], _1: nk_flags, buffer: CString, len: Ptr[CInt], max: CInt, _5: nk_plugin_filter): nk_flags = extern

  def nk_menubar_end(_0: Ptr[nk_context]): Unit = extern

  def nk_str_remove_runes(str: Ptr[nk_str], len: CInt): Unit = extern

  def nk_textedit_undo(_0: Ptr[nk_text_edit]): Unit = extern

  def nk_layout_space_end(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_nine_slice_handle(_0: nk_handle, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort): nk_nine_slice = extern

  def nk_str_append_str_utf8(_0: Ptr[nk_str], _1: CString): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rect_pos(_0: nk_rect): nk_vec2 = extern

  def nk_filter_binary(_0: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_selectable_symbol_text(_0: Ptr[nk_context], _1: nk_symbol_type, _2: CString, _3: CInt, align: nk_flags, value: Ptr[nk_bool]): nk_bool = extern

  def nk_str_get(_0: Ptr[nk_str]): CString = extern

  def nk_edit_unfocus(_0: Ptr[nk_context]): Unit = extern

  def nk_str_delete_chars(_0: Ptr[nk_str], pos: CInt, len: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combobox_separator(_0: Ptr[nk_context], items_separated_by_separator: CString, separator: CInt, selected: Ptr[CInt], count: CInt, item_height: CInt, size: nk_vec2): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgba_iv(rgba: Ptr[CInt]): nk_color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_widget_bounds(_0: Ptr[nk_context]): nk_rect = extern

  def nk_window_show_if(_0: Ptr[nk_context], name: CString, _2: nk_show_states, cond: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_input_scroll(_0: Ptr[nk_context], `val`: nk_vec2): Unit = extern

  def nk_strtoi(str: CString, endptr: Ptr[CString]): CInt = extern

  def nk_input_begin(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_text_colored(_0: Ptr[nk_context], _1: CString, _2: CInt, _3: nk_flags, _4: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_style_item_hide(): nk_style_item = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_tree_element_image_push_hashed(_0: Ptr[nk_context], _1: nk_tree_type, _2: nk_image, title: CString, initial_state: nk_collapse_states, selected: Ptr[nk_bool], hash: CString, len: CInt, seed: CInt): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_button_color(_0: Ptr[nk_context], _1: nk_color): nk_bool = extern

  def nk_utf_at(buffer: CString, length: CInt, index: CInt, unicode: Ptr[nk_rune], len: Ptr[CInt]): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_button_image_label(_0: Ptr[nk_context], img: nk_image, _2: CString, text_alignment: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combobox_string(_0: Ptr[nk_context], items_separated_by_zeros: CString, selected: Ptr[CInt], count: CInt, item_height: CInt, size: nk_vec2): Unit = extern

  def nk_textedit_init(_0: Ptr[nk_text_edit], _1: Ptr[nk_allocator], size: nk_size): Unit = extern

  def nk_window_get_panel(_0: Ptr[nk_context]): Ptr[nk_panel] = extern

  def nk_strmatch_fuzzy_string(str: CString, pattern: CString, out_score: Ptr[CInt]): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_d(r: Ptr[Double], g: Ptr[Double], b: Ptr[Double], a: Ptr[Double], _4: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgb(r: CInt, g: CInt, b: CInt): nk_color = extern

  def nk_chart_push_slot(_0: Ptr[nk_context], _1: Float, _2: CInt): nk_flags = extern

  def nk_utf_encode(_0: nk_rune, _1: CString, _2: CInt): CInt = extern

  def nk_window_is_any_hovered(_0: Ptr[nk_context]): nk_bool = extern

  def nk_spacer(_0: Ptr[nk_context]): Unit = extern

  def nk_window_is_active(_0: Ptr[nk_context], _1: CString): nk_bool = extern

  def nk_popup_end(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_chart_begin_colored(_0: Ptr[nk_context], _1: nk_chart_type, _2: nk_color, active: nk_color, num: CInt, min: Float, max: Float): nk_bool = extern

  def nk_str_append_text_runes(_0: Ptr[nk_str], _1: Ptr[nk_rune], _2: CInt): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_fill_rect(_0: Ptr[nk_command_buffer], _1: nk_rect, rounding: Float, _3: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_selectable_image_label(_0: Ptr[nk_context], _1: nk_image, _2: CString, align: nk_flags, value: Ptr[nk_bool]): nk_bool = extern

  def nk_window_get_scroll(_0: Ptr[nk_context], offset_x: Ptr[nk_uint], offset_y: Ptr[nk_uint]): Unit = extern

  def nk_textedit_delete(_0: Ptr[nk_text_edit], where: CInt, len: CInt): Unit = extern

  def nk_combo_item_text(_0: Ptr[nk_context], _1: CString, _2: CInt, alignment: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_contextual_item_image_text(_0: Ptr[nk_context], _1: nk_image, _2: CString, len: CInt, alignment: nk_flags): nk_bool = extern

  def nk_textedit_redo(_0: Ptr[nk_text_edit]): Unit = extern

  def nk_group_begin(_0: Ptr[nk_context], title: CString, _2: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_sub9slice_handle(_0: nk_handle, w: nk_ushort, h: nk_ushort, sub_region: nk_rect, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort): nk_nine_slice = extern

  def nk_buffer_clear(_0: Ptr[nk_buffer]): Unit = extern
  def nk_layout_row_template_push_static(_0: Ptr[nk_context], width: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_subimage_id(_0: CInt, w: nk_ushort, h: nk_ushort, sub_region: nk_rect): nk_image = extern

  def nk_str_insert_str_char(_0: Ptr[nk_str], pos: CInt, _2: CString): CInt = extern

  def nk_group_set_scroll(_0: Ptr[nk_context], id: CString, x_offset: nk_uint, y_offset: nk_uint): Unit = extern

  def nk_buffer_init_fixed(_0: Ptr[nk_buffer], memory: Ptr[Byte], size: nk_size): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_menu_begin_image_text(_0: Ptr[nk_context], _1: CString, _2: CInt, align: nk_flags, _4: nk_image, size: nk_vec2): nk_bool = extern

  def nk_button_symbol_label_styled(ctx: Ptr[nk_context], style: Ptr[nk_style_button], symbol: nk_symbol_type, title: CString, align: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_begin_symbol_label(_0: Ptr[nk_context], selected: CString, _2: nk_symbol_type, size: nk_vec2): nk_bool = extern

  def nk_check_text(_0: Ptr[nk_context], _1: CString, _2: CInt, active: nk_bool): nk_bool = extern

  def nk_input_is_mouse_released(_0: Ptr[nk_input], _1: nk_buttons): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_select_image_label(_0: Ptr[nk_context], _1: nk_image, _2: CString, align: nk_flags, value: nk_bool): nk_bool = extern

  def nk_group_begin_titled(_0: Ptr[nk_context], name: CString, title: CString, _3: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_widget_size(_0: Ptr[nk_context]): nk_vec2 = extern

  def nk_textedit_text(_0: Ptr[nk_text_edit], _1: CString, total_len: CInt): Unit = extern

  def nk_utf_decode(_0: CString, _1: Ptr[nk_rune], _2: CInt): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_stroke_polyline(_0: Ptr[nk_command_buffer], points: Ptr[Float], point_count: CInt, line_thickness: Float, col: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_begin_text(_0: Ptr[nk_context], selected: CString, _2: CInt, size: nk_vec2): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_push_scissor(_0: Ptr[nk_command_buffer], _1: nk_rect): Unit = extern

  def nk_contextual_item_symbol_text(_0: Ptr[nk_context], _1: nk_symbol_type, _2: CString, _3: CInt, alignment: nk_flags): nk_bool = extern

  def nk_str_append_text_utf8(_0: Ptr[nk_str], _1: CString, _2: CInt): CInt = extern

  def nk_group_get_scroll(_0: Ptr[nk_context], id: CString, x_offset: Ptr[nk_uint], y_offset: Ptr[nk_uint]): Unit = extern

  def nk_contextual_item_label(_0: Ptr[nk_context], _1: CString, align: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_hsva_f(h: Float, s: Float, v: Float, a: Float): nk_color = extern

  def nk_list_view_begin(_0: Ptr[nk_context], out: Ptr[nk_list_view], id: CString, _3: nk_flags, row_height: CInt, row_count: CInt): nk_bool = extern

  def nk_button_text(_0: Ptr[nk_context], title: CString, len: CInt): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_hsv(h: CInt, s: CInt, v: CInt): nk_color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hsva_iv(hsva_out: Ptr[CInt], _1: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_menu_item_image_text(_0: Ptr[nk_context], _1: nk_image, _2: CString, len: CInt, alignment: nk_flags): nk_bool = extern

  def nk_str_remove_chars(_0: Ptr[nk_str], len: CInt): Unit = extern

  def nk_style_get_color_by_name(_0: nk_style_colors): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_stroke_triangle(_0: Ptr[nk_command_buffer], _1: Float, _2: Float, _3: Float, _4: Float, _5: Float, _6: Float, line_thichness: Float, _8: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_callback(_0: Ptr[nk_context], item_getter: Ptr[CFuncPtr3[Ptr[Byte], CInt, Ptr[CString], Unit]], userdata: Ptr[Byte], selected: CInt, count: CInt, item_height: CInt, size: nk_vec2): CInt = extern

  def nk_input_is_key_released(_0: Ptr[nk_input], _1: nk_keys): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rectiv(xywh: Ptr[CInt]): nk_rect = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgba_cf(c: nk_colorf): nk_color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_menu_begin_symbol_label(_0: Ptr[nk_context], _1: CString, align: nk_flags, _3: nk_symbol_type, size: nk_vec2): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combobox(_0: Ptr[nk_context], items: Ptr[CString], count: CInt, selected: Ptr[CInt], item_height: CInt, size: nk_vec2): Unit = extern

  def nk_window_collapse_if(_0: Ptr[nk_context], name: CString, _2: nk_collapse_states, cond: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_image_handle(_0: nk_handle): nk_image = extern

  def nk_str_free(_0: Ptr[nk_str]): Unit = extern

  def nk_style_load_all_cursors(_0: Ptr[nk_context], _1: Ptr[nk_cursor]): Unit = extern

  def nk_str_insert_text_utf8(_0: Ptr[nk_str], pos: CInt, _2: CString, _3: CInt): CInt = extern

  def nk_buffer_push(_0: Ptr[nk_buffer], `type`: nk_buffer_allocation_type, memory: Ptr[Byte], size: nk_size, align: nk_size): Unit = extern

  def nk_style_pop_flags(_0: Ptr[nk_context]): nk_bool = extern

  def nk_str_len(_0: Ptr[nk_str]): CInt = extern

  def nk_edit_buffer(_0: Ptr[nk_context], _1: nk_flags, _2: Ptr[nk_text_edit], _3: nk_plugin_filter): nk_flags = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hsv_bv(hsv_out: Ptr[nk_byte], _1: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_subimage_ptr(_0: Ptr[Byte], w: nk_ushort, h: nk_ushort, sub_region: nk_rect): nk_image = extern

  def nk_str_init(_0: Ptr[nk_str], _1: Ptr[nk_allocator], size: nk_size): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_text_wrap_colored(_0: Ptr[nk_context], _1: CString, _2: CInt, _3: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_window_get_position(ctx: Ptr[nk_context]): nk_vec2 = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_begin_image_label(_0: Ptr[nk_context], selected: CString, _2: nk_image, size: nk_vec2): nk_bool = extern

  def nk_slider_int(_0: Ptr[nk_context], min: CInt, `val`: Ptr[CInt], max: CInt, step: CInt): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rectv(xywh: Ptr[Float]): nk_rect = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_draw_image(_0: Ptr[nk_command_buffer], _1: nk_rect, _2: Ptr[nk_image], _3: nk_color): Unit = extern

  def nk_combo_item_label(_0: Ptr[nk_context], _1: CString, alignment: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_chart_add_slot_colored(ctx: Ptr[nk_context], _1: nk_chart_type, _2: nk_color, active: nk_color, count: CInt, min_value: Float, max_value: Float): Unit = extern

  def nk_radio_label(_0: Ptr[nk_context], _1: CString, active: Ptr[nk_bool]): nk_bool = extern

  def nk_menu_item_text(_0: Ptr[nk_context], _1: CString, _2: CInt, align: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_hsv_fv(hsv: Ptr[Float]): nk_color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_hsv_iv(hsv: Ptr[CInt]): nk_color = extern

  def nk_str_append_str_char(_0: Ptr[nk_str], _1: CString): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hsva_b(h: Ptr[nk_byte], s: Ptr[nk_byte], v: Ptr[nk_byte], a: Ptr[nk_byte], _4: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_recti(x: CInt, y: CInt, w: CInt, h: CInt): nk_rect = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hsv_b(out_h: Ptr[nk_byte], out_s: Ptr[nk_byte], out_v: Ptr[nk_byte], _3: nk_color): Unit = extern

  def nk_property_int(_0: Ptr[nk_context], name: CString, min: CInt, `val`: Ptr[CInt], max: CInt, step: CInt, inc_per_pixel: Float): Unit = extern

  def nk_str_insert_text_runes(_0: Ptr[nk_str], pos: CInt, _2: Ptr[nk_rune], _3: CInt): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_push_custom(_0: Ptr[nk_command_buffer], _1: nk_rect, _2: nk_command_custom_callback, usr: nk_handle): Unit = extern

  def nk_input_unicode(_0: Ptr[nk_context], _1: nk_rune): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_tree_state_image_push(_0: Ptr[nk_context], _1: nk_tree_type, _2: nk_image, title: CString, state: Ptr[nk_collapse_states]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgb_bv(rgb: Ptr[nk_byte]): nk_color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgb_cf(c: nk_colorf): nk_color = extern

  def nk_input_glyph(_0: Ptr[nk_context], _1: nk_glyph): Unit = extern

  def nk_textedit_delete_selection(_0: Ptr[nk_text_edit]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_hsv_bv(hsv: Ptr[nk_byte]): nk_color = extern

  def nk_str_get_const(_0: Ptr[nk_str]): CString = extern

  def nk_window_set_scroll(_0: Ptr[nk_context], offset_x: nk_uint, offset_y: nk_uint): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_stroke_circle(_0: Ptr[nk_command_buffer], _1: nk_rect, line_thickness: Float, _3: nk_color): Unit = extern

  def nk__begin(_0: Ptr[nk_context]): Ptr[nk_command] = extern

  def nk_strtod(str: CString, endptr: Ptr[CString]): Double = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_get_null_rect(): nk_rect = extern

  def nk_tree_pop(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_vec2iv(xy: Ptr[CInt]): nk_vec2 = extern

  def nk_str_append_text_char(_0: Ptr[nk_str], _1: CString, _2: CInt): CInt = extern

  def nk_menu_close(_0: Ptr[nk_context]): Unit = extern

  def nk_buffer_mark(_0: Ptr[nk_buffer], `type`: nk_buffer_allocation_type): Unit = extern

  def nk_selectable_symbol_label(_0: Ptr[nk_context], _1: nk_symbol_type, _2: CString, align: nk_flags, value: Ptr[nk_bool]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_style_item_nine_slice(slice: nk_nine_slice): nk_style_item = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgba_u32(_0: nk_uint): nk_color = extern

  def nk_item_is_any_active(_0: Ptr[nk_context]): nk_bool = extern

  def nk_utf_len(_0: CString, byte_len: CInt): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_stroke_polygon(_0: Ptr[nk_command_buffer], _1: Ptr[Float], point_count: CInt, line_thickness: Float, _4: nk_color): Unit = extern

  def nk_str_clear(_0: Ptr[nk_str]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_draw_text(_0: Ptr[nk_command_buffer], _1: nk_rect, text: CString, len: CInt, _4: Ptr[nk_user_font], _5: nk_color, _6: nk_color): Unit = extern

  def nk_style_set_font(_0: Ptr[nk_context], _1: Ptr[nk_user_font]): Unit = extern

  def nk_murmur_hash(key: Ptr[Byte], len: CInt, seed: nk_hash): nk_hash = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_menu_begin_symbol(_0: Ptr[nk_context], _1: CString, _2: nk_symbol_type, size: nk_vec2): nk_bool = extern

  def nk_property_float(_0: Ptr[nk_context], name: CString, min: Float, `val`: Ptr[Float], max: Float, step: Float, inc_per_pixel: Float): Unit = extern

  def nk_textedit_cut(_0: Ptr[nk_text_edit]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_separator(_0: Ptr[nk_context], items_separated_by_separator: CString, separator: CInt, selected: CInt, count: CInt, item_height: CInt, size: nk_vec2): CInt = extern

  def nk_contextual_close(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_fill_rect_multi_color(_0: Ptr[nk_command_buffer], _1: nk_rect, left: nk_color, top: nk_color, right: nk_color, bottom: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_label_colored_wrap(_0: Ptr[nk_context], _1: CString, _2: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_menu_begin_image_label(_0: Ptr[nk_context], _1: CString, align: nk_flags, _3: nk_image, size: nk_vec2): nk_bool = extern

  def nk_progress(_0: Ptr[nk_context], cur: Ptr[nk_size], max: nk_size, modifyable: nk_bool): nk_bool = extern

  def nk_chart_add_slot(ctx: Ptr[nk_context], _1: nk_chart_type, count: CInt, min_value: Float, max_value: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_begin_color(_0: Ptr[nk_context], color: nk_color, size: nk_vec2): nk_bool = extern

  def nk_str_insert_at_rune(_0: Ptr[nk_str], pos: CInt, _2: CString, _3: CInt): CInt = extern

  def nk_button_symbol_text_styled(_0: Ptr[nk_context], _1: Ptr[nk_style_button], _2: nk_symbol_type, _3: CString, _4: CInt, alignment: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_hsva(h: CInt, s: CInt, v: CInt, a: CInt): nk_color = extern

  def nk_str_rune_at(_0: Ptr[nk_str], pos: CInt): nk_rune = extern

  def nk_layout_row_template_begin(_0: Ptr[nk_context], row_height: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_fill_circle(_0: Ptr[nk_command_buffer], _1: nk_rect, _2: nk_color): Unit = extern

  def nk_combo_item_symbol_label(_0: Ptr[nk_context], _1: nk_symbol_type, _2: CString, alignment: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgba_f(r: Float, g: Float, b: Float, a: Float): nk_color = extern

  def nk_input_is_mouse_pressed(_0: Ptr[nk_input], _1: nk_buttons): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo(_0: Ptr[nk_context], items: Ptr[CString], count: CInt, selected: CInt, item_height: CInt, size: nk_vec2): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_layout_widget_bounds(_0: Ptr[nk_context]): nk_rect = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_input_has_mouse_click_down_in_rect(_0: Ptr[nk_input], _1: nk_buttons, _2: nk_rect, down: nk_bool): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_vec2v(xy: Ptr[Float]): nk_vec2 = extern

  def nk_style_push_flags(_0: Ptr[nk_context], _1: Ptr[nk_flags], _2: nk_flags): nk_bool = extern

  def nk_style_show_cursor(_0: Ptr[nk_context]): Unit = extern

  def nk_layout_row_template_end(_0: Ptr[nk_context]): Unit = extern

  def nk_select_symbol_label(_0: Ptr[nk_context], _1: nk_symbol_type, _2: CString, align: nk_flags, value: nk_bool): nk_bool = extern

  def nk_input_end(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_sub9slice_id(_0: CInt, w: nk_ushort, h: nk_ushort, sub_region: nk_rect, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort): nk_nine_slice = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_u32(_0: nk_color): nk_uint = extern

  def nk_window_is_hovered(_0: Ptr[nk_context]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_input_has_mouse_click_in_rect(_0: Ptr[nk_input], _1: nk_buttons, _2: nk_rect): nk_bool = extern

  def nk_plot_function(_0: Ptr[nk_context], _1: nk_chart_type, userdata: Ptr[Byte], value_getter: Ptr[CFuncPtr2[Ptr[Byte], CInt, Float]], count: CInt, offset: CInt): Unit = extern

  def nk_window_set_focus(_0: Ptr[nk_context], name: CString): Unit = extern

  def nk_button_symbol_label(_0: Ptr[nk_context], _1: nk_symbol_type, _2: CString, text_alignment: nk_flags): nk_bool = extern

  def nk_strtof(str: CString, endptr: Ptr[CString]): Float = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_string(_0: Ptr[nk_context], items_separated_by_zeros: CString, selected: CInt, count: CInt, item_height: CInt, size: nk_vec2): CInt = extern

  def nk_contextual_end(_0: Ptr[nk_context]): Unit = extern

  def nk_strfilter(text: CString, regexp: CString): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_button_image(_0: Ptr[nk_context], img: nk_image): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_window_get_content_region(_0: Ptr[nk_context]): nk_rect = extern

  def nk_text_wrap(_0: Ptr[nk_context], _1: CString, _2: CInt): Unit = extern

  def nk_slide_int(_0: Ptr[nk_context], min: CInt, `val`: CInt, max: CInt, step: CInt): CInt = extern

  def nk_textedit_free(_0: Ptr[nk_text_edit]): Unit = extern

  def nk_option_text(_0: Ptr[nk_context], _1: CString, _2: CInt, active: nk_bool): nk_bool = extern

  def nk_check_flags_label(_0: Ptr[nk_context], _1: CString, flags: CUnsignedInt, value: CUnsignedInt): CUnsignedInt = extern

  def nk_style_hide_cursor(_0: Ptr[nk_context]): Unit = extern

  def nk_button_pop_behavior(_0: Ptr[nk_context]): nk_bool = extern

  def nk_text(_0: Ptr[nk_context], _1: CString, _2: CInt, _3: nk_flags): Unit = extern

  def nk_check_label(_0: Ptr[nk_context], _1: CString, active: nk_bool): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hsva_bv(hsva_out: Ptr[nk_byte], _1: nk_color): Unit = extern

  def nk_buffer_init(_0: Ptr[nk_buffer], _1: Ptr[nk_allocator], size: nk_size): Unit = extern

  def nk_list_view_end(_0: Ptr[nk_list_view]): Unit = extern

  def nk_input_button(_0: Ptr[nk_context], _1: nk_buttons, x: CInt, y: CInt, down: nk_bool): Unit = extern

  def nk_button_text_styled(_0: Ptr[nk_context], _1: Ptr[nk_style_button], title: CString, len: CInt): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_input_mouse_clicked(_0: Ptr[nk_input], _1: nk_buttons, _2: nk_rect): nk_bool = extern

  def nk_layout_row(_0: Ptr[nk_context], _1: nk_layout_format, height: Float, cols: CInt, ratio: Ptr[Float]): Unit = extern

  def nk_combo_close(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hsva_fv(hsva_out: Ptr[Float], _1: nk_color): Unit = extern

  def nk_buffer_memory_const(_0: Ptr[nk_buffer]): Ptr[Byte] = extern

  def nk_window_show(_0: Ptr[nk_context], name: CString, _2: nk_show_states): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgba_fv(rgba: Ptr[Float]): nk_color = extern

  def nk_style_set_cursor(_0: Ptr[nk_context], _1: nk_style_cursor): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rect(x: Float, y: Float, w: Float, h: Float): nk_rect = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hex_rgba(output: CString, _1: nk_color): Unit = extern

  def nk_strlen(str: CString): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_vec2(x: Float, y: Float): nk_vec2 = extern

  def nk_widget_is_mouse_clicked(_0: Ptr[nk_context], _1: nk_buttons): nk_bool = extern

  def nk_menu_item_label(_0: Ptr[nk_context], _1: CString, alignment: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_popup_begin(_0: Ptr[nk_context], _1: nk_popup_type, _2: CString, _3: nk_flags, bounds: nk_rect): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_select_image_text(_0: Ptr[nk_context], _1: nk_image, _2: CString, _3: CInt, align: nk_flags, value: nk_bool): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_window_get_size(_0: Ptr[nk_context]): nk_vec2 = extern

  def nk_init_custom(_0: Ptr[nk_context], cmds: Ptr[nk_buffer], pool: Ptr[nk_buffer], _3: Ptr[nk_user_font]): nk_bool = extern

  def nk_window_find(ctx: Ptr[nk_context], name: CString): Ptr[nk_window] = extern

  def nk_layout_row_end(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_input_is_mouse_hovering_rect(_0: Ptr[nk_input], _1: nk_rect): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_fv(rgba_out: Ptr[Float], _1: nk_color): Unit = extern

  def nk_handle_id(_0: CInt): nk_handle = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_image_ptr(_0: Ptr[Byte]): nk_image = extern

  def nk_str_append_str_runes(_0: Ptr[nk_str], _1: Ptr[nk_rune]): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_begin_symbol_text(_0: Ptr[nk_context], selected: CString, _2: CInt, _3: nk_symbol_type, size: nk_vec2): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_begin_symbol(_0: Ptr[nk_context], _1: nk_symbol_type, size: nk_vec2): nk_bool = extern

  def nk_buffer_info(_0: Ptr[nk_memory_status], _1: Ptr[nk_buffer]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgb_fv(rgb: Ptr[Float]): nk_color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_input_is_mouse_prev_hovering_rect(_0: Ptr[nk_input], _1: nk_rect): nk_bool = extern

  def nk_layout_ratio_from_pixel(_0: Ptr[nk_context], pixel_width: Float): Float = extern

  def nk_textedit_select_all(_0: Ptr[nk_text_edit]): Unit = extern

  def nk_buffer_total(_0: Ptr[nk_buffer]): nk_size = extern

  def nk_propertyd(_0: Ptr[nk_context], name: CString, min: Double, `val`: Double, max: Double, step: Double, inc_per_pixel: Float): Double = extern

  def nk_button_label_styled(_0: Ptr[nk_context], _1: Ptr[nk_style_button], title: CString): nk_bool = extern

  def nk_input_is_mouse_down(_0: Ptr[nk_input], _1: nk_buttons): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_hsva_colorf(h: Float, s: Float, v: Float, a: Float): nk_colorf = extern

  def nk_str_insert_text_char(_0: Ptr[nk_str], pos: CInt, _2: CString, _3: CInt): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hsva_i(h: Ptr[CInt], s: Ptr[CInt], v: Ptr[CInt], a: Ptr[CInt], _4: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_window_set_size(_0: Ptr[nk_context], name: CString, _2: nk_vec2): Unit = extern

  def nk_group_scrolled_offset_begin(_0: Ptr[nk_context], x_offset: Ptr[nk_uint], y_offset: Ptr[nk_uint], title: CString, flags: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_layout_space_rect_to_screen(_0: Ptr[nk_context], _1: nk_rect): nk_rect = extern

  def nk_str_at_const(_0: Ptr[nk_str], pos: CInt, unicode: Ptr[nk_rune], len: Ptr[CInt]): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_input_any_mouse_click_in_rect(_0: Ptr[nk_input], _1: nk_rect): nk_bool = extern

  def nk_tree_state_push(_0: Ptr[nk_context], _1: nk_tree_type, title: CString, state: Ptr[nk_collapse_states]): nk_bool = extern

  def nk_textedit_paste(_0: Ptr[nk_text_edit], _1: CString, len: CInt): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hsv_fv(hsv_out: Ptr[Float], _1: nk_color): Unit = extern

  def nk_input_has_mouse_click(_0: Ptr[nk_input], _1: nk_buttons): nk_bool = extern

  def nk_stricmp(s1: CString, s2: CString): CInt = extern

  def nk_popup_set_scroll(_0: Ptr[nk_context], offset_x: nk_uint, offset_y: nk_uint): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_style_push_style_item(_0: Ptr[nk_context], _1: Ptr[nk_style_item], _2: nk_style_item): nk_bool = extern

  def nk_chart_begin(_0: Ptr[nk_context], _1: nk_chart_type, num: CInt, min: Float, max: Float): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_button_image_text_styled(_0: Ptr[nk_context], _1: Ptr[nk_style_button], img: nk_image, _3: CString, _4: CInt, alignment: nk_flags): nk_bool = extern

  def nk_widget_is_hovered(_0: Ptr[nk_context]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_hsv_f(h: Float, s: Float, v: Float): nk_color = extern

  def nk_selectable_label(_0: Ptr[nk_context], _1: CString, align: nk_flags, value: Ptr[nk_bool]): nk_bool = extern

  def nk_style_from_table(_0: Ptr[nk_context], _1: Ptr[nk_color]): Unit = extern

  def nk_menu_item_symbol_text(_0: Ptr[nk_context], _1: nk_symbol_type, _2: CString, _3: CInt, alignment: nk_flags): nk_bool = extern

  def nk_tree_push_hashed(_0: Ptr[nk_context], _1: nk_tree_type, title: CString, initial_state: nk_collapse_states, hash: CString, len: CInt, seed: CInt): nk_bool = extern

  def nk_chart_push(_0: Ptr[nk_context], _1: Float): nk_flags = extern

  def nk_input_key(_0: Ptr[nk_context], _1: nk_keys, down: nk_bool): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_colorf_hsva_f(out_h: Ptr[Float], out_s: Ptr[Float], out_v: Ptr[Float], out_a: Ptr[Float], in: nk_colorf): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_item_image_text(_0: Ptr[nk_context], _1: nk_image, _2: CString, _3: CInt, alignment: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combobox_callback(_0: Ptr[nk_context], item_getter: Ptr[CFuncPtr3[Ptr[Byte], CInt, Ptr[CString], Unit]], _2: Ptr[Byte], selected: Ptr[CInt], count: CInt, item_height: CInt, size: nk_vec2): Unit = extern

  def nk_str_at_rune(_0: Ptr[nk_str], pos: CInt, unicode: Ptr[nk_rune], len: Ptr[CInt]): CString = extern

  def nk_layout_row_template_push_variable(_0: Ptr[nk_context], min_width: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_image_color(_0: Ptr[nk_context], _1: nk_image, _2: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_stroke_curve(_0: Ptr[nk_command_buffer], _1: Float, _2: Float, _3: Float, _4: Float, _5: Float, _6: Float, _7: Float, _8: Float, line_thickness: Float, _10: nk_color): Unit = extern

  def nk_checkbox_label(_0: Ptr[nk_context], _1: CString, active: Ptr[nk_bool]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_window_get_content_region_size(_0: Ptr[nk_context]): nk_vec2 = extern

  def nk_str_insert_at_char(_0: Ptr[nk_str], pos: CInt, _2: CString, _3: CInt): CInt = extern

  def nk_window_is_closed(_0: Ptr[nk_context], _1: CString): nk_bool = extern

  def nk_style_push_float(_0: Ptr[nk_context], _1: Ptr[Float], _2: Float): nk_bool = extern

  def nk_str_init_fixed(_0: Ptr[nk_str], memory: Ptr[Byte], size: nk_size): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hsv_i(out_h: Ptr[CInt], out_s: Ptr[CInt], out_v: Ptr[CInt], _3: nk_color): Unit = extern

  def nk_menu_end(_0: Ptr[nk_context]): Unit = extern

  def nk_input_is_key_down(_0: Ptr[nk_input], _1: nk_keys): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_fill_polygon(_0: Ptr[nk_command_buffer], _1: Ptr[Float], point_count: CInt, _3: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rect_size(_0: nk_rect): nk_vec2 = extern

  def nk_propertyf(_0: Ptr[nk_context], name: CString, min: Float, `val`: Float, max: Float, step: Float, inc_per_pixel: Float): Float = extern

  def nk_layout_row_begin(ctx: Ptr[nk_context], fmt: nk_layout_format, row_height: Float, cols: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_image(_0: Ptr[nk_context], _1: nk_image): Unit = extern

  def nk_edit_string_zero_terminated(_0: Ptr[nk_context], _1: nk_flags, buffer: CString, max: CInt, _4: nk_plugin_filter): nk_flags = extern

  def nk_window_is_hidden(_0: Ptr[nk_context], _1: CString): nk_bool = extern

  def nk_style_pop_vec2(_0: Ptr[nk_context]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_window_get_content_region_min(_0: Ptr[nk_context]): nk_vec2 = extern

  def nk_tooltip_begin(_0: Ptr[nk_context], width: Float): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_fill_arc(_0: Ptr[nk_command_buffer], cx: Float, cy: Float, radius: Float, a_min: Float, a_max: Float, _6: nk_color): Unit = extern

  def nk_stricmpn(s1: CString, s2: CString, n: CInt): CInt = extern

  def nk_popup_close(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_contextual_item_image_label(_0: Ptr[nk_context], _1: nk_image, _2: CString, alignment: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgba_bv(rgba: Ptr[nk_byte]): nk_color = extern

  def nk_str_insert_str_utf8(_0: Ptr[nk_str], pos: CInt, _2: CString): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_hsva_fv(hsva: Ptr[Float]): nk_color = extern

  def nk_str_insert_str_runes(_0: Ptr[nk_str], pos: CInt, _2: Ptr[nk_rune]): CInt = extern

  def nk_tooltip(_0: Ptr[nk_context], _1: CString): Unit = extern

  def nk_label_wrap(_0: Ptr[nk_context], _1: CString): Unit = extern

  def nk_popup_get_scroll(_0: Ptr[nk_context], offset_x: Ptr[nk_uint], offset_y: Ptr[nk_uint]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hex_rgb(output: CString, _1: nk_color): Unit = extern

  def nk_menu_item_symbol_label(_0: Ptr[nk_context], _1: nk_symbol_type, _2: CString, alignment: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_input_is_mouse_click_in_rect(_0: Ptr[nk_input], _1: nk_buttons, _2: nk_rect): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_window_set_position(_0: Ptr[nk_context], name: CString, pos: nk_vec2): Unit = extern

  def nk_select_symbol_text(_0: Ptr[nk_context], _1: nk_symbol_type, _2: CString, _3: CInt, align: nk_flags, value: nk_bool): nk_bool = extern

  def nk_nine_slice_is_sub9slice(img: Ptr[nk_nine_slice]): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_menu_begin_symbol_text(_0: Ptr[nk_context], _1: CString, _2: CInt, align: nk_flags, _4: nk_symbol_type, size: nk_vec2): nk_bool = extern

  def nk_group_scrolled_end(_0: Ptr[nk_context]): Unit = extern

  def nk_window_get_canvas(_0: Ptr[nk_context]): Ptr[nk_command_buffer] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_image_id(_0: CInt): nk_image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_widget_fitting(_0: Ptr[nk_rect], _1: Ptr[nk_context], _2: nk_vec2): nk_widget_layout_states = extern

  def nk_group_end(_0: Ptr[nk_context]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_menu_begin_label(_0: Ptr[nk_context], _1: CString, align: nk_flags, size: nk_vec2): nk_bool = extern

  def nk_widget_width(_0: Ptr[nk_context]): Float = extern

  def nk_textedit_init_fixed(_0: Ptr[nk_text_edit], memory: Ptr[Byte], size: nk_size): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_hsv_iv(hsv_out: Ptr[CInt], _1: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_button_image_label_styled(_0: Ptr[nk_context], _1: Ptr[nk_style_button], img: nk_image, _3: CString, text_alignment: nk_flags): nk_bool = extern

  def nk_style_push_font(_0: Ptr[nk_context], _1: Ptr[nk_user_font]): nk_bool = extern

  def nk_checkbox_flags_text(_0: Ptr[nk_context], _1: CString, _2: CInt, flags: Ptr[CUnsignedInt], value: CUnsignedInt): nk_bool = extern

  def nk_layout_space_begin(_0: Ptr[nk_context], _1: nk_layout_format, height: Float, widget_count: CInt): Unit = extern

  def nk_buffer_memory(_0: Ptr[nk_buffer]): Ptr[Byte] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_stroke_rect(_0: Ptr[nk_command_buffer], _1: nk_rect, rounding: Float, line_thickness: Float, _4: nk_color): Unit = extern

  def nk_combo_end(_0: Ptr[nk_context]): Unit = extern

  def nk_button_label(_0: Ptr[nk_context], title: CString): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_tree_image_push_hashed(_0: Ptr[nk_context], _1: nk_tree_type, _2: nk_image, title: CString, initial_state: nk_collapse_states, hash: CString, len: CInt, seed: CInt): nk_bool = extern

  def nk_select_text(_0: Ptr[nk_context], _1: CString, _2: CInt, align: nk_flags, value: nk_bool): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_begin_image_text(_0: Ptr[nk_context], selected: CString, _2: CInt, _3: nk_image, size: nk_vec2): nk_bool = extern

  def nk_edit_focus(_0: Ptr[nk_context], flags: nk_flags): Unit = extern

  def nk_free(_0: Ptr[nk_context]): Unit = extern

  def nk_button_symbol(_0: Ptr[nk_context], _1: nk_symbol_type): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_begin(ctx: Ptr[nk_context], title: CString, bounds: nk_rect, flags: nk_flags): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_combo_begin_image(_0: Ptr[nk_context], img: nk_image, size: nk_vec2): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_layout_space_push(_0: Ptr[nk_context], bounds: nk_rect): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_window_get_content_region_max(_0: Ptr[nk_context]): nk_vec2 = extern

  def nk_layout_row_dynamic(ctx: Ptr[nk_context], height: Float, cols: CInt): Unit = extern

  def nk__next(_0: Ptr[nk_context], _1: Ptr[nk_command]): Ptr[nk_command] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_stroke_line(b: Ptr[nk_command_buffer], x0: Float, y0: Float, x1: Float, y1: Float, line_thickness: Float, _6: nk_color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_recta(pos: nk_vec2, size: nk_vec2): nk_rect = extern

  def nk_window_collapse(_0: Ptr[nk_context], name: CString, state: nk_collapse_states): Unit = extern

  def nk_window_has_focus(_0: Ptr[nk_context]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_color_f(r: Ptr[Float], g: Ptr[Float], b: Ptr[Float], a: Ptr[Float], _4: nk_color): Unit = extern

  def nk_handle_ptr(_0: Ptr[Byte]): nk_handle = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_widget_position(_0: Ptr[nk_context]): nk_vec2 = extern

  def nk_image_is_subimage(img: Ptr[nk_image]): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_layout_space_to_screen(_0: Ptr[nk_context], _1: nk_vec2): nk_vec2 = extern

  def nk_window_close(ctx: Ptr[nk_context], name: CString): Unit = extern

  def nk_style_load_cursor(_0: Ptr[nk_context], _1: nk_style_cursor, _2: Ptr[nk_cursor]): Unit = extern

  def nk_filter_oct(_0: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_option_label(_0: Ptr[nk_context], _1: CString, active: nk_bool): nk_bool = extern

  def nk_button_push_behavior(_0: Ptr[nk_context], _1: nk_button_behavior): nk_bool = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_style_item_image(img: nk_image): nk_style_item = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def nk_rgba(r: CInt, g: CInt, b: CInt, a: CInt): nk_color = extern


