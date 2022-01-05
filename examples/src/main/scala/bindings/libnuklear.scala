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
    extension (t: T)
     def int: CInt = eq.apply(t).toInt
     def uint: CUnsignedInt = eq.apply(t)
      
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

  opaque type nk_property_filter = CUnsignedInt
  object nk_property_filter extends CEnumU[nk_property_filter]:
    inline def define(inline a: Long): nk_property_filter = a.toUInt
    val NK_FILTER_INT = define(0)
    val NK_FILTER_FLOAT = define(1)

  opaque type nk_property_kind = CUnsignedInt
  object nk_property_kind extends CEnumU[nk_property_kind]:
    inline def define(inline a: Long): nk_property_kind = a.toUInt
    val NK_PROPERTY_INT = define(0)
    val NK_PROPERTY_FLOAT = define(1)
    val NK_PROPERTY_DOUBLE = define(2)

  opaque type nk_property_status = CUnsignedInt
  object nk_property_status extends CEnumU[nk_property_status]:
    inline def define(inline a: Long): nk_property_status = a.toUInt
    val NK_PROPERTY_DEFAULT = define(0)
    val NK_PROPERTY_EDIT = define(1)
    val NK_PROPERTY_DRAG = define(2)

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

  opaque type nk_toggle_type = CUnsignedInt
  object nk_toggle_type extends CEnumU[nk_toggle_type]:
    inline def define(inline a: Long): nk_toggle_type = a.toUInt
    val NK_TOGGLE_CHECK = define(0)
    val NK_TOGGLE_OPTION = define(1)

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

  opaque type nk_window_insert_location = CUnsignedInt
  object nk_window_insert_location extends CEnumU[nk_window_insert_location]:
    inline def define(inline a: Long): nk_window_insert_location = a.toUInt
    val NK_INSERT_BACK = define(0)
    val NK_INSERT_FRONT = define(1)
  opaque type __builtin_va_list = CString
  object __builtin_va_list: 
    given _tag: Tag[__builtin_va_list] = Tag.Ptr[CChar](Tag.Byte)
    inline def apply(inline o: CString): __builtin_va_list = o

  type __darwin_blkcnt_t = __int64_t
  object __darwin_blkcnt_t: 
    given _tag: Tag[__darwin_blkcnt_t] = __int64_t._tag

  type __darwin_blksize_t = __int32_t
  object __darwin_blksize_t: 
    given _tag: Tag[__darwin_blksize_t] = __int32_t._tag

  opaque type __darwin_clock_t = CUnsignedLongInt
  object __darwin_clock_t: 
    given _tag: Tag[__darwin_clock_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): __darwin_clock_t = o

  opaque type __darwin_ct_rune_t = CInt
  object __darwin_ct_rune_t: 
    given _tag: Tag[__darwin_ct_rune_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_ct_rune_t = o

  type __darwin_dev_t = __int32_t
  object __darwin_dev_t: 
    given _tag: Tag[__darwin_dev_t] = __int32_t._tag

  opaque type __darwin_fsblkcnt_t = CUnsignedInt
  object __darwin_fsblkcnt_t: 
    given _tag: Tag[__darwin_fsblkcnt_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __darwin_fsblkcnt_t = o

  opaque type __darwin_fsfilcnt_t = CUnsignedInt
  object __darwin_fsfilcnt_t: 
    given _tag: Tag[__darwin_fsfilcnt_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __darwin_fsfilcnt_t = o

  type __darwin_gid_t = __uint32_t
  object __darwin_gid_t: 
    given _tag: Tag[__darwin_gid_t] = __uint32_t._tag

  type __darwin_id_t = __uint32_t
  object __darwin_id_t: 
    given _tag: Tag[__darwin_id_t] = __uint32_t._tag

  type __darwin_ino64_t = __uint64_t
  object __darwin_ino64_t: 
    given _tag: Tag[__darwin_ino64_t] = __uint64_t._tag

  type __darwin_ino_t = __darwin_ino64_t
  object __darwin_ino_t: 
    given _tag: Tag[__darwin_ino_t] = __darwin_ino64_t._tag

  opaque type __darwin_intptr_t = CLongInt
  object __darwin_intptr_t: 
    given _tag: Tag[__darwin_intptr_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_intptr_t = o

  type __darwin_mach_port_name_t = __darwin_natural_t
  object __darwin_mach_port_name_t: 
    given _tag: Tag[__darwin_mach_port_name_t] = __darwin_natural_t._tag

  type __darwin_mach_port_t = __darwin_mach_port_name_t
  object __darwin_mach_port_t: 
    given _tag: Tag[__darwin_mach_port_t] = __darwin_mach_port_name_t._tag

  type __darwin_mbstate_t = __mbstate_t
  object __darwin_mbstate_t: 
    given _tag: Tag[__darwin_mbstate_t] = __mbstate_t._tag

  type __darwin_mode_t = __uint16_t
  object __darwin_mode_t: 
    given _tag: Tag[__darwin_mode_t] = __uint16_t._tag

  opaque type __darwin_natural_t = CUnsignedInt
  object __darwin_natural_t: 
    given _tag: Tag[__darwin_natural_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __darwin_natural_t = o

  type __darwin_off_t = __int64_t
  object __darwin_off_t: 
    given _tag: Tag[__darwin_off_t] = __int64_t._tag

  type __darwin_pid_t = __int32_t
  object __darwin_pid_t: 
    given _tag: Tag[__darwin_pid_t] = __int32_t._tag

  opaque type __darwin_pthread_key_t = CUnsignedLongInt
  object __darwin_pthread_key_t: 
    given _tag: Tag[__darwin_pthread_key_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): __darwin_pthread_key_t = o

  opaque type __darwin_pthread_t = Ptr[_opaque_pthread_t]
  object __darwin_pthread_t: 
    given _tag: Tag[__darwin_pthread_t] = Tag.Ptr[_opaque_pthread_t](_opaque_pthread_t._tag)
    inline def apply(inline o: Ptr[_opaque_pthread_t]): __darwin_pthread_t = o

  opaque type __darwin_ptrdiff_t = CLongInt
  object __darwin_ptrdiff_t: 
    given _tag: Tag[__darwin_ptrdiff_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_ptrdiff_t = o

  type __darwin_rune_t = __darwin_wchar_t
  object __darwin_rune_t: 
    given _tag: Tag[__darwin_rune_t] = __darwin_wchar_t._tag

  type __darwin_sigset_t = __uint32_t
  object __darwin_sigset_t: 
    given _tag: Tag[__darwin_sigset_t] = __uint32_t._tag

  opaque type __darwin_size_t = CUnsignedLongInt
  object __darwin_size_t: 
    given _tag: Tag[__darwin_size_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): __darwin_size_t = o

  type __darwin_socklen_t = __uint32_t
  object __darwin_socklen_t: 
    given _tag: Tag[__darwin_socklen_t] = __uint32_t._tag

  opaque type __darwin_ssize_t = CLongInt
  object __darwin_ssize_t: 
    given _tag: Tag[__darwin_ssize_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_ssize_t = o

  type __darwin_suseconds_t = __int32_t
  object __darwin_suseconds_t: 
    given _tag: Tag[__darwin_suseconds_t] = __int32_t._tag

  opaque type __darwin_time_t = CLongInt
  object __darwin_time_t: 
    given _tag: Tag[__darwin_time_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_time_t = o

  type __darwin_uid_t = __uint32_t
  object __darwin_uid_t: 
    given _tag: Tag[__darwin_uid_t] = __uint32_t._tag

  type __darwin_useconds_t = __uint32_t
  object __darwin_useconds_t: 
    given _tag: Tag[__darwin_useconds_t] = __uint32_t._tag

  opaque type __darwin_uuid_string_t = CArray[CChar, Nat.Digit2[Nat._3, Nat._7]]
  object __darwin_uuid_string_t: 
    given _tag: Tag[__darwin_uuid_string_t] = Tag.CArray[CChar, Nat.Digit2[Nat._3, Nat._7]](Tag.Byte, Tag.Digit2[Nat._3, Nat._7](Tag.Nat3, Tag.Nat7))
    inline def apply(inline o: CArray[CChar, Nat.Digit2[Nat._3, Nat._7]]): __darwin_uuid_string_t = o

  opaque type __darwin_uuid_t = CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]]
  object __darwin_uuid_t: 
    given _tag: Tag[__darwin_uuid_t] = Tag.CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]](Tag.UByte, Tag.Digit2[Nat._1, Nat._6](Tag.Nat1, Tag.Nat6))
    inline def apply(inline o: CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]]): __darwin_uuid_t = o

  type __darwin_va_list = __builtin_va_list
  object __darwin_va_list: 
    given _tag: Tag[__darwin_va_list] = __builtin_va_list._tag

  opaque type __darwin_wchar_t = CInt
  object __darwin_wchar_t: 
    given _tag: Tag[__darwin_wchar_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_wchar_t = o

  opaque type __darwin_wint_t = CInt
  object __darwin_wint_t: 
    given _tag: Tag[__darwin_wint_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_wint_t = o

  opaque type __int16_t = CShort
  object __int16_t: 
    given _tag: Tag[__int16_t] = Tag.Short
    inline def apply(inline o: CShort): __int16_t = o

  opaque type __int32_t = CInt
  object __int32_t: 
    given _tag: Tag[__int32_t] = Tag.Int
    inline def apply(inline o: CInt): __int32_t = o

  opaque type __int64_t = CLongLong
  object __int64_t: 
    given _tag: Tag[__int64_t] = Tag.Long
    inline def apply(inline o: CLongLong): __int64_t = o

  opaque type __int8_t = CChar
  object __int8_t: 
    given _tag: Tag[__int8_t] = Tag.Byte
    inline def apply(inline o: CChar): __int8_t = o

  opaque type __uint16_t = CUnsignedShort
  object __uint16_t: 
    given _tag: Tag[__uint16_t] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): __uint16_t = o

  opaque type __uint32_t = CUnsignedInt
  object __uint32_t: 
    given _tag: Tag[__uint32_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __uint32_t = o

  opaque type __uint64_t = CUnsignedLongLong
  object __uint64_t: 
    given _tag: Tag[__uint64_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongLong): __uint64_t = o

  opaque type __uint8_t = CUnsignedChar
  object __uint8_t: 
    given _tag: Tag[__uint8_t] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): __uint8_t = o

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

  opaque type _dummy_array435 = CArray[CChar, Nat._1]
  object _dummy_array435: 
    given _tag: Tag[_dummy_array435] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array435 = o

  opaque type _dummy_array436 = CArray[CChar, Nat._1]
  object _dummy_array436: 
    given _tag: Tag[_dummy_array436] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array436 = o

  opaque type _dummy_array440 = CArray[CChar, Nat._1]
  object _dummy_array440: 
    given _tag: Tag[_dummy_array440] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array440 = o

  opaque type _dummy_array5809 = CArray[CChar, Nat._1]
  object _dummy_array5809: 
    given _tag: Tag[_dummy_array5809] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array5809 = o

  opaque type _dummy_array5810 = CArray[CChar, Nat._1]
  object _dummy_array5810: 
    given _tag: Tag[_dummy_array5810] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array5810 = o

  opaque type _dummy_array5811 = CArray[CChar, Nat._1]
  object _dummy_array5811: 
    given _tag: Tag[_dummy_array5811] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array5811 = o

  opaque type _dummy_array5812 = CArray[CChar, Nat._1]
  object _dummy_array5812: 
    given _tag: Tag[_dummy_array5812] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array5812 = o

  opaque type _dummy_array5813 = CArray[CChar, Nat._1]
  object _dummy_array5813: 
    given _tag: Tag[_dummy_array5813] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array5813 = o

  opaque type _dummy_array5814 = CArray[CChar, Nat._1]
  object _dummy_array5814: 
    given _tag: Tag[_dummy_array5814] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array5814 = o

  opaque type _dummy_array5815 = CArray[CChar, Nat._1]
  object _dummy_array5815: 
    given _tag: Tag[_dummy_array5815] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array5815 = o

  opaque type _dummy_array5816 = CArray[CChar, Nat._1]
  object _dummy_array5816: 
    given _tag: Tag[_dummy_array5816] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array5816 = o

  opaque type _dummy_array5817 = CArray[CChar, Nat._1]
  object _dummy_array5817: 
    given _tag: Tag[_dummy_array5817] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array5817 = o

  opaque type _dummy_array5821 = CArray[CChar, Nat._1]
  object _dummy_array5821: 
    given _tag: Tag[_dummy_array5821] = Tag.CArray[CChar, Nat._1](Tag.Byte, Tag.Nat1)
    inline def apply(inline o: CArray[CChar, Nat._1]): _dummy_array5821 = o

  opaque type int16_t = CShort
  object int16_t: 
    given _tag: Tag[int16_t] = Tag.Short
    inline def apply(inline o: CShort): int16_t = o

  opaque type int32_t = CInt
  object int32_t: 
    given _tag: Tag[int32_t] = Tag.Int
    inline def apply(inline o: CInt): int32_t = o

  opaque type int64_t = CLongLong
  object int64_t: 
    given _tag: Tag[int64_t] = Tag.Long
    inline def apply(inline o: CLongLong): int64_t = o

  opaque type int8_t = CChar
  object int8_t: 
    given _tag: Tag[int8_t] = Tag.Byte
    inline def apply(inline o: CChar): int8_t = o

  type int_fast16_t = int16_t
  object int_fast16_t: 
    given _tag: Tag[int_fast16_t] = int16_t._tag

  type int_fast32_t = int32_t
  object int_fast32_t: 
    given _tag: Tag[int_fast32_t] = int32_t._tag

  type int_fast64_t = int64_t
  object int_fast64_t: 
    given _tag: Tag[int_fast64_t] = int64_t._tag

  type int_fast8_t = int8_t
  object int_fast8_t: 
    given _tag: Tag[int_fast8_t] = int8_t._tag

  type int_least16_t = int16_t
  object int_least16_t: 
    given _tag: Tag[int_least16_t] = int16_t._tag

  type int_least32_t = int32_t
  object int_least32_t: 
    given _tag: Tag[int_least32_t] = int32_t._tag

  type int_least64_t = int64_t
  object int_least64_t: 
    given _tag: Tag[int_least64_t] = int64_t._tag

  type int_least8_t = int8_t
  object int_least8_t: 
    given _tag: Tag[int_least8_t] = int8_t._tag

  opaque type intmax_t = CLongInt
  object intmax_t: 
    given _tag: Tag[intmax_t] = Tag.Long
    inline def apply(inline o: CLongInt): intmax_t = o

  type intptr_t = __darwin_intptr_t
  object intptr_t: 
    given _tag: Tag[intptr_t] = __darwin_intptr_t._tag

  opaque type nk_bool = CInt
  object nk_bool: 
    given _tag: Tag[nk_bool] = Tag.Int
    inline def apply(inline o: CInt): nk_bool = o

  type nk_byte = uint8_t
  object nk_byte: 
    given _tag: Tag[nk_byte] = uint8_t._tag

  type nk_char = int8_t
  object nk_char: 
    given _tag: Tag[nk_char] = int8_t._tag

  opaque type nk_command_custom_callback = CFuncPtr6[Ptr[Byte], CShort, CShort, CUnsignedShort, CUnsignedShort, nk_handle, Unit]
  object nk_command_custom_callback: 
    given _tag: Tag[nk_command_custom_callback] = Tag.materializeCFuncPtr6[Ptr[Byte], CShort, CShort, CUnsignedShort, CUnsignedShort, nk_handle, Unit]
    inline def apply(inline o: CFuncPtr6[Ptr[Byte], CShort, CShort, CUnsignedShort, CUnsignedShort, nk_handle, Unit]): nk_command_custom_callback = o

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

  type nk_int = int32_t
  object nk_int: 
    given _tag: Tag[nk_int] = int32_t._tag

  opaque type nk_plugin_alloc = CFuncPtr3[nk_handle, Ptr[Byte], nk_size, Ptr[Byte]]
  object nk_plugin_alloc: 
    given _tag: Tag[nk_plugin_alloc] = Tag.materializeCFuncPtr3[nk_handle, Ptr[Byte], nk_size, Ptr[Byte]]
    inline def apply(inline o: CFuncPtr3[nk_handle, Ptr[Byte], nk_size, Ptr[Byte]]): nk_plugin_alloc = o

  opaque type nk_plugin_copy = CFuncPtr3[nk_handle, CString, CInt, Unit]
  object nk_plugin_copy: 
    given _tag: Tag[nk_plugin_copy] = Tag.materializeCFuncPtr3[nk_handle, CString, CInt, Unit]
    inline def apply(inline o: CFuncPtr3[nk_handle, CString, CInt, Unit]): nk_plugin_copy = o

  opaque type nk_plugin_filter = CFuncPtr2[Ptr[nk_text_edit], nk_rune, nk_bool]
  object nk_plugin_filter: 
    given _tag: Tag[nk_plugin_filter] = Tag.materializeCFuncPtr2[Ptr[nk_text_edit], nk_rune, nk_bool]
    inline def apply(inline o: CFuncPtr2[Ptr[nk_text_edit], nk_rune, nk_bool]): nk_plugin_filter = o

  opaque type nk_plugin_free = CFuncPtr2[nk_handle, Ptr[Byte], Unit]
  object nk_plugin_free: 
    given _tag: Tag[nk_plugin_free] = Tag.materializeCFuncPtr2[nk_handle, Ptr[Byte], Unit]
    inline def apply(inline o: CFuncPtr2[nk_handle, Ptr[Byte], Unit]): nk_plugin_free = o

  opaque type nk_plugin_paste = CFuncPtr2[nk_handle, Ptr[nk_text_edit], Unit]
  object nk_plugin_paste: 
    given _tag: Tag[nk_plugin_paste] = Tag.materializeCFuncPtr2[nk_handle, Ptr[nk_text_edit], Unit]
    inline def apply(inline o: CFuncPtr2[nk_handle, Ptr[nk_text_edit], Unit]): nk_plugin_paste = o

  type nk_ptr = uintptr_t
  object nk_ptr: 
    given _tag: Tag[nk_ptr] = uintptr_t._tag

  opaque type nk_query_font_glyph_f = CFuncPtr5[nk_handle, Float, Ptr[nk_user_font_glyph], nk_rune, nk_rune, Unit]
  object nk_query_font_glyph_f: 
    given _tag: Tag[nk_query_font_glyph_f] = Tag.materializeCFuncPtr5[nk_handle, Float, Ptr[nk_user_font_glyph], nk_rune, nk_rune, Unit]
    inline def apply(inline o: CFuncPtr5[nk_handle, Float, Ptr[nk_user_font_glyph], nk_rune, nk_rune, Unit]): nk_query_font_glyph_f = o

  type nk_rune = nk_uint
  object nk_rune: 
    given _tag: Tag[nk_rune] = nk_uint._tag

  type nk_short = int16_t
  object nk_short: 
    given _tag: Tag[nk_short] = int16_t._tag

  type nk_size = uintptr_t
  object nk_size: 
    given _tag: Tag[nk_size] = uintptr_t._tag

  opaque type nk_text_width_f = CFuncPtr4[nk_handle, Float, CString, CInt, Float]
  object nk_text_width_f: 
    given _tag: Tag[nk_text_width_f] = Tag.materializeCFuncPtr4[nk_handle, Float, CString, CInt, Float]
    inline def apply(inline o: CFuncPtr4[nk_handle, Float, CString, CInt, Float]): nk_text_width_f = o

  type nk_uchar = uint8_t
  object nk_uchar: 
    given _tag: Tag[nk_uchar] = uint8_t._tag

  type nk_uint = uint32_t
  object nk_uint: 
    given _tag: Tag[nk_uint] = uint32_t._tag

  type nk_ushort = uint16_t
  object nk_ushort: 
    given _tag: Tag[nk_ushort] = uint16_t._tag

  type register_t = int64_t
  object register_t: 
    given _tag: Tag[register_t] = int64_t._tag

  opaque type stbrp_coord = CInt
  object stbrp_coord: 
    given _tag: Tag[stbrp_coord] = Tag.Int
    inline def apply(inline o: CInt): stbrp_coord = o

  type syscall_arg_t = u_int64_t
  object syscall_arg_t: 
    given _tag: Tag[syscall_arg_t] = u_int64_t._tag

  opaque type u_int16_t = CUnsignedShort
  object u_int16_t: 
    given _tag: Tag[u_int16_t] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): u_int16_t = o

  opaque type u_int32_t = CUnsignedInt
  object u_int32_t: 
    given _tag: Tag[u_int32_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): u_int32_t = o

  opaque type u_int64_t = CUnsignedLongLong
  object u_int64_t: 
    given _tag: Tag[u_int64_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongLong): u_int64_t = o

  opaque type u_int8_t = CUnsignedChar
  object u_int8_t: 
    given _tag: Tag[u_int8_t] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): u_int8_t = o

  opaque type uint16_t = CUnsignedShort
  object uint16_t: 
    given _tag: Tag[uint16_t] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): uint16_t = o

  opaque type uint32_t = CUnsignedInt
  object uint32_t: 
    given _tag: Tag[uint32_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): uint32_t = o

  opaque type uint64_t = CUnsignedLongLong
  object uint64_t: 
    given _tag: Tag[uint64_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongLong): uint64_t = o

  opaque type uint8_t = CUnsignedChar
  object uint8_t: 
    given _tag: Tag[uint8_t] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): uint8_t = o

  type uint_fast16_t = uint16_t
  object uint_fast16_t: 
    given _tag: Tag[uint_fast16_t] = uint16_t._tag

  type uint_fast32_t = uint32_t
  object uint_fast32_t: 
    given _tag: Tag[uint_fast32_t] = uint32_t._tag

  type uint_fast64_t = uint64_t
  object uint_fast64_t: 
    given _tag: Tag[uint_fast64_t] = uint64_t._tag

  type uint_fast8_t = uint8_t
  object uint_fast8_t: 
    given _tag: Tag[uint_fast8_t] = uint8_t._tag

  type uint_least16_t = uint16_t
  object uint_least16_t: 
    given _tag: Tag[uint_least16_t] = uint16_t._tag

  type uint_least32_t = uint32_t
  object uint_least32_t: 
    given _tag: Tag[uint_least32_t] = uint32_t._tag

  type uint_least64_t = uint64_t
  object uint_least64_t: 
    given _tag: Tag[uint_least64_t] = uint64_t._tag

  type uint_least8_t = uint8_t
  object uint_least8_t: 
    given _tag: Tag[uint_least8_t] = uint8_t._tag

  opaque type uintmax_t = CUnsignedLongInt
  object uintmax_t: 
    given _tag: Tag[uintmax_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): uintmax_t = o

  opaque type uintptr_t = CUnsignedLongInt
  object uintptr_t: 
    given _tag: Tag[uintptr_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): uintptr_t = o

  type user_addr_t = u_int64_t
  object user_addr_t: 
    given _tag: Tag[user_addr_t] = u_int64_t._tag

  type user_long_t = int64_t
  object user_long_t: 
    given _tag: Tag[user_long_t] = int64_t._tag

  type user_off_t = int64_t
  object user_off_t: 
    given _tag: Tag[user_off_t] = int64_t._tag

  type user_size_t = u_int64_t
  object user_size_t: 
    given _tag: Tag[user_size_t] = u_int64_t._tag

  type user_ssize_t = int64_t
  object user_ssize_t: 
    given _tag: Tag[user_ssize_t] = int64_t._tag

  type user_time_t = int64_t
  object user_time_t: 
    given _tag: Tag[user_time_t] = int64_t._tag

  type user_ulong_t = u_int64_t
  object user_ulong_t: 
    given _tag: Tag[user_ulong_t] = u_int64_t._tag
  opaque type __darwin_pthread_attr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object __darwin_pthread_attr_t:
    given _tag: Tag[__darwin_pthread_attr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    def apply()(using Zone): Ptr[__darwin_pthread_attr_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_attr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]])(using Zone): Ptr[__darwin_pthread_attr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_attr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_cond_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
  object __darwin_pthread_cond_t:
    given _tag: Tag[__darwin_pthread_cond_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
    def apply()(using Zone): Ptr[__darwin_pthread_cond_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_cond_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]])(using Zone): Ptr[__darwin_pthread_cond_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_cond_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_condattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_condattr_t:
    given _tag: Tag[__darwin_pthread_condattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[__darwin_pthread_condattr_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_condattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[__darwin_pthread_condattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_condattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_handler_rec = CStruct3[CFuncPtr1[Ptr[Byte], Unit], Ptr[Byte], Ptr[Byte]]
  object __darwin_pthread_handler_rec:
    given _tag: Tag[__darwin_pthread_handler_rec] = Tag.materializeCStruct3Tag[CFuncPtr1[Ptr[Byte], Unit], Ptr[Byte], Ptr[Byte]]
    def apply()(using Zone): Ptr[__darwin_pthread_handler_rec] = scala.scalanative.unsafe.alloc[__darwin_pthread_handler_rec](1)
    def apply(__routine: CFuncPtr1[Ptr[Byte], Unit], __arg: Ptr[Byte], __next: Ptr[__darwin_pthread_handler_rec])(using Zone): Ptr[__darwin_pthread_handler_rec] = 
      val ____ptr = apply()
      (!____ptr).__routine = __routine
      (!____ptr).__arg = __arg
      (!____ptr).__next = __next
      ____ptr
    extension (struct: __darwin_pthread_handler_rec)
      def __routine: CFuncPtr1[Ptr[Byte], Unit] = struct._1
      def __routine_=(value: CFuncPtr1[Ptr[Byte], Unit]): Unit = !struct.at1 = value
      def __arg: Ptr[Byte] = struct._2
      def __arg_=(value: Ptr[Byte]): Unit = !struct.at2 = value
      def __next: Ptr[__darwin_pthread_handler_rec] = struct._3.asInstanceOf[Ptr[__darwin_pthread_handler_rec]]
      def __next_=(value: Ptr[__darwin_pthread_handler_rec]): Unit = !struct.at3 = value.asInstanceOf[Ptr[Byte]]

  opaque type __darwin_pthread_mutex_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object __darwin_pthread_mutex_t:
    given _tag: Tag[__darwin_pthread_mutex_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    def apply()(using Zone): Ptr[__darwin_pthread_mutex_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_mutex_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]])(using Zone): Ptr[__darwin_pthread_mutex_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_mutex_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_mutexattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_mutexattr_t:
    given _tag: Tag[__darwin_pthread_mutexattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[__darwin_pthread_mutexattr_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_mutexattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[__darwin_pthread_mutexattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_mutexattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_once_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_once_t:
    given _tag: Tag[__darwin_pthread_once_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[__darwin_pthread_once_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_once_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[__darwin_pthread_once_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_once_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_rwlock_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
  object __darwin_pthread_rwlock_t:
    given _tag: Tag[__darwin_pthread_rwlock_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
    def apply()(using Zone): Ptr[__darwin_pthread_rwlock_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_rwlock_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]])(using Zone): Ptr[__darwin_pthread_rwlock_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_rwlock_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_rwlockattr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
  object __darwin_pthread_rwlockattr_t:
    given _tag: Tag[__darwin_pthread_rwlockattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
    def apply()(using Zone): Ptr[__darwin_pthread_rwlockattr_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_rwlockattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]])(using Zone): Ptr[__darwin_pthread_rwlockattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_rwlockattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_attr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object _opaque_pthread_attr_t:
    given _tag: Tag[_opaque_pthread_attr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    def apply()(using Zone): Ptr[_opaque_pthread_attr_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_attr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]])(using Zone): Ptr[_opaque_pthread_attr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_attr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_cond_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
  object _opaque_pthread_cond_t:
    given _tag: Tag[_opaque_pthread_cond_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
    def apply()(using Zone): Ptr[_opaque_pthread_cond_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_cond_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]])(using Zone): Ptr[_opaque_pthread_cond_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_cond_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_condattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_condattr_t:
    given _tag: Tag[_opaque_pthread_condattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[_opaque_pthread_condattr_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_condattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[_opaque_pthread_condattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_condattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_mutex_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object _opaque_pthread_mutex_t:
    given _tag: Tag[_opaque_pthread_mutex_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    def apply()(using Zone): Ptr[_opaque_pthread_mutex_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_mutex_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]])(using Zone): Ptr[_opaque_pthread_mutex_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_mutex_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_mutexattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_mutexattr_t:
    given _tag: Tag[_opaque_pthread_mutexattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[_opaque_pthread_mutexattr_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_mutexattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[_opaque_pthread_mutexattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_mutexattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_once_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_once_t:
    given _tag: Tag[_opaque_pthread_once_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[_opaque_pthread_once_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_once_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[_opaque_pthread_once_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_once_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_rwlock_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
  object _opaque_pthread_rwlock_t:
    given _tag: Tag[_opaque_pthread_rwlock_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
    def apply()(using Zone): Ptr[_opaque_pthread_rwlock_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_rwlock_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]])(using Zone): Ptr[_opaque_pthread_rwlock_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_rwlock_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_rwlockattr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
  object _opaque_pthread_rwlockattr_t:
    given _tag: Tag[_opaque_pthread_rwlockattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
    def apply()(using Zone): Ptr[_opaque_pthread_rwlockattr_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_rwlockattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]])(using Zone): Ptr[_opaque_pthread_rwlockattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_rwlockattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_t = CStruct3[CLongInt, Ptr[Byte], CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]]
  object _opaque_pthread_t:
    given _tag: Tag[_opaque_pthread_t] = Tag.materializeCStruct3Tag[CLongInt, Ptr[Byte], CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]]
    def apply()(using Zone): Ptr[_opaque_pthread_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_t](1)
    def apply(__sig: CLongInt, __cleanup_stack: Ptr[__darwin_pthread_handler_rec], __opaque: CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]])(using Zone): Ptr[_opaque_pthread_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__cleanup_stack = __cleanup_stack
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __cleanup_stack: Ptr[__darwin_pthread_handler_rec] = struct._2.asInstanceOf[Ptr[__darwin_pthread_handler_rec]]
      def __cleanup_stack_=(value: Ptr[__darwin_pthread_handler_rec]): Unit = !struct.at2 = value.asInstanceOf[Ptr[Byte]]
      def __opaque: CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]] = struct._3
      def __opaque_=(value: CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]): Unit = !struct.at3 = value

  opaque type nk_allocator = CStruct3[nk_handle, nk_plugin_alloc, nk_plugin_free]
  object nk_allocator:
    given _tag: Tag[nk_allocator] = Tag.materializeCStruct3Tag[nk_handle, nk_plugin_alloc, nk_plugin_free]
    def apply()(using Zone): Ptr[nk_allocator] = scala.scalanative.unsafe.alloc[nk_allocator](1)
    def apply(userdata: nk_handle, alloc: nk_plugin_alloc, free: nk_plugin_free)(using Zone): Ptr[nk_allocator] = 
      val ____ptr = apply()
      (!____ptr).userdata = userdata
      (!____ptr).alloc = alloc
      (!____ptr).free = free
      ____ptr
    extension (struct: nk_allocator)
      def userdata: nk_handle = struct._1
      def userdata_=(value: nk_handle): Unit = !struct.at1 = value
      def alloc: nk_plugin_alloc = struct._2
      def alloc_=(value: nk_plugin_alloc): Unit = !struct.at2 = value
      def free: nk_plugin_free = struct._3
      def free_=(value: nk_plugin_free): Unit = !struct.at3 = value

  opaque type nk_buffer = CStruct9[CArray[nk_buffer_marker, Nat._2], nk_allocator, nk_allocation_type, nk_memory, Float, nk_size, nk_size, nk_size, nk_size]
  object nk_buffer:
    given _tag: Tag[nk_buffer] = Tag.materializeCStruct9Tag[CArray[nk_buffer_marker, Nat._2], nk_allocator, nk_allocation_type, nk_memory, Float, nk_size, nk_size, nk_size, nk_size]
    def apply()(using Zone): Ptr[nk_buffer] = scala.scalanative.unsafe.alloc[nk_buffer](1)
    def apply(marker: CArray[nk_buffer_marker, Nat._2], pool: nk_allocator, `type`: nk_allocation_type, memory: nk_memory, grow_factor: Float, allocated: nk_size, needed: nk_size, calls: nk_size, size: nk_size)(using Zone): Ptr[nk_buffer] = 
      val ____ptr = apply()
      (!____ptr).marker = marker
      (!____ptr).pool = pool
      (!____ptr).`type` = `type`
      (!____ptr).memory = memory
      (!____ptr).grow_factor = grow_factor
      (!____ptr).allocated = allocated
      (!____ptr).needed = needed
      (!____ptr).calls = calls
      (!____ptr).size = size
      ____ptr
    extension (struct: nk_buffer)
      def marker: CArray[nk_buffer_marker, Nat._2] = struct._1
      def marker_=(value: CArray[nk_buffer_marker, Nat._2]): Unit = !struct.at1 = value
      def pool: nk_allocator = struct._2
      def pool_=(value: nk_allocator): Unit = !struct.at2 = value
      def `type`: nk_allocation_type = struct._3
      def type_=(value: nk_allocation_type): Unit = !struct.at3 = value
      def memory: nk_memory = struct._4
      def memory_=(value: nk_memory): Unit = !struct.at4 = value
      def grow_factor: Float = struct._5
      def grow_factor_=(value: Float): Unit = !struct.at5 = value
      def allocated: nk_size = struct._6
      def allocated_=(value: nk_size): Unit = !struct.at6 = value
      def needed: nk_size = struct._7
      def needed_=(value: nk_size): Unit = !struct.at7 = value
      def calls: nk_size = struct._8
      def calls_=(value: nk_size): Unit = !struct.at8 = value
      def size: nk_size = struct._9
      def size_=(value: nk_size): Unit = !struct.at9 = value

  opaque type nk_buffer_marker = CStruct2[nk_bool, nk_size]
  object nk_buffer_marker:
    given _tag: Tag[nk_buffer_marker] = Tag.materializeCStruct2Tag[nk_bool, nk_size]
    def apply()(using Zone): Ptr[nk_buffer_marker] = scala.scalanative.unsafe.alloc[nk_buffer_marker](1)
    def apply(active: nk_bool, offset: nk_size)(using Zone): Ptr[nk_buffer_marker] = 
      val ____ptr = apply()
      (!____ptr).active = active
      (!____ptr).offset = offset
      ____ptr
    extension (struct: nk_buffer_marker)
      def active: nk_bool = struct._1
      def active_=(value: nk_bool): Unit = !struct.at1 = value
      def offset: nk_size = struct._2
      def offset_=(value: nk_size): Unit = !struct.at2 = value

  opaque type nk_chart = CStruct6[CInt, Float, Float, Float, Float, CArray[nk_chart_slot, Nat._4]]
  object nk_chart:
    given _tag: Tag[nk_chart] = Tag.materializeCStruct6Tag[CInt, Float, Float, Float, Float, CArray[nk_chart_slot, Nat._4]]
    def apply()(using Zone): Ptr[nk_chart] = scala.scalanative.unsafe.alloc[nk_chart](1)
    def apply(slot: CInt, x: Float, y: Float, w: Float, h: Float, slots: CArray[nk_chart_slot, Nat._4])(using Zone): Ptr[nk_chart] = 
      val ____ptr = apply()
      (!____ptr).slot = slot
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).slots = slots
      ____ptr
    extension (struct: nk_chart)
      def slot: CInt = struct._1
      def slot_=(value: CInt): Unit = !struct.at1 = value
      def x: Float = struct._2
      def x_=(value: Float): Unit = !struct.at2 = value
      def y: Float = struct._3
      def y_=(value: Float): Unit = !struct.at3 = value
      def w: Float = struct._4
      def w_=(value: Float): Unit = !struct.at4 = value
      def h: Float = struct._5
      def h_=(value: Float): Unit = !struct.at5 = value
      def slots: CArray[nk_chart_slot, Nat._4] = struct._6
      def slots_=(value: CArray[nk_chart_slot, Nat._4]): Unit = !struct.at6 = value

  opaque type nk_chart_slot = CStruct9[nk_chart_type, nk_color, nk_color, Float, Float, Float, CInt, nk_vec2, CInt]
  object nk_chart_slot:
    given _tag: Tag[nk_chart_slot] = Tag.materializeCStruct9Tag[nk_chart_type, nk_color, nk_color, Float, Float, Float, CInt, nk_vec2, CInt]
    def apply()(using Zone): Ptr[nk_chart_slot] = scala.scalanative.unsafe.alloc[nk_chart_slot](1)
    def apply(`type`: nk_chart_type, color: nk_color, highlight: nk_color, min: Float, max: Float, range: Float, count: CInt, last: nk_vec2, index: CInt)(using Zone): Ptr[nk_chart_slot] = 
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).color = color
      (!____ptr).highlight = highlight
      (!____ptr).min = min
      (!____ptr).max = max
      (!____ptr).range = range
      (!____ptr).count = count
      (!____ptr).last = last
      (!____ptr).index = index
      ____ptr
    extension (struct: nk_chart_slot)
      def `type`: nk_chart_type = struct._1
      def type_=(value: nk_chart_type): Unit = !struct.at1 = value
      def color: nk_color = struct._2
      def color_=(value: nk_color): Unit = !struct.at2 = value
      def highlight: nk_color = struct._3
      def highlight_=(value: nk_color): Unit = !struct.at3 = value
      def min: Float = struct._4
      def min_=(value: Float): Unit = !struct.at4 = value
      def max: Float = struct._5
      def max_=(value: Float): Unit = !struct.at5 = value
      def range: Float = struct._6
      def range_=(value: Float): Unit = !struct.at6 = value
      def count: CInt = struct._7
      def count_=(value: CInt): Unit = !struct.at7 = value
      def last: nk_vec2 = struct._8
      def last_=(value: nk_vec2): Unit = !struct.at8 = value
      def index: CInt = struct._9
      def index_=(value: CInt): Unit = !struct.at9 = value

  opaque type nk_clipboard = CStruct3[nk_handle, Ptr[Byte], nk_plugin_copy]
  object nk_clipboard:
    given _tag: Tag[nk_clipboard] = Tag.materializeCStruct3Tag[nk_handle, Ptr[Byte], nk_plugin_copy]
    def apply()(using Zone): Ptr[nk_clipboard] = scala.scalanative.unsafe.alloc[nk_clipboard](1)
    def apply(userdata: nk_handle, paste: nk_plugin_paste, copy: nk_plugin_copy)(using Zone): Ptr[nk_clipboard] = 
      val ____ptr = apply()
      (!____ptr).userdata = userdata
      (!____ptr).paste = paste
      (!____ptr).copy = copy
      ____ptr
    extension (struct: nk_clipboard)
      def userdata: nk_handle = struct._1
      def userdata_=(value: nk_handle): Unit = !struct.at1 = value
      def paste: nk_plugin_paste = struct._2.asInstanceOf[nk_plugin_paste]
      def paste_=(value: nk_plugin_paste): Unit = !struct.at2 = value.asInstanceOf[Ptr[Byte]]
      def copy: nk_plugin_copy = struct._3
      def copy_=(value: nk_plugin_copy): Unit = !struct.at3 = value

  opaque type nk_color = CStruct4[nk_byte, nk_byte, nk_byte, nk_byte]
  object nk_color:
    given _tag: Tag[nk_color] = Tag.materializeCStruct4Tag[nk_byte, nk_byte, nk_byte, nk_byte]
    def apply()(using Zone): Ptr[nk_color] = scala.scalanative.unsafe.alloc[nk_color](1)
    def apply(r: nk_byte, g: nk_byte, b: nk_byte, a: nk_byte)(using Zone): Ptr[nk_color] = 
      val ____ptr = apply()
      (!____ptr).r = r
      (!____ptr).g = g
      (!____ptr).b = b
      (!____ptr).a = a
      ____ptr
    extension (struct: nk_color)
      def r: nk_byte = struct._1
      def r_=(value: nk_byte): Unit = !struct.at1 = value
      def g: nk_byte = struct._2
      def g_=(value: nk_byte): Unit = !struct.at2 = value
      def b: nk_byte = struct._3
      def b_=(value: nk_byte): Unit = !struct.at3 = value
      def a: nk_byte = struct._4
      def a_=(value: nk_byte): Unit = !struct.at4 = value

  opaque type nk_colorf = CStruct4[Float, Float, Float, Float]
  object nk_colorf:
    given _tag: Tag[nk_colorf] = Tag.materializeCStruct4Tag[Float, Float, Float, Float]
    def apply()(using Zone): Ptr[nk_colorf] = scala.scalanative.unsafe.alloc[nk_colorf](1)
    def apply(r: Float, g: Float, b: Float, a: Float)(using Zone): Ptr[nk_colorf] = 
      val ____ptr = apply()
      (!____ptr).r = r
      (!____ptr).g = g
      (!____ptr).b = b
      (!____ptr).a = a
      ____ptr
    extension (struct: nk_colorf)
      def r: Float = struct._1
      def r_=(value: Float): Unit = !struct.at1 = value
      def g: Float = struct._2
      def g_=(value: Float): Unit = !struct.at2 = value
      def b: Float = struct._3
      def b_=(value: Float): Unit = !struct.at3 = value
      def a: Float = struct._4
      def a_=(value: Float): Unit = !struct.at4 = value

  opaque type nk_command = CStruct2[nk_command_type, nk_size]
  object nk_command:
    given _tag: Tag[nk_command] = Tag.materializeCStruct2Tag[nk_command_type, nk_size]
    def apply()(using Zone): Ptr[nk_command] = scala.scalanative.unsafe.alloc[nk_command](1)
    def apply(`type`: nk_command_type, next: nk_size)(using Zone): Ptr[nk_command] = 
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).next = next
      ____ptr
    extension (struct: nk_command)
      def `type`: nk_command_type = struct._1
      def type_=(value: nk_command_type): Unit = !struct.at1 = value
      def next: nk_size = struct._2
      def next_=(value: nk_size): Unit = !struct.at2 = value

  opaque type nk_command_arc = CStruct7[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, CArray[Float, Nat._2], nk_color]
  object nk_command_arc:
    given _tag: Tag[nk_command_arc] = Tag.materializeCStruct7Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, CArray[Float, Nat._2], nk_color]
    def apply()(using Zone): Ptr[nk_command_arc] = scala.scalanative.unsafe.alloc[nk_command_arc](1)
    def apply(header: nk_command, cx: CShort, cy: CShort, r: CUnsignedShort, line_thickness: CUnsignedShort, a: CArray[Float, Nat._2], color: nk_color)(using Zone): Ptr[nk_command_arc] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).cx = cx
      (!____ptr).cy = cy
      (!____ptr).r = r
      (!____ptr).line_thickness = line_thickness
      (!____ptr).a = a
      (!____ptr).color = color
      ____ptr
    extension (struct: nk_command_arc)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def cx: CShort = struct._2
      def cx_=(value: CShort): Unit = !struct.at2 = value
      def cy: CShort = struct._3
      def cy_=(value: CShort): Unit = !struct.at3 = value
      def r: CUnsignedShort = struct._4
      def r_=(value: CUnsignedShort): Unit = !struct.at4 = value
      def line_thickness: CUnsignedShort = struct._5
      def line_thickness_=(value: CUnsignedShort): Unit = !struct.at5 = value
      def a: CArray[Float, Nat._2] = struct._6
      def a_=(value: CArray[Float, Nat._2]): Unit = !struct.at6 = value
      def color: nk_color = struct._7
      def color_=(value: nk_color): Unit = !struct.at7 = value

  opaque type nk_command_arc_filled = CStruct6[nk_command, CShort, CShort, CUnsignedShort, CArray[Float, Nat._2], nk_color]
  object nk_command_arc_filled:
    given _tag: Tag[nk_command_arc_filled] = Tag.materializeCStruct6Tag[nk_command, CShort, CShort, CUnsignedShort, CArray[Float, Nat._2], nk_color]
    def apply()(using Zone): Ptr[nk_command_arc_filled] = scala.scalanative.unsafe.alloc[nk_command_arc_filled](1)
    def apply(header: nk_command, cx: CShort, cy: CShort, r: CUnsignedShort, a: CArray[Float, Nat._2], color: nk_color)(using Zone): Ptr[nk_command_arc_filled] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).cx = cx
      (!____ptr).cy = cy
      (!____ptr).r = r
      (!____ptr).a = a
      (!____ptr).color = color
      ____ptr
    extension (struct: nk_command_arc_filled)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def cx: CShort = struct._2
      def cx_=(value: CShort): Unit = !struct.at2 = value
      def cy: CShort = struct._3
      def cy_=(value: CShort): Unit = !struct.at3 = value
      def r: CUnsignedShort = struct._4
      def r_=(value: CUnsignedShort): Unit = !struct.at4 = value
      def a: CArray[Float, Nat._2] = struct._5
      def a_=(value: CArray[Float, Nat._2]): Unit = !struct.at5 = value
      def color: nk_color = struct._6
      def color_=(value: nk_color): Unit = !struct.at6 = value

  opaque type nk_command_buffer = CStruct7[Ptr[nk_buffer], nk_rect, CInt, nk_handle, nk_size, nk_size, nk_size]
  object nk_command_buffer:
    given _tag: Tag[nk_command_buffer] = Tag.materializeCStruct7Tag[Ptr[nk_buffer], nk_rect, CInt, nk_handle, nk_size, nk_size, nk_size]
    def apply()(using Zone): Ptr[nk_command_buffer] = scala.scalanative.unsafe.alloc[nk_command_buffer](1)
    def apply(base: Ptr[nk_buffer], clip: nk_rect, use_clipping: CInt, userdata: nk_handle, begin: nk_size, end: nk_size, last: nk_size)(using Zone): Ptr[nk_command_buffer] = 
      val ____ptr = apply()
      (!____ptr).base = base
      (!____ptr).clip = clip
      (!____ptr).use_clipping = use_clipping
      (!____ptr).userdata = userdata
      (!____ptr).begin = begin
      (!____ptr).end = end
      (!____ptr).last = last
      ____ptr
    extension (struct: nk_command_buffer)
      def base: Ptr[nk_buffer] = struct._1
      def base_=(value: Ptr[nk_buffer]): Unit = !struct.at1 = value
      def clip: nk_rect = struct._2
      def clip_=(value: nk_rect): Unit = !struct.at2 = value
      def use_clipping: CInt = struct._3
      def use_clipping_=(value: CInt): Unit = !struct.at3 = value
      def userdata: nk_handle = struct._4
      def userdata_=(value: nk_handle): Unit = !struct.at4 = value
      def begin: nk_size = struct._5
      def begin_=(value: nk_size): Unit = !struct.at5 = value
      def end: nk_size = struct._6
      def end_=(value: nk_size): Unit = !struct.at6 = value
      def last: nk_size = struct._7
      def last_=(value: nk_size): Unit = !struct.at7 = value

  opaque type nk_command_circle = CStruct7[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, CUnsignedShort, nk_color]
  object nk_command_circle:
    given _tag: Tag[nk_command_circle] = Tag.materializeCStruct7Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, CUnsignedShort, nk_color]
    def apply()(using Zone): Ptr[nk_command_circle] = scala.scalanative.unsafe.alloc[nk_command_circle](1)
    def apply(header: nk_command, x: CShort, y: CShort, line_thickness: CUnsignedShort, w: CUnsignedShort, h: CUnsignedShort, color: nk_color)(using Zone): Ptr[nk_command_circle] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).line_thickness = line_thickness
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).color = color
      ____ptr
    extension (struct: nk_command_circle)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def x: CShort = struct._2
      def x_=(value: CShort): Unit = !struct.at2 = value
      def y: CShort = struct._3
      def y_=(value: CShort): Unit = !struct.at3 = value
      def line_thickness: CUnsignedShort = struct._4
      def line_thickness_=(value: CUnsignedShort): Unit = !struct.at4 = value
      def w: CUnsignedShort = struct._5
      def w_=(value: CUnsignedShort): Unit = !struct.at5 = value
      def h: CUnsignedShort = struct._6
      def h_=(value: CUnsignedShort): Unit = !struct.at6 = value
      def color: nk_color = struct._7
      def color_=(value: nk_color): Unit = !struct.at7 = value

  opaque type nk_command_circle_filled = CStruct6[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color]
  object nk_command_circle_filled:
    given _tag: Tag[nk_command_circle_filled] = Tag.materializeCStruct6Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color]
    def apply()(using Zone): Ptr[nk_command_circle_filled] = scala.scalanative.unsafe.alloc[nk_command_circle_filled](1)
    def apply(header: nk_command, x: CShort, y: CShort, w: CUnsignedShort, h: CUnsignedShort, color: nk_color)(using Zone): Ptr[nk_command_circle_filled] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).color = color
      ____ptr
    extension (struct: nk_command_circle_filled)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def x: CShort = struct._2
      def x_=(value: CShort): Unit = !struct.at2 = value
      def y: CShort = struct._3
      def y_=(value: CShort): Unit = !struct.at3 = value
      def w: CUnsignedShort = struct._4
      def w_=(value: CUnsignedShort): Unit = !struct.at4 = value
      def h: CUnsignedShort = struct._5
      def h_=(value: CUnsignedShort): Unit = !struct.at5 = value
      def color: nk_color = struct._6
      def color_=(value: nk_color): Unit = !struct.at6 = value

  opaque type nk_command_curve = CStruct6[nk_command, CUnsignedShort, nk_vec2i, nk_vec2i, CArray[nk_vec2i, Nat._2], nk_color]
  object nk_command_curve:
    given _tag: Tag[nk_command_curve] = Tag.materializeCStruct6Tag[nk_command, CUnsignedShort, nk_vec2i, nk_vec2i, CArray[nk_vec2i, Nat._2], nk_color]
    def apply()(using Zone): Ptr[nk_command_curve] = scala.scalanative.unsafe.alloc[nk_command_curve](1)
    def apply(header: nk_command, line_thickness: CUnsignedShort, begin: nk_vec2i, end: nk_vec2i, ctrl: CArray[nk_vec2i, Nat._2], color: nk_color)(using Zone): Ptr[nk_command_curve] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).line_thickness = line_thickness
      (!____ptr).begin = begin
      (!____ptr).end = end
      (!____ptr).ctrl = ctrl
      (!____ptr).color = color
      ____ptr
    extension (struct: nk_command_curve)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def line_thickness: CUnsignedShort = struct._2
      def line_thickness_=(value: CUnsignedShort): Unit = !struct.at2 = value
      def begin: nk_vec2i = struct._3
      def begin_=(value: nk_vec2i): Unit = !struct.at3 = value
      def end: nk_vec2i = struct._4
      def end_=(value: nk_vec2i): Unit = !struct.at4 = value
      def ctrl: CArray[nk_vec2i, Nat._2] = struct._5
      def ctrl_=(value: CArray[nk_vec2i, Nat._2]): Unit = !struct.at5 = value
      def color: nk_color = struct._6
      def color_=(value: nk_color): Unit = !struct.at6 = value

  opaque type nk_command_custom = CStruct7[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_handle, nk_command_custom_callback]
  object nk_command_custom:
    given _tag: Tag[nk_command_custom] = Tag.materializeCStruct7Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_handle, nk_command_custom_callback]
    def apply()(using Zone): Ptr[nk_command_custom] = scala.scalanative.unsafe.alloc[nk_command_custom](1)
    def apply(header: nk_command, x: CShort, y: CShort, w: CUnsignedShort, h: CUnsignedShort, callback_data: nk_handle, callback: nk_command_custom_callback)(using Zone): Ptr[nk_command_custom] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).callback_data = callback_data
      (!____ptr).callback = callback
      ____ptr
    extension (struct: nk_command_custom)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def x: CShort = struct._2
      def x_=(value: CShort): Unit = !struct.at2 = value
      def y: CShort = struct._3
      def y_=(value: CShort): Unit = !struct.at3 = value
      def w: CUnsignedShort = struct._4
      def w_=(value: CUnsignedShort): Unit = !struct.at4 = value
      def h: CUnsignedShort = struct._5
      def h_=(value: CUnsignedShort): Unit = !struct.at5 = value
      def callback_data: nk_handle = struct._6
      def callback_data_=(value: nk_handle): Unit = !struct.at6 = value
      def callback: nk_command_custom_callback = struct._7
      def callback_=(value: nk_command_custom_callback): Unit = !struct.at7 = value

  opaque type nk_command_image = CStruct7[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_image, nk_color]
  object nk_command_image:
    given _tag: Tag[nk_command_image] = Tag.materializeCStruct7Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_image, nk_color]
    def apply()(using Zone): Ptr[nk_command_image] = scala.scalanative.unsafe.alloc[nk_command_image](1)
    def apply(header: nk_command, x: CShort, y: CShort, w: CUnsignedShort, h: CUnsignedShort, img: nk_image, col: nk_color)(using Zone): Ptr[nk_command_image] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).img = img
      (!____ptr).col = col
      ____ptr
    extension (struct: nk_command_image)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def x: CShort = struct._2
      def x_=(value: CShort): Unit = !struct.at2 = value
      def y: CShort = struct._3
      def y_=(value: CShort): Unit = !struct.at3 = value
      def w: CUnsignedShort = struct._4
      def w_=(value: CUnsignedShort): Unit = !struct.at4 = value
      def h: CUnsignedShort = struct._5
      def h_=(value: CUnsignedShort): Unit = !struct.at5 = value
      def img: nk_image = struct._6
      def img_=(value: nk_image): Unit = !struct.at6 = value
      def col: nk_color = struct._7
      def col_=(value: nk_color): Unit = !struct.at7 = value

  opaque type nk_command_line = CStruct5[nk_command, CUnsignedShort, nk_vec2i, nk_vec2i, nk_color]
  object nk_command_line:
    given _tag: Tag[nk_command_line] = Tag.materializeCStruct5Tag[nk_command, CUnsignedShort, nk_vec2i, nk_vec2i, nk_color]
    def apply()(using Zone): Ptr[nk_command_line] = scala.scalanative.unsafe.alloc[nk_command_line](1)
    def apply(header: nk_command, line_thickness: CUnsignedShort, begin: nk_vec2i, end: nk_vec2i, color: nk_color)(using Zone): Ptr[nk_command_line] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).line_thickness = line_thickness
      (!____ptr).begin = begin
      (!____ptr).end = end
      (!____ptr).color = color
      ____ptr
    extension (struct: nk_command_line)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def line_thickness: CUnsignedShort = struct._2
      def line_thickness_=(value: CUnsignedShort): Unit = !struct.at2 = value
      def begin: nk_vec2i = struct._3
      def begin_=(value: nk_vec2i): Unit = !struct.at3 = value
      def end: nk_vec2i = struct._4
      def end_=(value: nk_vec2i): Unit = !struct.at4 = value
      def color: nk_color = struct._5
      def color_=(value: nk_color): Unit = !struct.at5 = value

  opaque type nk_command_polygon = CStruct5[nk_command, nk_color, CUnsignedShort, CUnsignedShort, CArray[nk_vec2i, Nat._1]]
  object nk_command_polygon:
    given _tag: Tag[nk_command_polygon] = Tag.materializeCStruct5Tag[nk_command, nk_color, CUnsignedShort, CUnsignedShort, CArray[nk_vec2i, Nat._1]]
    def apply()(using Zone): Ptr[nk_command_polygon] = scala.scalanative.unsafe.alloc[nk_command_polygon](1)
    def apply(header: nk_command, color: nk_color, line_thickness: CUnsignedShort, point_count: CUnsignedShort, points: CArray[nk_vec2i, Nat._1])(using Zone): Ptr[nk_command_polygon] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).color = color
      (!____ptr).line_thickness = line_thickness
      (!____ptr).point_count = point_count
      (!____ptr).points = points
      ____ptr
    extension (struct: nk_command_polygon)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def color: nk_color = struct._2
      def color_=(value: nk_color): Unit = !struct.at2 = value
      def line_thickness: CUnsignedShort = struct._3
      def line_thickness_=(value: CUnsignedShort): Unit = !struct.at3 = value
      def point_count: CUnsignedShort = struct._4
      def point_count_=(value: CUnsignedShort): Unit = !struct.at4 = value
      def points: CArray[nk_vec2i, Nat._1] = struct._5
      def points_=(value: CArray[nk_vec2i, Nat._1]): Unit = !struct.at5 = value

  opaque type nk_command_polygon_filled = CStruct4[nk_command, nk_color, CUnsignedShort, CArray[nk_vec2i, Nat._1]]
  object nk_command_polygon_filled:
    given _tag: Tag[nk_command_polygon_filled] = Tag.materializeCStruct4Tag[nk_command, nk_color, CUnsignedShort, CArray[nk_vec2i, Nat._1]]
    def apply()(using Zone): Ptr[nk_command_polygon_filled] = scala.scalanative.unsafe.alloc[nk_command_polygon_filled](1)
    def apply(header: nk_command, color: nk_color, point_count: CUnsignedShort, points: CArray[nk_vec2i, Nat._1])(using Zone): Ptr[nk_command_polygon_filled] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).color = color
      (!____ptr).point_count = point_count
      (!____ptr).points = points
      ____ptr
    extension (struct: nk_command_polygon_filled)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def color: nk_color = struct._2
      def color_=(value: nk_color): Unit = !struct.at2 = value
      def point_count: CUnsignedShort = struct._3
      def point_count_=(value: CUnsignedShort): Unit = !struct.at3 = value
      def points: CArray[nk_vec2i, Nat._1] = struct._4
      def points_=(value: CArray[nk_vec2i, Nat._1]): Unit = !struct.at4 = value

  opaque type nk_command_polyline = CStruct5[nk_command, nk_color, CUnsignedShort, CUnsignedShort, CArray[nk_vec2i, Nat._1]]
  object nk_command_polyline:
    given _tag: Tag[nk_command_polyline] = Tag.materializeCStruct5Tag[nk_command, nk_color, CUnsignedShort, CUnsignedShort, CArray[nk_vec2i, Nat._1]]
    def apply()(using Zone): Ptr[nk_command_polyline] = scala.scalanative.unsafe.alloc[nk_command_polyline](1)
    def apply(header: nk_command, color: nk_color, line_thickness: CUnsignedShort, point_count: CUnsignedShort, points: CArray[nk_vec2i, Nat._1])(using Zone): Ptr[nk_command_polyline] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).color = color
      (!____ptr).line_thickness = line_thickness
      (!____ptr).point_count = point_count
      (!____ptr).points = points
      ____ptr
    extension (struct: nk_command_polyline)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def color: nk_color = struct._2
      def color_=(value: nk_color): Unit = !struct.at2 = value
      def line_thickness: CUnsignedShort = struct._3
      def line_thickness_=(value: CUnsignedShort): Unit = !struct.at3 = value
      def point_count: CUnsignedShort = struct._4
      def point_count_=(value: CUnsignedShort): Unit = !struct.at4 = value
      def points: CArray[nk_vec2i, Nat._1] = struct._5
      def points_=(value: CArray[nk_vec2i, Nat._1]): Unit = !struct.at5 = value

  opaque type nk_command_rect = CStruct8[nk_command, CUnsignedShort, CUnsignedShort, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color]
  object nk_command_rect:
    given _tag: Tag[nk_command_rect] = Tag.materializeCStruct8Tag[nk_command, CUnsignedShort, CUnsignedShort, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color]
    def apply()(using Zone): Ptr[nk_command_rect] = scala.scalanative.unsafe.alloc[nk_command_rect](1)
    def apply(header: nk_command, rounding: CUnsignedShort, line_thickness: CUnsignedShort, x: CShort, y: CShort, w: CUnsignedShort, h: CUnsignedShort, color: nk_color)(using Zone): Ptr[nk_command_rect] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).rounding = rounding
      (!____ptr).line_thickness = line_thickness
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).color = color
      ____ptr
    extension (struct: nk_command_rect)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def rounding: CUnsignedShort = struct._2
      def rounding_=(value: CUnsignedShort): Unit = !struct.at2 = value
      def line_thickness: CUnsignedShort = struct._3
      def line_thickness_=(value: CUnsignedShort): Unit = !struct.at3 = value
      def x: CShort = struct._4
      def x_=(value: CShort): Unit = !struct.at4 = value
      def y: CShort = struct._5
      def y_=(value: CShort): Unit = !struct.at5 = value
      def w: CUnsignedShort = struct._6
      def w_=(value: CUnsignedShort): Unit = !struct.at6 = value
      def h: CUnsignedShort = struct._7
      def h_=(value: CUnsignedShort): Unit = !struct.at7 = value
      def color: nk_color = struct._8
      def color_=(value: nk_color): Unit = !struct.at8 = value

  opaque type nk_command_rect_filled = CStruct7[nk_command, CUnsignedShort, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color]
  object nk_command_rect_filled:
    given _tag: Tag[nk_command_rect_filled] = Tag.materializeCStruct7Tag[nk_command, CUnsignedShort, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color]
    def apply()(using Zone): Ptr[nk_command_rect_filled] = scala.scalanative.unsafe.alloc[nk_command_rect_filled](1)
    def apply(header: nk_command, rounding: CUnsignedShort, x: CShort, y: CShort, w: CUnsignedShort, h: CUnsignedShort, color: nk_color)(using Zone): Ptr[nk_command_rect_filled] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).rounding = rounding
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).color = color
      ____ptr
    extension (struct: nk_command_rect_filled)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def rounding: CUnsignedShort = struct._2
      def rounding_=(value: CUnsignedShort): Unit = !struct.at2 = value
      def x: CShort = struct._3
      def x_=(value: CShort): Unit = !struct.at3 = value
      def y: CShort = struct._4
      def y_=(value: CShort): Unit = !struct.at4 = value
      def w: CUnsignedShort = struct._5
      def w_=(value: CUnsignedShort): Unit = !struct.at5 = value
      def h: CUnsignedShort = struct._6
      def h_=(value: CUnsignedShort): Unit = !struct.at6 = value
      def color: nk_color = struct._7
      def color_=(value: nk_color): Unit = !struct.at7 = value

  opaque type nk_command_rect_multi_color = CStruct9[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color, nk_color, nk_color, nk_color]
  object nk_command_rect_multi_color:
    given _tag: Tag[nk_command_rect_multi_color] = Tag.materializeCStruct9Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort, nk_color, nk_color, nk_color, nk_color]
    def apply()(using Zone): Ptr[nk_command_rect_multi_color] = scala.scalanative.unsafe.alloc[nk_command_rect_multi_color](1)
    def apply(header: nk_command, x: CShort, y: CShort, w: CUnsignedShort, h: CUnsignedShort, left: nk_color, top: nk_color, bottom: nk_color, right: nk_color)(using Zone): Ptr[nk_command_rect_multi_color] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).left = left
      (!____ptr).top = top
      (!____ptr).bottom = bottom
      (!____ptr).right = right
      ____ptr
    extension (struct: nk_command_rect_multi_color)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def x: CShort = struct._2
      def x_=(value: CShort): Unit = !struct.at2 = value
      def y: CShort = struct._3
      def y_=(value: CShort): Unit = !struct.at3 = value
      def w: CUnsignedShort = struct._4
      def w_=(value: CUnsignedShort): Unit = !struct.at4 = value
      def h: CUnsignedShort = struct._5
      def h_=(value: CUnsignedShort): Unit = !struct.at5 = value
      def left: nk_color = struct._6
      def left_=(value: nk_color): Unit = !struct.at6 = value
      def top: nk_color = struct._7
      def top_=(value: nk_color): Unit = !struct.at7 = value
      def bottom: nk_color = struct._8
      def bottom_=(value: nk_color): Unit = !struct.at8 = value
      def right: nk_color = struct._9
      def right_=(value: nk_color): Unit = !struct.at9 = value

  opaque type nk_command_scissor = CStruct5[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort]
  object nk_command_scissor:
    given _tag: Tag[nk_command_scissor] = Tag.materializeCStruct5Tag[nk_command, CShort, CShort, CUnsignedShort, CUnsignedShort]
    def apply()(using Zone): Ptr[nk_command_scissor] = scala.scalanative.unsafe.alloc[nk_command_scissor](1)
    def apply(header: nk_command, x: CShort, y: CShort, w: CUnsignedShort, h: CUnsignedShort)(using Zone): Ptr[nk_command_scissor] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).w = w
      (!____ptr).h = h
      ____ptr
    extension (struct: nk_command_scissor)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def x: CShort = struct._2
      def x_=(value: CShort): Unit = !struct.at2 = value
      def y: CShort = struct._3
      def y_=(value: CShort): Unit = !struct.at3 = value
      def w: CUnsignedShort = struct._4
      def w_=(value: CUnsignedShort): Unit = !struct.at4 = value
      def h: CUnsignedShort = struct._5
      def h_=(value: CUnsignedShort): Unit = !struct.at5 = value

  opaque type nk_command_text = CStruct11[nk_command, Ptr[nk_user_font], nk_color, nk_color, CShort, CShort, CUnsignedShort, CUnsignedShort, Float, CInt, CArray[CChar, Nat._1]]
  object nk_command_text:
    given _tag: Tag[nk_command_text] = Tag.materializeCStruct11Tag[nk_command, Ptr[nk_user_font], nk_color, nk_color, CShort, CShort, CUnsignedShort, CUnsignedShort, Float, CInt, CArray[CChar, Nat._1]]
    def apply()(using Zone): Ptr[nk_command_text] = scala.scalanative.unsafe.alloc[nk_command_text](1)
    def apply(header: nk_command, font: Ptr[nk_user_font], background: nk_color, foreground: nk_color, x: CShort, y: CShort, w: CUnsignedShort, h: CUnsignedShort, height: Float, length: CInt, string: CArray[CChar, Nat._1])(using Zone): Ptr[nk_command_text] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).font = font
      (!____ptr).background = background
      (!____ptr).foreground = foreground
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).height = height
      (!____ptr).length = length
      (!____ptr).string = string
      ____ptr
    extension (struct: nk_command_text)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def font: Ptr[nk_user_font] = struct._2
      def font_=(value: Ptr[nk_user_font]): Unit = !struct.at2 = value
      def background: nk_color = struct._3
      def background_=(value: nk_color): Unit = !struct.at3 = value
      def foreground: nk_color = struct._4
      def foreground_=(value: nk_color): Unit = !struct.at4 = value
      def x: CShort = struct._5
      def x_=(value: CShort): Unit = !struct.at5 = value
      def y: CShort = struct._6
      def y_=(value: CShort): Unit = !struct.at6 = value
      def w: CUnsignedShort = struct._7
      def w_=(value: CUnsignedShort): Unit = !struct.at7 = value
      def h: CUnsignedShort = struct._8
      def h_=(value: CUnsignedShort): Unit = !struct.at8 = value
      def height: Float = struct._9
      def height_=(value: Float): Unit = !struct.at9 = value
      def length: CInt = struct._10
      def length_=(value: CInt): Unit = !struct.at10 = value
      def string: CArray[CChar, Nat._1] = struct._11
      def string_=(value: CArray[CChar, Nat._1]): Unit = !struct.at11 = value

  opaque type nk_command_triangle = CStruct6[nk_command, CUnsignedShort, nk_vec2i, nk_vec2i, nk_vec2i, nk_color]
  object nk_command_triangle:
    given _tag: Tag[nk_command_triangle] = Tag.materializeCStruct6Tag[nk_command, CUnsignedShort, nk_vec2i, nk_vec2i, nk_vec2i, nk_color]
    def apply()(using Zone): Ptr[nk_command_triangle] = scala.scalanative.unsafe.alloc[nk_command_triangle](1)
    def apply(header: nk_command, line_thickness: CUnsignedShort, a: nk_vec2i, b: nk_vec2i, c: nk_vec2i, color: nk_color)(using Zone): Ptr[nk_command_triangle] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).line_thickness = line_thickness
      (!____ptr).a = a
      (!____ptr).b = b
      (!____ptr).c = c
      (!____ptr).color = color
      ____ptr
    extension (struct: nk_command_triangle)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def line_thickness: CUnsignedShort = struct._2
      def line_thickness_=(value: CUnsignedShort): Unit = !struct.at2 = value
      def a: nk_vec2i = struct._3
      def a_=(value: nk_vec2i): Unit = !struct.at3 = value
      def b: nk_vec2i = struct._4
      def b_=(value: nk_vec2i): Unit = !struct.at4 = value
      def c: nk_vec2i = struct._5
      def c_=(value: nk_vec2i): Unit = !struct.at5 = value
      def color: nk_color = struct._6
      def color_=(value: nk_color): Unit = !struct.at6 = value

  opaque type nk_command_triangle_filled = CStruct5[nk_command, nk_vec2i, nk_vec2i, nk_vec2i, nk_color]
  object nk_command_triangle_filled:
    given _tag: Tag[nk_command_triangle_filled] = Tag.materializeCStruct5Tag[nk_command, nk_vec2i, nk_vec2i, nk_vec2i, nk_color]
    def apply()(using Zone): Ptr[nk_command_triangle_filled] = scala.scalanative.unsafe.alloc[nk_command_triangle_filled](1)
    def apply(header: nk_command, a: nk_vec2i, b: nk_vec2i, c: nk_vec2i, color: nk_color)(using Zone): Ptr[nk_command_triangle_filled] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).a = a
      (!____ptr).b = b
      (!____ptr).c = c
      (!____ptr).color = color
      ____ptr
    extension (struct: nk_command_triangle_filled)
      def header: nk_command = struct._1
      def header_=(value: nk_command): Unit = !struct.at1 = value
      def a: nk_vec2i = struct._2
      def a_=(value: nk_vec2i): Unit = !struct.at2 = value
      def b: nk_vec2i = struct._3
      def b_=(value: nk_vec2i): Unit = !struct.at3 = value
      def c: nk_vec2i = struct._4
      def c_=(value: nk_vec2i): Unit = !struct.at4 = value
      def color: nk_color = struct._5
      def color_=(value: nk_color): Unit = !struct.at5 = value

  opaque type nk_config_stack_button_behavior = CStruct2[CInt, CArray[nk_config_stack_button_behavior_element, Nat._8]]
  object nk_config_stack_button_behavior:
    given _tag: Tag[nk_config_stack_button_behavior] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_button_behavior_element, Nat._8]]
    def apply()(using Zone): Ptr[nk_config_stack_button_behavior] = scala.scalanative.unsafe.alloc[nk_config_stack_button_behavior](1)
    def apply(head: CInt, elements: CArray[nk_config_stack_button_behavior_element, Nat._8])(using Zone): Ptr[nk_config_stack_button_behavior] = 
      val ____ptr = apply()
      (!____ptr).head = head
      (!____ptr).elements = elements
      ____ptr
    extension (struct: nk_config_stack_button_behavior)
      def head: CInt = struct._1
      def head_=(value: CInt): Unit = !struct.at1 = value
      def elements: CArray[nk_config_stack_button_behavior_element, Nat._8] = struct._2
      def elements_=(value: CArray[nk_config_stack_button_behavior_element, Nat._8]): Unit = !struct.at2 = value

  opaque type nk_config_stack_button_behavior_element = CStruct2[Ptr[nk_button_behavior], nk_button_behavior]
  object nk_config_stack_button_behavior_element:
    given _tag: Tag[nk_config_stack_button_behavior_element] = Tag.materializeCStruct2Tag[Ptr[nk_button_behavior], nk_button_behavior]
    def apply()(using Zone): Ptr[nk_config_stack_button_behavior_element] = scala.scalanative.unsafe.alloc[nk_config_stack_button_behavior_element](1)
    def apply(address: Ptr[nk_button_behavior], old_value: nk_button_behavior)(using Zone): Ptr[nk_config_stack_button_behavior_element] = 
      val ____ptr = apply()
      (!____ptr).address = address
      (!____ptr).old_value = old_value
      ____ptr
    extension (struct: nk_config_stack_button_behavior_element)
      def address: Ptr[nk_button_behavior] = struct._1
      def address_=(value: Ptr[nk_button_behavior]): Unit = !struct.at1 = value
      def old_value: nk_button_behavior = struct._2
      def old_value_=(value: nk_button_behavior): Unit = !struct.at2 = value

  opaque type nk_config_stack_color = CStruct2[CInt, CArray[nk_config_stack_color_element, Nat.Digit2[Nat._3, Nat._2]]]
  object nk_config_stack_color:
    given _tag: Tag[nk_config_stack_color] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_color_element, Nat.Digit2[Nat._3, Nat._2]]]
    def apply()(using Zone): Ptr[nk_config_stack_color] = scala.scalanative.unsafe.alloc[nk_config_stack_color](1)
    def apply(head: CInt, elements: CArray[nk_config_stack_color_element, Nat.Digit2[Nat._3, Nat._2]])(using Zone): Ptr[nk_config_stack_color] = 
      val ____ptr = apply()
      (!____ptr).head = head
      (!____ptr).elements = elements
      ____ptr
    extension (struct: nk_config_stack_color)
      def head: CInt = struct._1
      def head_=(value: CInt): Unit = !struct.at1 = value
      def elements: CArray[nk_config_stack_color_element, Nat.Digit2[Nat._3, Nat._2]] = struct._2
      def elements_=(value: CArray[nk_config_stack_color_element, Nat.Digit2[Nat._3, Nat._2]]): Unit = !struct.at2 = value

  opaque type nk_config_stack_color_element = CStruct2[Ptr[nk_color], nk_color]
  object nk_config_stack_color_element:
    given _tag: Tag[nk_config_stack_color_element] = Tag.materializeCStruct2Tag[Ptr[nk_color], nk_color]
    def apply()(using Zone): Ptr[nk_config_stack_color_element] = scala.scalanative.unsafe.alloc[nk_config_stack_color_element](1)
    def apply(address: Ptr[nk_color], old_value: nk_color)(using Zone): Ptr[nk_config_stack_color_element] = 
      val ____ptr = apply()
      (!____ptr).address = address
      (!____ptr).old_value = old_value
      ____ptr
    extension (struct: nk_config_stack_color_element)
      def address: Ptr[nk_color] = struct._1
      def address_=(value: Ptr[nk_color]): Unit = !struct.at1 = value
      def old_value: nk_color = struct._2
      def old_value_=(value: nk_color): Unit = !struct.at2 = value

  opaque type nk_config_stack_flags = CStruct2[CInt, CArray[nk_config_stack_flags_element, Nat.Digit2[Nat._3, Nat._2]]]
  object nk_config_stack_flags:
    given _tag: Tag[nk_config_stack_flags] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_flags_element, Nat.Digit2[Nat._3, Nat._2]]]
    def apply()(using Zone): Ptr[nk_config_stack_flags] = scala.scalanative.unsafe.alloc[nk_config_stack_flags](1)
    def apply(head: CInt, elements: CArray[nk_config_stack_flags_element, Nat.Digit2[Nat._3, Nat._2]])(using Zone): Ptr[nk_config_stack_flags] = 
      val ____ptr = apply()
      (!____ptr).head = head
      (!____ptr).elements = elements
      ____ptr
    extension (struct: nk_config_stack_flags)
      def head: CInt = struct._1
      def head_=(value: CInt): Unit = !struct.at1 = value
      def elements: CArray[nk_config_stack_flags_element, Nat.Digit2[Nat._3, Nat._2]] = struct._2
      def elements_=(value: CArray[nk_config_stack_flags_element, Nat.Digit2[Nat._3, Nat._2]]): Unit = !struct.at2 = value

  opaque type nk_config_stack_flags_element = CStruct2[Ptr[nk_flags], nk_flags]
  object nk_config_stack_flags_element:
    given _tag: Tag[nk_config_stack_flags_element] = Tag.materializeCStruct2Tag[Ptr[nk_flags], nk_flags]
    def apply()(using Zone): Ptr[nk_config_stack_flags_element] = scala.scalanative.unsafe.alloc[nk_config_stack_flags_element](1)
    def apply(address: Ptr[nk_flags], old_value: nk_flags)(using Zone): Ptr[nk_config_stack_flags_element] = 
      val ____ptr = apply()
      (!____ptr).address = address
      (!____ptr).old_value = old_value
      ____ptr
    extension (struct: nk_config_stack_flags_element)
      def address: Ptr[nk_flags] = struct._1
      def address_=(value: Ptr[nk_flags]): Unit = !struct.at1 = value
      def old_value: nk_flags = struct._2
      def old_value_=(value: nk_flags): Unit = !struct.at2 = value

  opaque type nk_config_stack_float = CStruct2[CInt, CArray[nk_config_stack_float_element, Nat.Digit2[Nat._3, Nat._2]]]
  object nk_config_stack_float:
    given _tag: Tag[nk_config_stack_float] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_float_element, Nat.Digit2[Nat._3, Nat._2]]]
    def apply()(using Zone): Ptr[nk_config_stack_float] = scala.scalanative.unsafe.alloc[nk_config_stack_float](1)
    def apply(head: CInt, elements: CArray[nk_config_stack_float_element, Nat.Digit2[Nat._3, Nat._2]])(using Zone): Ptr[nk_config_stack_float] = 
      val ____ptr = apply()
      (!____ptr).head = head
      (!____ptr).elements = elements
      ____ptr
    extension (struct: nk_config_stack_float)
      def head: CInt = struct._1
      def head_=(value: CInt): Unit = !struct.at1 = value
      def elements: CArray[nk_config_stack_float_element, Nat.Digit2[Nat._3, Nat._2]] = struct._2
      def elements_=(value: CArray[nk_config_stack_float_element, Nat.Digit2[Nat._3, Nat._2]]): Unit = !struct.at2 = value

  opaque type nk_config_stack_float_element = CStruct2[Ptr[Float], Float]
  object nk_config_stack_float_element:
    given _tag: Tag[nk_config_stack_float_element] = Tag.materializeCStruct2Tag[Ptr[Float], Float]
    def apply()(using Zone): Ptr[nk_config_stack_float_element] = scala.scalanative.unsafe.alloc[nk_config_stack_float_element](1)
    def apply(address: Ptr[Float], old_value: Float)(using Zone): Ptr[nk_config_stack_float_element] = 
      val ____ptr = apply()
      (!____ptr).address = address
      (!____ptr).old_value = old_value
      ____ptr
    extension (struct: nk_config_stack_float_element)
      def address: Ptr[Float] = struct._1
      def address_=(value: Ptr[Float]): Unit = !struct.at1 = value
      def old_value: Float = struct._2
      def old_value_=(value: Float): Unit = !struct.at2 = value

  opaque type nk_config_stack_style_item = CStruct2[CInt, CArray[nk_config_stack_style_item_element, Nat.Digit2[Nat._1, Nat._6]]]
  object nk_config_stack_style_item:
    given _tag: Tag[nk_config_stack_style_item] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_style_item_element, Nat.Digit2[Nat._1, Nat._6]]]
    def apply()(using Zone): Ptr[nk_config_stack_style_item] = scala.scalanative.unsafe.alloc[nk_config_stack_style_item](1)
    def apply(head: CInt, elements: CArray[nk_config_stack_style_item_element, Nat.Digit2[Nat._1, Nat._6]])(using Zone): Ptr[nk_config_stack_style_item] = 
      val ____ptr = apply()
      (!____ptr).head = head
      (!____ptr).elements = elements
      ____ptr
    extension (struct: nk_config_stack_style_item)
      def head: CInt = struct._1
      def head_=(value: CInt): Unit = !struct.at1 = value
      def elements: CArray[nk_config_stack_style_item_element, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def elements_=(value: CArray[nk_config_stack_style_item_element, Nat.Digit2[Nat._1, Nat._6]]): Unit = !struct.at2 = value

  opaque type nk_config_stack_style_item_element = CStruct2[Ptr[nk_style_item], nk_style_item]
  object nk_config_stack_style_item_element:
    given _tag: Tag[nk_config_stack_style_item_element] = Tag.materializeCStruct2Tag[Ptr[nk_style_item], nk_style_item]
    def apply()(using Zone): Ptr[nk_config_stack_style_item_element] = scala.scalanative.unsafe.alloc[nk_config_stack_style_item_element](1)
    def apply(address: Ptr[nk_style_item], old_value: nk_style_item)(using Zone): Ptr[nk_config_stack_style_item_element] = 
      val ____ptr = apply()
      (!____ptr).address = address
      (!____ptr).old_value = old_value
      ____ptr
    extension (struct: nk_config_stack_style_item_element)
      def address: Ptr[nk_style_item] = struct._1
      def address_=(value: Ptr[nk_style_item]): Unit = !struct.at1 = value
      def old_value: nk_style_item = struct._2
      def old_value_=(value: nk_style_item): Unit = !struct.at2 = value

  opaque type nk_config_stack_user_font = CStruct2[CInt, CArray[nk_config_stack_user_font_element, Nat._8]]
  object nk_config_stack_user_font:
    given _tag: Tag[nk_config_stack_user_font] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_user_font_element, Nat._8]]
    def apply()(using Zone): Ptr[nk_config_stack_user_font] = scala.scalanative.unsafe.alloc[nk_config_stack_user_font](1)
    def apply(head: CInt, elements: CArray[nk_config_stack_user_font_element, Nat._8])(using Zone): Ptr[nk_config_stack_user_font] = 
      val ____ptr = apply()
      (!____ptr).head = head
      (!____ptr).elements = elements
      ____ptr
    extension (struct: nk_config_stack_user_font)
      def head: CInt = struct._1
      def head_=(value: CInt): Unit = !struct.at1 = value
      def elements: CArray[nk_config_stack_user_font_element, Nat._8] = struct._2
      def elements_=(value: CArray[nk_config_stack_user_font_element, Nat._8]): Unit = !struct.at2 = value

  opaque type nk_config_stack_user_font_element = CStruct2[Ptr[Ptr[nk_user_font]], Ptr[nk_user_font]]
  object nk_config_stack_user_font_element:
    given _tag: Tag[nk_config_stack_user_font_element] = Tag.materializeCStruct2Tag[Ptr[Ptr[nk_user_font]], Ptr[nk_user_font]]
    def apply()(using Zone): Ptr[nk_config_stack_user_font_element] = scala.scalanative.unsafe.alloc[nk_config_stack_user_font_element](1)
    def apply(address: Ptr[Ptr[nk_user_font]], old_value: Ptr[nk_user_font])(using Zone): Ptr[nk_config_stack_user_font_element] = 
      val ____ptr = apply()
      (!____ptr).address = address
      (!____ptr).old_value = old_value
      ____ptr
    extension (struct: nk_config_stack_user_font_element)
      def address: Ptr[Ptr[nk_user_font]] = struct._1
      def address_=(value: Ptr[Ptr[nk_user_font]]): Unit = !struct.at1 = value
      def old_value: Ptr[nk_user_font] = struct._2
      def old_value_=(value: Ptr[nk_user_font]): Unit = !struct.at2 = value

  opaque type nk_config_stack_vec2 = CStruct2[CInt, CArray[nk_config_stack_vec2_element, Nat.Digit2[Nat._1, Nat._6]]]
  object nk_config_stack_vec2:
    given _tag: Tag[nk_config_stack_vec2] = Tag.materializeCStruct2Tag[CInt, CArray[nk_config_stack_vec2_element, Nat.Digit2[Nat._1, Nat._6]]]
    def apply()(using Zone): Ptr[nk_config_stack_vec2] = scala.scalanative.unsafe.alloc[nk_config_stack_vec2](1)
    def apply(head: CInt, elements: CArray[nk_config_stack_vec2_element, Nat.Digit2[Nat._1, Nat._6]])(using Zone): Ptr[nk_config_stack_vec2] = 
      val ____ptr = apply()
      (!____ptr).head = head
      (!____ptr).elements = elements
      ____ptr
    extension (struct: nk_config_stack_vec2)
      def head: CInt = struct._1
      def head_=(value: CInt): Unit = !struct.at1 = value
      def elements: CArray[nk_config_stack_vec2_element, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def elements_=(value: CArray[nk_config_stack_vec2_element, Nat.Digit2[Nat._1, Nat._6]]): Unit = !struct.at2 = value

  opaque type nk_config_stack_vec2_element = CStruct2[Ptr[nk_vec2], nk_vec2]
  object nk_config_stack_vec2_element:
    given _tag: Tag[nk_config_stack_vec2_element] = Tag.materializeCStruct2Tag[Ptr[nk_vec2], nk_vec2]
    def apply()(using Zone): Ptr[nk_config_stack_vec2_element] = scala.scalanative.unsafe.alloc[nk_config_stack_vec2_element](1)
    def apply(address: Ptr[nk_vec2], old_value: nk_vec2)(using Zone): Ptr[nk_config_stack_vec2_element] = 
      val ____ptr = apply()
      (!____ptr).address = address
      (!____ptr).old_value = old_value
      ____ptr
    extension (struct: nk_config_stack_vec2_element)
      def address: Ptr[nk_vec2] = struct._1
      def address_=(value: Ptr[nk_vec2]): Unit = !struct.at1 = value
      def old_value: nk_vec2 = struct._2
      def old_value_=(value: nk_vec2): Unit = !struct.at2 = value

  opaque type nk_configuration_stacks = CStruct7[nk_config_stack_style_item, nk_config_stack_float, nk_config_stack_vec2, nk_config_stack_flags, nk_config_stack_color, nk_config_stack_user_font, nk_config_stack_button_behavior]
  object nk_configuration_stacks:
    given _tag: Tag[nk_configuration_stacks] = Tag.materializeCStruct7Tag[nk_config_stack_style_item, nk_config_stack_float, nk_config_stack_vec2, nk_config_stack_flags, nk_config_stack_color, nk_config_stack_user_font, nk_config_stack_button_behavior]
    def apply()(using Zone): Ptr[nk_configuration_stacks] = scala.scalanative.unsafe.alloc[nk_configuration_stacks](1)
    def apply(style_items: nk_config_stack_style_item, floats: nk_config_stack_float, vectors: nk_config_stack_vec2, flags: nk_config_stack_flags, colors: nk_config_stack_color, fonts: nk_config_stack_user_font, button_behaviors: nk_config_stack_button_behavior)(using Zone): Ptr[nk_configuration_stacks] = 
      val ____ptr = apply()
      (!____ptr).style_items = style_items
      (!____ptr).floats = floats
      (!____ptr).vectors = vectors
      (!____ptr).flags = flags
      (!____ptr).colors = colors
      (!____ptr).fonts = fonts
      (!____ptr).button_behaviors = button_behaviors
      ____ptr
    extension (struct: nk_configuration_stacks)
      def style_items: nk_config_stack_style_item = struct._1
      def style_items_=(value: nk_config_stack_style_item): Unit = !struct.at1 = value
      def floats: nk_config_stack_float = struct._2
      def floats_=(value: nk_config_stack_float): Unit = !struct.at2 = value
      def vectors: nk_config_stack_vec2 = struct._3
      def vectors_=(value: nk_config_stack_vec2): Unit = !struct.at3 = value
      def flags: nk_config_stack_flags = struct._4
      def flags_=(value: nk_config_stack_flags): Unit = !struct.at4 = value
      def colors: nk_config_stack_color = struct._5
      def colors_=(value: nk_config_stack_color): Unit = !struct.at5 = value
      def fonts: nk_config_stack_user_font = struct._6
      def fonts_=(value: nk_config_stack_user_font): Unit = !struct.at6 = value
      def button_behaviors: nk_config_stack_button_behavior = struct._7
      def button_behaviors_=(value: nk_config_stack_button_behavior): Unit = !struct.at7 = value

  opaque type nk_context = CStruct20[nk_input, nk_style, nk_buffer, nk_clipboard, nk_flags, nk_button_behavior, nk_configuration_stacks, Float, nk_text_edit, nk_command_buffer, CInt, CInt, nk_pool, Ptr[Byte], Ptr[Byte], Ptr[Byte], Ptr[Byte], Ptr[Byte], CUnsignedInt, CUnsignedInt]
  object nk_context:
    given _tag: Tag[nk_context] = Tag.materializeCStruct20Tag[nk_input, nk_style, nk_buffer, nk_clipboard, nk_flags, nk_button_behavior, nk_configuration_stacks, Float, nk_text_edit, nk_command_buffer, CInt, CInt, nk_pool, Ptr[Byte], Ptr[Byte], Ptr[Byte], Ptr[Byte], Ptr[Byte], CUnsignedInt, CUnsignedInt]
    def apply()(using Zone): Ptr[nk_context] = scala.scalanative.unsafe.alloc[nk_context](1)
    def apply(input: nk_input, style: nk_style, memory: nk_buffer, clip: nk_clipboard, last_widget_state: nk_flags, button_behavior: nk_button_behavior, stacks: nk_configuration_stacks, delta_time_seconds: Float, text_edit: nk_text_edit, overlay: nk_command_buffer, build: CInt, use_pool: CInt, pool: nk_pool, begin: Ptr[nk_window], end: Ptr[nk_window], active: Ptr[nk_window], current: Ptr[nk_window], freelist: Ptr[nk_page_element], count: CUnsignedInt, seq: CUnsignedInt)(using Zone): Ptr[nk_context] = 
      val ____ptr = apply()
      (!____ptr).input = input
      (!____ptr).style = style
      (!____ptr).memory = memory
      (!____ptr).clip = clip
      (!____ptr).last_widget_state = last_widget_state
      (!____ptr).button_behavior = button_behavior
      (!____ptr).stacks = stacks
      (!____ptr).delta_time_seconds = delta_time_seconds
      (!____ptr).text_edit = text_edit
      (!____ptr).overlay = overlay
      (!____ptr).build = build
      (!____ptr).use_pool = use_pool
      (!____ptr).pool = pool
      (!____ptr).begin = begin
      (!____ptr).end = end
      (!____ptr).active = active
      (!____ptr).current = current
      (!____ptr).freelist = freelist
      (!____ptr).count = count
      (!____ptr).seq = seq
      ____ptr
    extension (struct: nk_context)
      def input: nk_input = struct._1
      def input_=(value: nk_input): Unit = !struct.at1 = value
      def style: nk_style = struct._2
      def style_=(value: nk_style): Unit = !struct.at2 = value
      def memory: nk_buffer = struct._3
      def memory_=(value: nk_buffer): Unit = !struct.at3 = value
      def clip: nk_clipboard = struct._4
      def clip_=(value: nk_clipboard): Unit = !struct.at4 = value
      def last_widget_state: nk_flags = struct._5
      def last_widget_state_=(value: nk_flags): Unit = !struct.at5 = value
      def button_behavior: nk_button_behavior = struct._6
      def button_behavior_=(value: nk_button_behavior): Unit = !struct.at6 = value
      def stacks: nk_configuration_stacks = struct._7
      def stacks_=(value: nk_configuration_stacks): Unit = !struct.at7 = value
      def delta_time_seconds: Float = struct._8
      def delta_time_seconds_=(value: Float): Unit = !struct.at8 = value
      def text_edit: nk_text_edit = struct._9
      def text_edit_=(value: nk_text_edit): Unit = !struct.at9 = value
      def overlay: nk_command_buffer = struct._10
      def overlay_=(value: nk_command_buffer): Unit = !struct.at10 = value
      def build: CInt = struct._11
      def build_=(value: CInt): Unit = !struct.at11 = value
      def use_pool: CInt = struct._12
      def use_pool_=(value: CInt): Unit = !struct.at12 = value
      def pool: nk_pool = struct._13
      def pool_=(value: nk_pool): Unit = !struct.at13 = value
      def begin: Ptr[nk_window] = struct._14.asInstanceOf[Ptr[nk_window]]
      def begin_=(value: Ptr[nk_window]): Unit = !struct.at14 = value.asInstanceOf[Ptr[Byte]]
      def end: Ptr[nk_window] = struct._15.asInstanceOf[Ptr[nk_window]]
      def end_=(value: Ptr[nk_window]): Unit = !struct.at15 = value.asInstanceOf[Ptr[Byte]]
      def active: Ptr[nk_window] = struct._16.asInstanceOf[Ptr[nk_window]]
      def active_=(value: Ptr[nk_window]): Unit = !struct.at16 = value.asInstanceOf[Ptr[Byte]]
      def current: Ptr[nk_window] = struct._17.asInstanceOf[Ptr[nk_window]]
      def current_=(value: Ptr[nk_window]): Unit = !struct.at17 = value.asInstanceOf[Ptr[Byte]]
      def freelist: Ptr[nk_page_element] = struct._18.asInstanceOf[Ptr[nk_page_element]]
      def freelist_=(value: Ptr[nk_page_element]): Unit = !struct.at18 = value.asInstanceOf[Ptr[Byte]]
      def count: CUnsignedInt = struct._19
      def count_=(value: CUnsignedInt): Unit = !struct.at19 = value
      def seq: CUnsignedInt = struct._20
      def seq_=(value: CUnsignedInt): Unit = !struct.at20 = value

  opaque type nk_convert_config = CStruct10[Float, nk_anti_aliasing, nk_anti_aliasing, CUnsignedInt, CUnsignedInt, CUnsignedInt, nk_draw_null_texture, Ptr[nk_draw_vertex_layout_element], nk_size, nk_size]
  object nk_convert_config:
    given _tag: Tag[nk_convert_config] = Tag.materializeCStruct10Tag[Float, nk_anti_aliasing, nk_anti_aliasing, CUnsignedInt, CUnsignedInt, CUnsignedInt, nk_draw_null_texture, Ptr[nk_draw_vertex_layout_element], nk_size, nk_size]
    def apply()(using Zone): Ptr[nk_convert_config] = scala.scalanative.unsafe.alloc[nk_convert_config](1)
    def apply(global_alpha: Float, line_AA: nk_anti_aliasing, shape_AA: nk_anti_aliasing, circle_segment_count: CUnsignedInt, arc_segment_count: CUnsignedInt, curve_segment_count: CUnsignedInt, `null`: nk_draw_null_texture, vertex_layout: Ptr[nk_draw_vertex_layout_element], vertex_size: nk_size, vertex_alignment: nk_size)(using Zone): Ptr[nk_convert_config] = 
      val ____ptr = apply()
      (!____ptr).global_alpha = global_alpha
      (!____ptr).line_AA = line_AA
      (!____ptr).shape_AA = shape_AA
      (!____ptr).circle_segment_count = circle_segment_count
      (!____ptr).arc_segment_count = arc_segment_count
      (!____ptr).curve_segment_count = curve_segment_count
      (!____ptr).`null` = `null`
      (!____ptr).vertex_layout = vertex_layout
      (!____ptr).vertex_size = vertex_size
      (!____ptr).vertex_alignment = vertex_alignment
      ____ptr
    extension (struct: nk_convert_config)
      def global_alpha: Float = struct._1
      def global_alpha_=(value: Float): Unit = !struct.at1 = value
      def line_AA: nk_anti_aliasing = struct._2
      def line_AA_=(value: nk_anti_aliasing): Unit = !struct.at2 = value
      def shape_AA: nk_anti_aliasing = struct._3
      def shape_AA_=(value: nk_anti_aliasing): Unit = !struct.at3 = value
      def circle_segment_count: CUnsignedInt = struct._4
      def circle_segment_count_=(value: CUnsignedInt): Unit = !struct.at4 = value
      def arc_segment_count: CUnsignedInt = struct._5
      def arc_segment_count_=(value: CUnsignedInt): Unit = !struct.at5 = value
      def curve_segment_count: CUnsignedInt = struct._6
      def curve_segment_count_=(value: CUnsignedInt): Unit = !struct.at6 = value
      def `null`: nk_draw_null_texture = struct._7
      def null_=(value: nk_draw_null_texture): Unit = !struct.at7 = value
      def vertex_layout: Ptr[nk_draw_vertex_layout_element] = struct._8
      def vertex_layout_=(value: Ptr[nk_draw_vertex_layout_element]): Unit = !struct.at8 = value
      def vertex_size: nk_size = struct._9
      def vertex_size_=(value: nk_size): Unit = !struct.at9 = value
      def vertex_alignment: nk_size = struct._10
      def vertex_alignment_=(value: nk_size): Unit = !struct.at10 = value

  opaque type nk_cursor = CStruct3[nk_image, nk_vec2, nk_vec2]
  object nk_cursor:
    given _tag: Tag[nk_cursor] = Tag.materializeCStruct3Tag[nk_image, nk_vec2, nk_vec2]
    def apply()(using Zone): Ptr[nk_cursor] = scala.scalanative.unsafe.alloc[nk_cursor](1)
    def apply(img: nk_image, size: nk_vec2, offset: nk_vec2)(using Zone): Ptr[nk_cursor] = 
      val ____ptr = apply()
      (!____ptr).img = img
      (!____ptr).size = size
      (!____ptr).offset = offset
      ____ptr
    extension (struct: nk_cursor)
      def img: nk_image = struct._1
      def img_=(value: nk_image): Unit = !struct.at1 = value
      def size: nk_vec2 = struct._2
      def size_=(value: nk_vec2): Unit = !struct.at2 = value
      def offset: nk_vec2 = struct._3
      def offset_=(value: nk_vec2): Unit = !struct.at3 = value

  opaque type nk_draw_command = CStruct0
  object nk_draw_command:
    given _tag: Tag[nk_draw_command] = Tag.materializeCStruct0Tag

  opaque type nk_draw_list = CStruct0
  object nk_draw_list:
    given _tag: Tag[nk_draw_list] = Tag.materializeCStruct0Tag

  opaque type nk_draw_null_texture = CStruct2[nk_handle, nk_vec2]
  object nk_draw_null_texture:
    given _tag: Tag[nk_draw_null_texture] = Tag.materializeCStruct2Tag[nk_handle, nk_vec2]
    def apply()(using Zone): Ptr[nk_draw_null_texture] = scala.scalanative.unsafe.alloc[nk_draw_null_texture](1)
    def apply(texture: nk_handle, uv: nk_vec2)(using Zone): Ptr[nk_draw_null_texture] = 
      val ____ptr = apply()
      (!____ptr).texture = texture
      (!____ptr).uv = uv
      ____ptr
    extension (struct: nk_draw_null_texture)
      def texture: nk_handle = struct._1
      def texture_=(value: nk_handle): Unit = !struct.at1 = value
      def uv: nk_vec2 = struct._2
      def uv_=(value: nk_vec2): Unit = !struct.at2 = value

  opaque type nk_draw_vertex_layout_element = CStruct0
  object nk_draw_vertex_layout_element:
    given _tag: Tag[nk_draw_vertex_layout_element] = Tag.materializeCStruct0Tag

  opaque type nk_edit_state = CStruct11[nk_hash, CUnsignedInt, CUnsignedInt, CInt, CInt, CInt, CInt, CInt, nk_scroll, CUnsignedChar, CUnsignedChar]
  object nk_edit_state:
    given _tag: Tag[nk_edit_state] = Tag.materializeCStruct11Tag[nk_hash, CUnsignedInt, CUnsignedInt, CInt, CInt, CInt, CInt, CInt, nk_scroll, CUnsignedChar, CUnsignedChar]
    def apply()(using Zone): Ptr[nk_edit_state] = scala.scalanative.unsafe.alloc[nk_edit_state](1)
    def apply(name: nk_hash, seq: CUnsignedInt, old: CUnsignedInt, active: CInt, prev: CInt, cursor: CInt, sel_start: CInt, sel_end: CInt, scrollbar: nk_scroll, mode: CUnsignedChar, single_line: CUnsignedChar)(using Zone): Ptr[nk_edit_state] = 
      val ____ptr = apply()
      (!____ptr).name = name
      (!____ptr).seq = seq
      (!____ptr).old = old
      (!____ptr).active = active
      (!____ptr).prev = prev
      (!____ptr).cursor = cursor
      (!____ptr).sel_start = sel_start
      (!____ptr).sel_end = sel_end
      (!____ptr).scrollbar = scrollbar
      (!____ptr).mode = mode
      (!____ptr).single_line = single_line
      ____ptr
    extension (struct: nk_edit_state)
      def name: nk_hash = struct._1
      def name_=(value: nk_hash): Unit = !struct.at1 = value
      def seq: CUnsignedInt = struct._2
      def seq_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def old: CUnsignedInt = struct._3
      def old_=(value: CUnsignedInt): Unit = !struct.at3 = value
      def active: CInt = struct._4
      def active_=(value: CInt): Unit = !struct.at4 = value
      def prev: CInt = struct._5
      def prev_=(value: CInt): Unit = !struct.at5 = value
      def cursor: CInt = struct._6
      def cursor_=(value: CInt): Unit = !struct.at6 = value
      def sel_start: CInt = struct._7
      def sel_start_=(value: CInt): Unit = !struct.at7 = value
      def sel_end: CInt = struct._8
      def sel_end_=(value: CInt): Unit = !struct.at8 = value
      def scrollbar: nk_scroll = struct._9
      def scrollbar_=(value: nk_scroll): Unit = !struct.at9 = value
      def mode: CUnsignedChar = struct._10
      def mode_=(value: CUnsignedChar): Unit = !struct.at10 = value
      def single_line: CUnsignedChar = struct._11
      def single_line_=(value: CUnsignedChar): Unit = !struct.at11 = value

  opaque type nk_image = CStruct4[nk_handle, nk_ushort, nk_ushort, CArray[nk_ushort, Nat._4]]
  object nk_image:
    given _tag: Tag[nk_image] = Tag.materializeCStruct4Tag[nk_handle, nk_ushort, nk_ushort, CArray[nk_ushort, Nat._4]]
    def apply()(using Zone): Ptr[nk_image] = scala.scalanative.unsafe.alloc[nk_image](1)
    def apply(handle: nk_handle, w: nk_ushort, h: nk_ushort, region: CArray[nk_ushort, Nat._4])(using Zone): Ptr[nk_image] = 
      val ____ptr = apply()
      (!____ptr).handle = handle
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).region = region
      ____ptr
    extension (struct: nk_image)
      def handle: nk_handle = struct._1
      def handle_=(value: nk_handle): Unit = !struct.at1 = value
      def w: nk_ushort = struct._2
      def w_=(value: nk_ushort): Unit = !struct.at2 = value
      def h: nk_ushort = struct._3
      def h_=(value: nk_ushort): Unit = !struct.at3 = value
      def region: CArray[nk_ushort, Nat._4] = struct._4
      def region_=(value: CArray[nk_ushort, Nat._4]): Unit = !struct.at4 = value

  opaque type nk_input = CStruct2[nk_keyboard, nk_mouse]
  object nk_input:
    given _tag: Tag[nk_input] = Tag.materializeCStruct2Tag[nk_keyboard, nk_mouse]
    def apply()(using Zone): Ptr[nk_input] = scala.scalanative.unsafe.alloc[nk_input](1)
    def apply(keyboard: nk_keyboard, mouse: nk_mouse)(using Zone): Ptr[nk_input] = 
      val ____ptr = apply()
      (!____ptr).keyboard = keyboard
      (!____ptr).mouse = mouse
      ____ptr
    extension (struct: nk_input)
      def keyboard: nk_keyboard = struct._1
      def keyboard_=(value: nk_keyboard): Unit = !struct.at1 = value
      def mouse: nk_mouse = struct._2
      def mouse_=(value: nk_mouse): Unit = !struct.at2 = value

  opaque type nk_key = CStruct2[nk_bool, CUnsignedInt]
  object nk_key:
    given _tag: Tag[nk_key] = Tag.materializeCStruct2Tag[nk_bool, CUnsignedInt]
    def apply()(using Zone): Ptr[nk_key] = scala.scalanative.unsafe.alloc[nk_key](1)
    def apply(down: nk_bool, clicked: CUnsignedInt)(using Zone): Ptr[nk_key] = 
      val ____ptr = apply()
      (!____ptr).down = down
      (!____ptr).clicked = clicked
      ____ptr
    extension (struct: nk_key)
      def down: nk_bool = struct._1
      def down_=(value: nk_bool): Unit = !struct.at1 = value
      def clicked: CUnsignedInt = struct._2
      def clicked_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type nk_keyboard = CStruct3[CArray[nk_key, Nat.Digit2[Nat._3, Nat._0]], CArray[CChar, Nat.Digit2[Nat._1, Nat._6]], CInt]
  object nk_keyboard:
    given _tag: Tag[nk_keyboard] = Tag.materializeCStruct3Tag[CArray[nk_key, Nat.Digit2[Nat._3, Nat._0]], CArray[CChar, Nat.Digit2[Nat._1, Nat._6]], CInt]
    def apply()(using Zone): Ptr[nk_keyboard] = scala.scalanative.unsafe.alloc[nk_keyboard](1)
    def apply(keys: CArray[nk_key, Nat.Digit2[Nat._3, Nat._0]], text: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]], text_len: CInt)(using Zone): Ptr[nk_keyboard] = 
      val ____ptr = apply()
      (!____ptr).keys = keys
      (!____ptr).text = text
      (!____ptr).text_len = text_len
      ____ptr
    extension (struct: nk_keyboard)
      def keys: CArray[nk_key, Nat.Digit2[Nat._3, Nat._0]] = struct._1
      def keys_=(value: CArray[nk_key, Nat.Digit2[Nat._3, Nat._0]]): Unit = !struct.at1 = value
      def text: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def text_=(value: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]): Unit = !struct.at2 = value
      def text_len: CInt = struct._3
      def text_len_=(value: CInt): Unit = !struct.at3 = value

  opaque type nk_list_view = CStruct7[CInt, CInt, CInt, CInt, Ptr[Byte], Ptr[nk_uint], nk_uint]
  object nk_list_view:
    given _tag: Tag[nk_list_view] = Tag.materializeCStruct7Tag[CInt, CInt, CInt, CInt, Ptr[Byte], Ptr[nk_uint], nk_uint]
    def apply()(using Zone): Ptr[nk_list_view] = scala.scalanative.unsafe.alloc[nk_list_view](1)
    def apply(begin: CInt, end: CInt, count: CInt, total_height: CInt, ctx: Ptr[nk_context], scroll_pointer: Ptr[nk_uint], scroll_value: nk_uint)(using Zone): Ptr[nk_list_view] = 
      val ____ptr = apply()
      (!____ptr).begin = begin
      (!____ptr).end = end
      (!____ptr).count = count
      (!____ptr).total_height = total_height
      (!____ptr).ctx = ctx
      (!____ptr).scroll_pointer = scroll_pointer
      (!____ptr).scroll_value = scroll_value
      ____ptr
    extension (struct: nk_list_view)
      def begin: CInt = struct._1
      def begin_=(value: CInt): Unit = !struct.at1 = value
      def end: CInt = struct._2
      def end_=(value: CInt): Unit = !struct.at2 = value
      def count: CInt = struct._3
      def count_=(value: CInt): Unit = !struct.at3 = value
      def total_height: CInt = struct._4
      def total_height_=(value: CInt): Unit = !struct.at4 = value
      def ctx: Ptr[nk_context] = struct._5.asInstanceOf[Ptr[nk_context]]
      def ctx_=(value: Ptr[nk_context]): Unit = !struct.at5 = value.asInstanceOf[Ptr[Byte]]
      def scroll_pointer: Ptr[nk_uint] = struct._6
      def scroll_pointer_=(value: Ptr[nk_uint]): Unit = !struct.at6 = value
      def scroll_value: nk_uint = struct._7
      def scroll_value_=(value: nk_uint): Unit = !struct.at7 = value

  opaque type nk_memory = CStruct2[Ptr[Byte], nk_size]
  object nk_memory:
    given _tag: Tag[nk_memory] = Tag.materializeCStruct2Tag[Ptr[Byte], nk_size]
    def apply()(using Zone): Ptr[nk_memory] = scala.scalanative.unsafe.alloc[nk_memory](1)
    def apply(ptr: Ptr[Byte], size: nk_size)(using Zone): Ptr[nk_memory] = 
      val ____ptr = apply()
      (!____ptr).ptr = ptr
      (!____ptr).size = size
      ____ptr
    extension (struct: nk_memory)
      def ptr: Ptr[Byte] = struct._1
      def ptr_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def size: nk_size = struct._2
      def size_=(value: nk_size): Unit = !struct.at2 = value

  opaque type nk_memory_status = CStruct6[Ptr[Byte], CUnsignedInt, nk_size, nk_size, nk_size, nk_size]
  object nk_memory_status:
    given _tag: Tag[nk_memory_status] = Tag.materializeCStruct6Tag[Ptr[Byte], CUnsignedInt, nk_size, nk_size, nk_size, nk_size]
    def apply()(using Zone): Ptr[nk_memory_status] = scala.scalanative.unsafe.alloc[nk_memory_status](1)
    def apply(memory: Ptr[Byte], `type`: CUnsignedInt, size: nk_size, allocated: nk_size, needed: nk_size, calls: nk_size)(using Zone): Ptr[nk_memory_status] = 
      val ____ptr = apply()
      (!____ptr).memory = memory
      (!____ptr).`type` = `type`
      (!____ptr).size = size
      (!____ptr).allocated = allocated
      (!____ptr).needed = needed
      (!____ptr).calls = calls
      ____ptr
    extension (struct: nk_memory_status)
      def memory: Ptr[Byte] = struct._1
      def memory_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def `type`: CUnsignedInt = struct._2
      def type_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def size: nk_size = struct._3
      def size_=(value: nk_size): Unit = !struct.at3 = value
      def allocated: nk_size = struct._4
      def allocated_=(value: nk_size): Unit = !struct.at4 = value
      def needed: nk_size = struct._5
      def needed_=(value: nk_size): Unit = !struct.at5 = value
      def calls: nk_size = struct._6
      def calls_=(value: nk_size): Unit = !struct.at6 = value

  opaque type nk_menu_state = CStruct5[Float, Float, Float, Float, nk_scroll]
  object nk_menu_state:
    given _tag: Tag[nk_menu_state] = Tag.materializeCStruct5Tag[Float, Float, Float, Float, nk_scroll]
    def apply()(using Zone): Ptr[nk_menu_state] = scala.scalanative.unsafe.alloc[nk_menu_state](1)
    def apply(x: Float, y: Float, w: Float, h: Float, offset: nk_scroll)(using Zone): Ptr[nk_menu_state] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).offset = offset
      ____ptr
    extension (struct: nk_menu_state)
      def x: Float = struct._1
      def x_=(value: Float): Unit = !struct.at1 = value
      def y: Float = struct._2
      def y_=(value: Float): Unit = !struct.at2 = value
      def w: Float = struct._3
      def w_=(value: Float): Unit = !struct.at3 = value
      def h: Float = struct._4
      def h_=(value: Float): Unit = !struct.at4 = value
      def offset: nk_scroll = struct._5
      def offset_=(value: nk_scroll): Unit = !struct.at5 = value

  opaque type nk_mouse = CStruct8[CArray[nk_mouse_button, Nat._4], nk_vec2, nk_vec2, nk_vec2, nk_vec2, CUnsignedChar, CUnsignedChar, CUnsignedChar]
  object nk_mouse:
    given _tag: Tag[nk_mouse] = Tag.materializeCStruct8Tag[CArray[nk_mouse_button, Nat._4], nk_vec2, nk_vec2, nk_vec2, nk_vec2, CUnsignedChar, CUnsignedChar, CUnsignedChar]
    def apply()(using Zone): Ptr[nk_mouse] = scala.scalanative.unsafe.alloc[nk_mouse](1)
    def apply(buttons: CArray[nk_mouse_button, Nat._4], pos: nk_vec2, prev: nk_vec2, delta: nk_vec2, scroll_delta: nk_vec2, grab: CUnsignedChar, grabbed: CUnsignedChar, ungrab: CUnsignedChar)(using Zone): Ptr[nk_mouse] = 
      val ____ptr = apply()
      (!____ptr).buttons = buttons
      (!____ptr).pos = pos
      (!____ptr).prev = prev
      (!____ptr).delta = delta
      (!____ptr).scroll_delta = scroll_delta
      (!____ptr).grab = grab
      (!____ptr).grabbed = grabbed
      (!____ptr).ungrab = ungrab
      ____ptr
    extension (struct: nk_mouse)
      def buttons: CArray[nk_mouse_button, Nat._4] = struct._1
      def buttons_=(value: CArray[nk_mouse_button, Nat._4]): Unit = !struct.at1 = value
      def pos: nk_vec2 = struct._2
      def pos_=(value: nk_vec2): Unit = !struct.at2 = value
      def prev: nk_vec2 = struct._3
      def prev_=(value: nk_vec2): Unit = !struct.at3 = value
      def delta: nk_vec2 = struct._4
      def delta_=(value: nk_vec2): Unit = !struct.at4 = value
      def scroll_delta: nk_vec2 = struct._5
      def scroll_delta_=(value: nk_vec2): Unit = !struct.at5 = value
      def grab: CUnsignedChar = struct._6
      def grab_=(value: CUnsignedChar): Unit = !struct.at6 = value
      def grabbed: CUnsignedChar = struct._7
      def grabbed_=(value: CUnsignedChar): Unit = !struct.at7 = value
      def ungrab: CUnsignedChar = struct._8
      def ungrab_=(value: CUnsignedChar): Unit = !struct.at8 = value

  opaque type nk_mouse_button = CStruct3[nk_bool, CUnsignedInt, nk_vec2]
  object nk_mouse_button:
    given _tag: Tag[nk_mouse_button] = Tag.materializeCStruct3Tag[nk_bool, CUnsignedInt, nk_vec2]
    def apply()(using Zone): Ptr[nk_mouse_button] = scala.scalanative.unsafe.alloc[nk_mouse_button](1)
    def apply(down: nk_bool, clicked: CUnsignedInt, clicked_pos: nk_vec2)(using Zone): Ptr[nk_mouse_button] = 
      val ____ptr = apply()
      (!____ptr).down = down
      (!____ptr).clicked = clicked
      (!____ptr).clicked_pos = clicked_pos
      ____ptr
    extension (struct: nk_mouse_button)
      def down: nk_bool = struct._1
      def down_=(value: nk_bool): Unit = !struct.at1 = value
      def clicked: CUnsignedInt = struct._2
      def clicked_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def clicked_pos: nk_vec2 = struct._3
      def clicked_pos_=(value: nk_vec2): Unit = !struct.at3 = value

  opaque type nk_nine_slice = CStruct5[nk_image, nk_ushort, nk_ushort, nk_ushort, nk_ushort]
  object nk_nine_slice:
    given _tag: Tag[nk_nine_slice] = Tag.materializeCStruct5Tag[nk_image, nk_ushort, nk_ushort, nk_ushort, nk_ushort]
    def apply()(using Zone): Ptr[nk_nine_slice] = scala.scalanative.unsafe.alloc[nk_nine_slice](1)
    def apply(img: nk_image, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort)(using Zone): Ptr[nk_nine_slice] = 
      val ____ptr = apply()
      (!____ptr).img = img
      (!____ptr).l = l
      (!____ptr).t = t
      (!____ptr).r = r
      (!____ptr).b = b
      ____ptr
    extension (struct: nk_nine_slice)
      def img: nk_image = struct._1
      def img_=(value: nk_image): Unit = !struct.at1 = value
      def l: nk_ushort = struct._2
      def l_=(value: nk_ushort): Unit = !struct.at2 = value
      def t: nk_ushort = struct._3
      def t_=(value: nk_ushort): Unit = !struct.at3 = value
      def r: nk_ushort = struct._4
      def r_=(value: nk_ushort): Unit = !struct.at4 = value
      def b: nk_ushort = struct._5
      def b_=(value: nk_ushort): Unit = !struct.at5 = value

  opaque type nk_page = CStruct3[CUnsignedInt, Ptr[Byte], CArray[nk_page_element, Nat._1]]
  object nk_page:
    given _tag: Tag[nk_page] = Tag.materializeCStruct3Tag[CUnsignedInt, Ptr[Byte], CArray[nk_page_element, Nat._1]]
    def apply()(using Zone): Ptr[nk_page] = scala.scalanative.unsafe.alloc[nk_page](1)
    def apply(size: CUnsignedInt, next: Ptr[nk_page], win: CArray[nk_page_element, Nat._1])(using Zone): Ptr[nk_page] = 
      val ____ptr = apply()
      (!____ptr).size = size
      (!____ptr).next = next
      (!____ptr).win = win
      ____ptr
    extension (struct: nk_page)
      def size: CUnsignedInt = struct._1
      def size_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def next: Ptr[nk_page] = struct._2.asInstanceOf[Ptr[nk_page]]
      def next_=(value: Ptr[nk_page]): Unit = !struct.at2 = value.asInstanceOf[Ptr[Byte]]
      def win: CArray[nk_page_element, Nat._1] = struct._3
      def win_=(value: CArray[nk_page_element, Nat._1]): Unit = !struct.at3 = value

  opaque type nk_page_element = CStruct3[nk_page_data, Ptr[Byte], Ptr[Byte]]
  object nk_page_element:
    given _tag: Tag[nk_page_element] = Tag.materializeCStruct3Tag[nk_page_data, Ptr[Byte], Ptr[Byte]]
    def apply()(using Zone): Ptr[nk_page_element] = scala.scalanative.unsafe.alloc[nk_page_element](1)
    def apply(data: nk_page_data, next: Ptr[nk_page_element], prev: Ptr[nk_page_element])(using Zone): Ptr[nk_page_element] = 
      val ____ptr = apply()
      (!____ptr).data = data
      (!____ptr).next = next
      (!____ptr).prev = prev
      ____ptr
    extension (struct: nk_page_element)
      def data: nk_page_data = struct._1
      def data_=(value: nk_page_data): Unit = !struct.at1 = value
      def next: Ptr[nk_page_element] = struct._2.asInstanceOf[Ptr[nk_page_element]]
      def next_=(value: Ptr[nk_page_element]): Unit = !struct.at2 = value.asInstanceOf[Ptr[Byte]]
      def prev: Ptr[nk_page_element] = struct._3.asInstanceOf[Ptr[nk_page_element]]
      def prev_=(value: Ptr[nk_page_element]): Unit = !struct.at3 = value.asInstanceOf[Ptr[Byte]]

  opaque type nk_panel = CStruct18[nk_panel_type, nk_flags, nk_rect, Ptr[nk_uint], Ptr[nk_uint], Float, Float, Float, Float, Float, Float, CUnsignedInt, nk_rect, nk_menu_state, nk_row_layout, nk_chart, Ptr[nk_command_buffer], Ptr[Byte]]
  object nk_panel:
    given _tag: Tag[nk_panel] = Tag.materializeCStruct18Tag[nk_panel_type, nk_flags, nk_rect, Ptr[nk_uint], Ptr[nk_uint], Float, Float, Float, Float, Float, Float, CUnsignedInt, nk_rect, nk_menu_state, nk_row_layout, nk_chart, Ptr[nk_command_buffer], Ptr[Byte]]
    def apply()(using Zone): Ptr[nk_panel] = scala.scalanative.unsafe.alloc[nk_panel](1)
    def apply(`type`: nk_panel_type, flags: nk_flags, bounds: nk_rect, offset_x: Ptr[nk_uint], offset_y: Ptr[nk_uint], at_x: Float, at_y: Float, max_x: Float, footer_height: Float, header_height: Float, border: Float, has_scrolling: CUnsignedInt, clip: nk_rect, menu: nk_menu_state, row: nk_row_layout, chart: nk_chart, buffer: Ptr[nk_command_buffer], parent: Ptr[nk_panel])(using Zone): Ptr[nk_panel] = 
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).flags = flags
      (!____ptr).bounds = bounds
      (!____ptr).offset_x = offset_x
      (!____ptr).offset_y = offset_y
      (!____ptr).at_x = at_x
      (!____ptr).at_y = at_y
      (!____ptr).max_x = max_x
      (!____ptr).footer_height = footer_height
      (!____ptr).header_height = header_height
      (!____ptr).border = border
      (!____ptr).has_scrolling = has_scrolling
      (!____ptr).clip = clip
      (!____ptr).menu = menu
      (!____ptr).row = row
      (!____ptr).chart = chart
      (!____ptr).buffer = buffer
      (!____ptr).parent = parent
      ____ptr
    extension (struct: nk_panel)
      def `type`: nk_panel_type = struct._1
      def type_=(value: nk_panel_type): Unit = !struct.at1 = value
      def flags: nk_flags = struct._2
      def flags_=(value: nk_flags): Unit = !struct.at2 = value
      def bounds: nk_rect = struct._3
      def bounds_=(value: nk_rect): Unit = !struct.at3 = value
      def offset_x: Ptr[nk_uint] = struct._4
      def offset_x_=(value: Ptr[nk_uint]): Unit = !struct.at4 = value
      def offset_y: Ptr[nk_uint] = struct._5
      def offset_y_=(value: Ptr[nk_uint]): Unit = !struct.at5 = value
      def at_x: Float = struct._6
      def at_x_=(value: Float): Unit = !struct.at6 = value
      def at_y: Float = struct._7
      def at_y_=(value: Float): Unit = !struct.at7 = value
      def max_x: Float = struct._8
      def max_x_=(value: Float): Unit = !struct.at8 = value
      def footer_height: Float = struct._9
      def footer_height_=(value: Float): Unit = !struct.at9 = value
      def header_height: Float = struct._10
      def header_height_=(value: Float): Unit = !struct.at10 = value
      def border: Float = struct._11
      def border_=(value: Float): Unit = !struct.at11 = value
      def has_scrolling: CUnsignedInt = struct._12
      def has_scrolling_=(value: CUnsignedInt): Unit = !struct.at12 = value
      def clip: nk_rect = struct._13
      def clip_=(value: nk_rect): Unit = !struct.at13 = value
      def menu: nk_menu_state = struct._14
      def menu_=(value: nk_menu_state): Unit = !struct.at14 = value
      def row: nk_row_layout = struct._15
      def row_=(value: nk_row_layout): Unit = !struct.at15 = value
      def chart: nk_chart = struct._16
      def chart_=(value: nk_chart): Unit = !struct.at16 = value
      def buffer: Ptr[nk_command_buffer] = struct._17
      def buffer_=(value: Ptr[nk_command_buffer]): Unit = !struct.at17 = value
      def parent: Ptr[nk_panel] = struct._18.asInstanceOf[Ptr[nk_panel]]
      def parent_=(value: Ptr[nk_panel]): Unit = !struct.at18 = value.asInstanceOf[Ptr[Byte]]

  opaque type nk_pool = CStruct8[nk_allocator, nk_allocation_type, CUnsignedInt, Ptr[Byte], Ptr[Byte], CUnsignedInt, nk_size, nk_size]
  object nk_pool:
    given _tag: Tag[nk_pool] = Tag.materializeCStruct8Tag[nk_allocator, nk_allocation_type, CUnsignedInt, Ptr[Byte], Ptr[Byte], CUnsignedInt, nk_size, nk_size]
    def apply()(using Zone): Ptr[nk_pool] = scala.scalanative.unsafe.alloc[nk_pool](1)
    def apply(alloc: nk_allocator, `type`: nk_allocation_type, page_count: CUnsignedInt, pages: Ptr[nk_page], freelist: Ptr[nk_page_element], capacity: CUnsignedInt, size: nk_size, cap: nk_size)(using Zone): Ptr[nk_pool] = 
      val ____ptr = apply()
      (!____ptr).alloc = alloc
      (!____ptr).`type` = `type`
      (!____ptr).page_count = page_count
      (!____ptr).pages = pages
      (!____ptr).freelist = freelist
      (!____ptr).capacity = capacity
      (!____ptr).size = size
      (!____ptr).cap = cap
      ____ptr
    extension (struct: nk_pool)
      def alloc: nk_allocator = struct._1
      def alloc_=(value: nk_allocator): Unit = !struct.at1 = value
      def `type`: nk_allocation_type = struct._2
      def type_=(value: nk_allocation_type): Unit = !struct.at2 = value
      def page_count: CUnsignedInt = struct._3
      def page_count_=(value: CUnsignedInt): Unit = !struct.at3 = value
      def pages: Ptr[nk_page] = struct._4.asInstanceOf[Ptr[nk_page]]
      def pages_=(value: Ptr[nk_page]): Unit = !struct.at4 = value.asInstanceOf[Ptr[Byte]]
      def freelist: Ptr[nk_page_element] = struct._5.asInstanceOf[Ptr[nk_page_element]]
      def freelist_=(value: Ptr[nk_page_element]): Unit = !struct.at5 = value.asInstanceOf[Ptr[Byte]]
      def capacity: CUnsignedInt = struct._6
      def capacity_=(value: CUnsignedInt): Unit = !struct.at6 = value
      def size: nk_size = struct._7
      def size_=(value: nk_size): Unit = !struct.at7 = value
      def cap: nk_size = struct._8
      def cap_=(value: nk_size): Unit = !struct.at8 = value

  opaque type nk_popup_buffer = CStruct5[nk_size, nk_size, nk_size, nk_size, nk_bool]
  object nk_popup_buffer:
    given _tag: Tag[nk_popup_buffer] = Tag.materializeCStruct5Tag[nk_size, nk_size, nk_size, nk_size, nk_bool]
    def apply()(using Zone): Ptr[nk_popup_buffer] = scala.scalanative.unsafe.alloc[nk_popup_buffer](1)
    def apply(begin: nk_size, parent: nk_size, last: nk_size, end: nk_size, active: nk_bool)(using Zone): Ptr[nk_popup_buffer] = 
      val ____ptr = apply()
      (!____ptr).begin = begin
      (!____ptr).parent = parent
      (!____ptr).last = last
      (!____ptr).end = end
      (!____ptr).active = active
      ____ptr
    extension (struct: nk_popup_buffer)
      def begin: nk_size = struct._1
      def begin_=(value: nk_size): Unit = !struct.at1 = value
      def parent: nk_size = struct._2
      def parent_=(value: nk_size): Unit = !struct.at2 = value
      def last: nk_size = struct._3
      def last_=(value: nk_size): Unit = !struct.at3 = value
      def end: nk_size = struct._4
      def end_=(value: nk_size): Unit = !struct.at4 = value
      def active: nk_bool = struct._5
      def active_=(value: nk_bool): Unit = !struct.at5 = value

  opaque type nk_popup_state = CStruct10[Ptr[Byte], nk_panel_type, nk_popup_buffer, nk_hash, nk_bool, CUnsignedInt, CUnsignedInt, CUnsignedInt, CUnsignedInt, nk_rect]
  object nk_popup_state:
    given _tag: Tag[nk_popup_state] = Tag.materializeCStruct10Tag[Ptr[Byte], nk_panel_type, nk_popup_buffer, nk_hash, nk_bool, CUnsignedInt, CUnsignedInt, CUnsignedInt, CUnsignedInt, nk_rect]
    def apply()(using Zone): Ptr[nk_popup_state] = scala.scalanative.unsafe.alloc[nk_popup_state](1)
    def apply(win: Ptr[nk_window], `type`: nk_panel_type, buf: nk_popup_buffer, name: nk_hash, active: nk_bool, combo_count: CUnsignedInt, con_count: CUnsignedInt, con_old: CUnsignedInt, active_con: CUnsignedInt, header: nk_rect)(using Zone): Ptr[nk_popup_state] = 
      val ____ptr = apply()
      (!____ptr).win = win
      (!____ptr).`type` = `type`
      (!____ptr).buf = buf
      (!____ptr).name = name
      (!____ptr).active = active
      (!____ptr).combo_count = combo_count
      (!____ptr).con_count = con_count
      (!____ptr).con_old = con_old
      (!____ptr).active_con = active_con
      (!____ptr).header = header
      ____ptr
    extension (struct: nk_popup_state)
      def win: Ptr[nk_window] = struct._1.asInstanceOf[Ptr[nk_window]]
      def win_=(value: Ptr[nk_window]): Unit = !struct.at1 = value.asInstanceOf[Ptr[Byte]]
      def `type`: nk_panel_type = struct._2
      def type_=(value: nk_panel_type): Unit = !struct.at2 = value
      def buf: nk_popup_buffer = struct._3
      def buf_=(value: nk_popup_buffer): Unit = !struct.at3 = value
      def name: nk_hash = struct._4
      def name_=(value: nk_hash): Unit = !struct.at4 = value
      def active: nk_bool = struct._5
      def active_=(value: nk_bool): Unit = !struct.at5 = value
      def combo_count: CUnsignedInt = struct._6
      def combo_count_=(value: CUnsignedInt): Unit = !struct.at6 = value
      def con_count: CUnsignedInt = struct._7
      def con_count_=(value: CUnsignedInt): Unit = !struct.at7 = value
      def con_old: CUnsignedInt = struct._8
      def con_old_=(value: CUnsignedInt): Unit = !struct.at8 = value
      def active_con: CUnsignedInt = struct._9
      def active_con_=(value: CUnsignedInt): Unit = !struct.at9 = value
      def header: nk_rect = struct._10
      def header_=(value: nk_rect): Unit = !struct.at10 = value

  opaque type nk_property_state = CStruct11[CInt, CInt, CArray[CChar, Nat.Digit2[Nat._6, Nat._4]], CInt, CInt, CInt, CInt, nk_hash, CUnsignedInt, CUnsignedInt, CInt]
  object nk_property_state:
    given _tag: Tag[nk_property_state] = Tag.materializeCStruct11Tag[CInt, CInt, CArray[CChar, Nat.Digit2[Nat._6, Nat._4]], CInt, CInt, CInt, CInt, nk_hash, CUnsignedInt, CUnsignedInt, CInt]
    def apply()(using Zone): Ptr[nk_property_state] = scala.scalanative.unsafe.alloc[nk_property_state](1)
    def apply(active: CInt, prev: CInt, buffer: CArray[CChar, Nat.Digit2[Nat._6, Nat._4]], length: CInt, cursor: CInt, select_start: CInt, select_end: CInt, name: nk_hash, seq: CUnsignedInt, old: CUnsignedInt, state: CInt)(using Zone): Ptr[nk_property_state] = 
      val ____ptr = apply()
      (!____ptr).active = active
      (!____ptr).prev = prev
      (!____ptr).buffer = buffer
      (!____ptr).length = length
      (!____ptr).cursor = cursor
      (!____ptr).select_start = select_start
      (!____ptr).select_end = select_end
      (!____ptr).name = name
      (!____ptr).seq = seq
      (!____ptr).old = old
      (!____ptr).state = state
      ____ptr
    extension (struct: nk_property_state)
      def active: CInt = struct._1
      def active_=(value: CInt): Unit = !struct.at1 = value
      def prev: CInt = struct._2
      def prev_=(value: CInt): Unit = !struct.at2 = value
      def buffer: CArray[CChar, Nat.Digit2[Nat._6, Nat._4]] = struct._3
      def buffer_=(value: CArray[CChar, Nat.Digit2[Nat._6, Nat._4]]): Unit = !struct.at3 = value
      def length: CInt = struct._4
      def length_=(value: CInt): Unit = !struct.at4 = value
      def cursor: CInt = struct._5
      def cursor_=(value: CInt): Unit = !struct.at5 = value
      def select_start: CInt = struct._6
      def select_start_=(value: CInt): Unit = !struct.at6 = value
      def select_end: CInt = struct._7
      def select_end_=(value: CInt): Unit = !struct.at7 = value
      def name: nk_hash = struct._8
      def name_=(value: nk_hash): Unit = !struct.at8 = value
      def seq: CUnsignedInt = struct._9
      def seq_=(value: CUnsignedInt): Unit = !struct.at9 = value
      def old: CUnsignedInt = struct._10
      def old_=(value: CUnsignedInt): Unit = !struct.at10 = value
      def state: CInt = struct._11
      def state_=(value: CInt): Unit = !struct.at11 = value

  opaque type nk_property_variant = CStruct5[nk_property_kind, nk_property, nk_property, nk_property, nk_property]
  object nk_property_variant:
    given _tag: Tag[nk_property_variant] = Tag.materializeCStruct5Tag[nk_property_kind, nk_property, nk_property, nk_property, nk_property]
    def apply()(using Zone): Ptr[nk_property_variant] = scala.scalanative.unsafe.alloc[nk_property_variant](1)
    def apply(kind: nk_property_kind, value: nk_property, min_value: nk_property, max_value: nk_property, step: nk_property)(using Zone): Ptr[nk_property_variant] = 
      val ____ptr = apply()
      (!____ptr).kind = kind
      (!____ptr).value = value
      (!____ptr).min_value = min_value
      (!____ptr).max_value = max_value
      (!____ptr).step = step
      ____ptr
    extension (struct: nk_property_variant)
      def kind: nk_property_kind = struct._1
      def kind_=(value: nk_property_kind): Unit = !struct.at1 = value
      def value: nk_property = struct._2
      def value_=(value: nk_property): Unit = !struct.at2 = value
      def min_value: nk_property = struct._3
      def min_value_=(value: nk_property): Unit = !struct.at3 = value
      def max_value: nk_property = struct._4
      def max_value_=(value: nk_property): Unit = !struct.at4 = value
      def step: nk_property = struct._5
      def step_=(value: nk_property): Unit = !struct.at5 = value

  opaque type nk_rect = CStruct4[Float, Float, Float, Float]
  object nk_rect:
    given _tag: Tag[nk_rect] = Tag.materializeCStruct4Tag[Float, Float, Float, Float]
    def apply()(using Zone): Ptr[nk_rect] = scala.scalanative.unsafe.alloc[nk_rect](1)
    def apply(x: Float, y: Float, w: Float, h: Float)(using Zone): Ptr[nk_rect] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).w = w
      (!____ptr).h = h
      ____ptr
    extension (struct: nk_rect)
      def x: Float = struct._1
      def x_=(value: Float): Unit = !struct.at1 = value
      def y: Float = struct._2
      def y_=(value: Float): Unit = !struct.at2 = value
      def w: Float = struct._3
      def w_=(value: Float): Unit = !struct.at3 = value
      def h: Float = struct._4
      def h_=(value: Float): Unit = !struct.at4 = value

  opaque type nk_recti = CStruct4[CShort, CShort, CShort, CShort]
  object nk_recti:
    given _tag: Tag[nk_recti] = Tag.materializeCStruct4Tag[CShort, CShort, CShort, CShort]
    def apply()(using Zone): Ptr[nk_recti] = scala.scalanative.unsafe.alloc[nk_recti](1)
    def apply(x: CShort, y: CShort, w: CShort, h: CShort)(using Zone): Ptr[nk_recti] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).w = w
      (!____ptr).h = h
      ____ptr
    extension (struct: nk_recti)
      def x: CShort = struct._1
      def x_=(value: CShort): Unit = !struct.at1 = value
      def y: CShort = struct._2
      def y_=(value: CShort): Unit = !struct.at2 = value
      def w: CShort = struct._3
      def w_=(value: CShort): Unit = !struct.at3 = value
      def h: CShort = struct._4
      def h_=(value: CShort): Unit = !struct.at4 = value

  opaque type nk_row_layout = CStruct13[nk_panel_row_layout_type, CInt, Float, Float, CInt, Ptr[Float], Float, Float, Float, Float, nk_rect, CInt, CArray[Float, Nat.Digit2[Nat._1, Nat._6]]]
  object nk_row_layout:
    given _tag: Tag[nk_row_layout] = Tag.materializeCStruct13Tag[nk_panel_row_layout_type, CInt, Float, Float, CInt, Ptr[Float], Float, Float, Float, Float, nk_rect, CInt, CArray[Float, Nat.Digit2[Nat._1, Nat._6]]]
    def apply()(using Zone): Ptr[nk_row_layout] = scala.scalanative.unsafe.alloc[nk_row_layout](1)
    def apply(`type`: nk_panel_row_layout_type, index: CInt, height: Float, min_height: Float, columns: CInt, ratio: Ptr[Float], item_width: Float, item_height: Float, item_offset: Float, filled: Float, item: nk_rect, tree_depth: CInt, templates: CArray[Float, Nat.Digit2[Nat._1, Nat._6]])(using Zone): Ptr[nk_row_layout] = 
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).index = index
      (!____ptr).height = height
      (!____ptr).min_height = min_height
      (!____ptr).columns = columns
      (!____ptr).ratio = ratio
      (!____ptr).item_width = item_width
      (!____ptr).item_height = item_height
      (!____ptr).item_offset = item_offset
      (!____ptr).filled = filled
      (!____ptr).item = item
      (!____ptr).tree_depth = tree_depth
      (!____ptr).templates = templates
      ____ptr
    extension (struct: nk_row_layout)
      def `type`: nk_panel_row_layout_type = struct._1
      def type_=(value: nk_panel_row_layout_type): Unit = !struct.at1 = value
      def index: CInt = struct._2
      def index_=(value: CInt): Unit = !struct.at2 = value
      def height: Float = struct._3
      def height_=(value: Float): Unit = !struct.at3 = value
      def min_height: Float = struct._4
      def min_height_=(value: Float): Unit = !struct.at4 = value
      def columns: CInt = struct._5
      def columns_=(value: CInt): Unit = !struct.at5 = value
      def ratio: Ptr[Float] = struct._6
      def ratio_=(value: Ptr[Float]): Unit = !struct.at6 = value
      def item_width: Float = struct._7
      def item_width_=(value: Float): Unit = !struct.at7 = value
      def item_height: Float = struct._8
      def item_height_=(value: Float): Unit = !struct.at8 = value
      def item_offset: Float = struct._9
      def item_offset_=(value: Float): Unit = !struct.at9 = value
      def filled: Float = struct._10
      def filled_=(value: Float): Unit = !struct.at10 = value
      def item: nk_rect = struct._11
      def item_=(value: nk_rect): Unit = !struct.at11 = value
      def tree_depth: CInt = struct._12
      def tree_depth_=(value: CInt): Unit = !struct.at12 = value
      def templates: CArray[Float, Nat.Digit2[Nat._1, Nat._6]] = struct._13
      def templates_=(value: CArray[Float, Nat.Digit2[Nat._1, Nat._6]]): Unit = !struct.at13 = value

  opaque type nk_scroll = CStruct2[nk_uint, nk_uint]
  object nk_scroll:
    given _tag: Tag[nk_scroll] = Tag.materializeCStruct2Tag[nk_uint, nk_uint]
    def apply()(using Zone): Ptr[nk_scroll] = scala.scalanative.unsafe.alloc[nk_scroll](1)
    def apply(x: nk_uint, y: nk_uint)(using Zone): Ptr[nk_scroll] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      ____ptr
    extension (struct: nk_scroll)
      def x: nk_uint = struct._1
      def x_=(value: nk_uint): Unit = !struct.at1 = value
      def y: nk_uint = struct._2
      def y_=(value: nk_uint): Unit = !struct.at2 = value

  opaque type nk_str = CStruct2[nk_buffer, CInt]
  object nk_str:
    given _tag: Tag[nk_str] = Tag.materializeCStruct2Tag[nk_buffer, CInt]
    def apply()(using Zone): Ptr[nk_str] = scala.scalanative.unsafe.alloc[nk_str](1)
    def apply(buffer: nk_buffer, len: CInt)(using Zone): Ptr[nk_str] = 
      val ____ptr = apply()
      (!____ptr).buffer = buffer
      (!____ptr).len = len
      ____ptr
    extension (struct: nk_str)
      def buffer: nk_buffer = struct._1
      def buffer_=(value: nk_buffer): Unit = !struct.at1 = value
      def len: CInt = struct._2
      def len_=(value: CInt): Unit = !struct.at2 = value

  opaque type nk_style = CStruct22[Ptr[nk_user_font], CArray[Ptr[nk_cursor], Nat._7], Ptr[nk_cursor], Ptr[nk_cursor], CInt, nk_style_text, nk_style_button, nk_style_button, nk_style_button, nk_style_toggle, nk_style_toggle, nk_style_selectable, nk_style_slider, nk_style_progress, nk_style_property, nk_style_edit, nk_style_chart, nk_style_scrollbar, nk_style_scrollbar, nk_style_tab, nk_style_combo, nk_style_window]
  object nk_style:
    given _tag: Tag[nk_style] = Tag.materializeCStruct22Tag[Ptr[nk_user_font], CArray[Ptr[nk_cursor], Nat._7], Ptr[nk_cursor], Ptr[nk_cursor], CInt, nk_style_text, nk_style_button, nk_style_button, nk_style_button, nk_style_toggle, nk_style_toggle, nk_style_selectable, nk_style_slider, nk_style_progress, nk_style_property, nk_style_edit, nk_style_chart, nk_style_scrollbar, nk_style_scrollbar, nk_style_tab, nk_style_combo, nk_style_window]
    def apply()(using Zone): Ptr[nk_style] = scala.scalanative.unsafe.alloc[nk_style](1)
    def apply(font: Ptr[nk_user_font], cursors: CArray[Ptr[nk_cursor], Nat._7], cursor_active: Ptr[nk_cursor], cursor_last: Ptr[nk_cursor], cursor_visible: CInt, text: nk_style_text, button: nk_style_button, contextual_button: nk_style_button, menu_button: nk_style_button, option: nk_style_toggle, checkbox: nk_style_toggle, selectable: nk_style_selectable, slider: nk_style_slider, progress: nk_style_progress, property: nk_style_property, edit: nk_style_edit, chart: nk_style_chart, scrollh: nk_style_scrollbar, scrollv: nk_style_scrollbar, tab: nk_style_tab, combo: nk_style_combo, window: nk_style_window)(using Zone): Ptr[nk_style] = 
      val ____ptr = apply()
      (!____ptr).font = font
      (!____ptr).cursors = cursors
      (!____ptr).cursor_active = cursor_active
      (!____ptr).cursor_last = cursor_last
      (!____ptr).cursor_visible = cursor_visible
      (!____ptr).text = text
      (!____ptr).button = button
      (!____ptr).contextual_button = contextual_button
      (!____ptr).menu_button = menu_button
      (!____ptr).option = option
      (!____ptr).checkbox = checkbox
      (!____ptr).selectable = selectable
      (!____ptr).slider = slider
      (!____ptr).progress = progress
      (!____ptr).property = property
      (!____ptr).edit = edit
      (!____ptr).chart = chart
      (!____ptr).scrollh = scrollh
      (!____ptr).scrollv = scrollv
      (!____ptr).tab = tab
      (!____ptr).combo = combo
      (!____ptr).window = window
      ____ptr
    extension (struct: nk_style)
      def font: Ptr[nk_user_font] = struct._1
      def font_=(value: Ptr[nk_user_font]): Unit = !struct.at1 = value
      def cursors: CArray[Ptr[nk_cursor], Nat._7] = struct._2
      def cursors_=(value: CArray[Ptr[nk_cursor], Nat._7]): Unit = !struct.at2 = value
      def cursor_active: Ptr[nk_cursor] = struct._3
      def cursor_active_=(value: Ptr[nk_cursor]): Unit = !struct.at3 = value
      def cursor_last: Ptr[nk_cursor] = struct._4
      def cursor_last_=(value: Ptr[nk_cursor]): Unit = !struct.at4 = value
      def cursor_visible: CInt = struct._5
      def cursor_visible_=(value: CInt): Unit = !struct.at5 = value
      def text: nk_style_text = struct._6
      def text_=(value: nk_style_text): Unit = !struct.at6 = value
      def button: nk_style_button = struct._7
      def button_=(value: nk_style_button): Unit = !struct.at7 = value
      def contextual_button: nk_style_button = struct._8
      def contextual_button_=(value: nk_style_button): Unit = !struct.at8 = value
      def menu_button: nk_style_button = struct._9
      def menu_button_=(value: nk_style_button): Unit = !struct.at9 = value
      def option: nk_style_toggle = struct._10
      def option_=(value: nk_style_toggle): Unit = !struct.at10 = value
      def checkbox: nk_style_toggle = struct._11
      def checkbox_=(value: nk_style_toggle): Unit = !struct.at11 = value
      def selectable: nk_style_selectable = struct._12
      def selectable_=(value: nk_style_selectable): Unit = !struct.at12 = value
      def slider: nk_style_slider = struct._13
      def slider_=(value: nk_style_slider): Unit = !struct.at13 = value
      def progress: nk_style_progress = struct._14
      def progress_=(value: nk_style_progress): Unit = !struct.at14 = value
      def property: nk_style_property = struct._15
      def property_=(value: nk_style_property): Unit = !struct.at15 = value
      def edit: nk_style_edit = struct._16
      def edit_=(value: nk_style_edit): Unit = !struct.at16 = value
      def chart: nk_style_chart = struct._17
      def chart_=(value: nk_style_chart): Unit = !struct.at17 = value
      def scrollh: nk_style_scrollbar = struct._18
      def scrollh_=(value: nk_style_scrollbar): Unit = !struct.at18 = value
      def scrollv: nk_style_scrollbar = struct._19
      def scrollv_=(value: nk_style_scrollbar): Unit = !struct.at19 = value
      def tab: nk_style_tab = struct._20
      def tab_=(value: nk_style_tab): Unit = !struct.at20 = value
      def combo: nk_style_combo = struct._21
      def combo_=(value: nk_style_combo): Unit = !struct.at21 = value
      def window: nk_style_window = struct._22
      def window_=(value: nk_style_window): Unit = !struct.at22 = value

  opaque type nk_style_button = CStruct17[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_color, nk_color, nk_color, nk_color, nk_flags, Float, Float, nk_vec2, nk_vec2, nk_vec2, nk_handle, CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]
  object nk_style_button:
    given _tag: Tag[nk_style_button] = Tag.materializeCStruct17Tag[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_color, nk_color, nk_color, nk_color, nk_flags, Float, Float, nk_vec2, nk_vec2, nk_vec2, nk_handle, CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]
    def apply()(using Zone): Ptr[nk_style_button] = scala.scalanative.unsafe.alloc[nk_style_button](1)
    def apply(normal: nk_style_item, hover: nk_style_item, active: nk_style_item, border_color: nk_color, text_background: nk_color, text_normal: nk_color, text_hover: nk_color, text_active: nk_color, text_alignment: nk_flags, border: Float, rounding: Float, padding: nk_vec2, image_padding: nk_vec2, touch_padding: nk_vec2, userdata: nk_handle, draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit])(using Zone): Ptr[nk_style_button] = 
      val ____ptr = apply()
      (!____ptr).normal = normal
      (!____ptr).hover = hover
      (!____ptr).active = active
      (!____ptr).border_color = border_color
      (!____ptr).text_background = text_background
      (!____ptr).text_normal = text_normal
      (!____ptr).text_hover = text_hover
      (!____ptr).text_active = text_active
      (!____ptr).text_alignment = text_alignment
      (!____ptr).border = border
      (!____ptr).rounding = rounding
      (!____ptr).padding = padding
      (!____ptr).image_padding = image_padding
      (!____ptr).touch_padding = touch_padding
      (!____ptr).userdata = userdata
      (!____ptr).draw_begin = draw_begin
      (!____ptr).draw_end = draw_end
      ____ptr
    extension (struct: nk_style_button)
      def normal: nk_style_item = struct._1
      def normal_=(value: nk_style_item): Unit = !struct.at1 = value
      def hover: nk_style_item = struct._2
      def hover_=(value: nk_style_item): Unit = !struct.at2 = value
      def active: nk_style_item = struct._3
      def active_=(value: nk_style_item): Unit = !struct.at3 = value
      def border_color: nk_color = struct._4
      def border_color_=(value: nk_color): Unit = !struct.at4 = value
      def text_background: nk_color = struct._5
      def text_background_=(value: nk_color): Unit = !struct.at5 = value
      def text_normal: nk_color = struct._6
      def text_normal_=(value: nk_color): Unit = !struct.at6 = value
      def text_hover: nk_color = struct._7
      def text_hover_=(value: nk_color): Unit = !struct.at7 = value
      def text_active: nk_color = struct._8
      def text_active_=(value: nk_color): Unit = !struct.at8 = value
      def text_alignment: nk_flags = struct._9
      def text_alignment_=(value: nk_flags): Unit = !struct.at9 = value
      def border: Float = struct._10
      def border_=(value: Float): Unit = !struct.at10 = value
      def rounding: Float = struct._11
      def rounding_=(value: Float): Unit = !struct.at11 = value
      def padding: nk_vec2 = struct._12
      def padding_=(value: nk_vec2): Unit = !struct.at12 = value
      def image_padding: nk_vec2 = struct._13
      def image_padding_=(value: nk_vec2): Unit = !struct.at13 = value
      def touch_padding: nk_vec2 = struct._14
      def touch_padding_=(value: nk_vec2): Unit = !struct.at14 = value
      def userdata: nk_handle = struct._15
      def userdata_=(value: nk_handle): Unit = !struct.at15 = value
      def draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = struct._16
      def draw_begin_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at16 = value
      def draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = struct._17
      def draw_end_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at17 = value

  opaque type nk_style_chart = CStruct7[nk_style_item, nk_color, nk_color, nk_color, Float, Float, nk_vec2]
  object nk_style_chart:
    given _tag: Tag[nk_style_chart] = Tag.materializeCStruct7Tag[nk_style_item, nk_color, nk_color, nk_color, Float, Float, nk_vec2]
    def apply()(using Zone): Ptr[nk_style_chart] = scala.scalanative.unsafe.alloc[nk_style_chart](1)
    def apply(background: nk_style_item, border_color: nk_color, selected_color: nk_color, color: nk_color, border: Float, rounding: Float, padding: nk_vec2)(using Zone): Ptr[nk_style_chart] = 
      val ____ptr = apply()
      (!____ptr).background = background
      (!____ptr).border_color = border_color
      (!____ptr).selected_color = selected_color
      (!____ptr).color = color
      (!____ptr).border = border
      (!____ptr).rounding = rounding
      (!____ptr).padding = padding
      ____ptr
    extension (struct: nk_style_chart)
      def background: nk_style_item = struct._1
      def background_=(value: nk_style_item): Unit = !struct.at1 = value
      def border_color: nk_color = struct._2
      def border_color_=(value: nk_color): Unit = !struct.at2 = value
      def selected_color: nk_color = struct._3
      def selected_color_=(value: nk_color): Unit = !struct.at3 = value
      def color: nk_color = struct._4
      def color_=(value: nk_color): Unit = !struct.at4 = value
      def border: Float = struct._5
      def border_=(value: Float): Unit = !struct.at5 = value
      def rounding: Float = struct._6
      def rounding_=(value: Float): Unit = !struct.at6 = value
      def padding: nk_vec2 = struct._7
      def padding_=(value: nk_vec2): Unit = !struct.at7 = value

  opaque type nk_style_combo = CStruct19[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_style_button, nk_symbol_type, nk_symbol_type, nk_symbol_type, Float, Float, nk_vec2, nk_vec2, nk_vec2]
  object nk_style_combo:
    given _tag: Tag[nk_style_combo] = Tag.materializeCStruct19Tag[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_style_button, nk_symbol_type, nk_symbol_type, nk_symbol_type, Float, Float, nk_vec2, nk_vec2, nk_vec2]
    def apply()(using Zone): Ptr[nk_style_combo] = scala.scalanative.unsafe.alloc[nk_style_combo](1)
    def apply(normal: nk_style_item, hover: nk_style_item, active: nk_style_item, border_color: nk_color, label_normal: nk_color, label_hover: nk_color, label_active: nk_color, symbol_normal: nk_color, symbol_hover: nk_color, symbol_active: nk_color, button: nk_style_button, sym_normal: nk_symbol_type, sym_hover: nk_symbol_type, sym_active: nk_symbol_type, border: Float, rounding: Float, content_padding: nk_vec2, button_padding: nk_vec2, spacing: nk_vec2)(using Zone): Ptr[nk_style_combo] = 
      val ____ptr = apply()
      (!____ptr).normal = normal
      (!____ptr).hover = hover
      (!____ptr).active = active
      (!____ptr).border_color = border_color
      (!____ptr).label_normal = label_normal
      (!____ptr).label_hover = label_hover
      (!____ptr).label_active = label_active
      (!____ptr).symbol_normal = symbol_normal
      (!____ptr).symbol_hover = symbol_hover
      (!____ptr).symbol_active = symbol_active
      (!____ptr).button = button
      (!____ptr).sym_normal = sym_normal
      (!____ptr).sym_hover = sym_hover
      (!____ptr).sym_active = sym_active
      (!____ptr).border = border
      (!____ptr).rounding = rounding
      (!____ptr).content_padding = content_padding
      (!____ptr).button_padding = button_padding
      (!____ptr).spacing = spacing
      ____ptr
    extension (struct: nk_style_combo)
      def normal: nk_style_item = struct._1
      def normal_=(value: nk_style_item): Unit = !struct.at1 = value
      def hover: nk_style_item = struct._2
      def hover_=(value: nk_style_item): Unit = !struct.at2 = value
      def active: nk_style_item = struct._3
      def active_=(value: nk_style_item): Unit = !struct.at3 = value
      def border_color: nk_color = struct._4
      def border_color_=(value: nk_color): Unit = !struct.at4 = value
      def label_normal: nk_color = struct._5
      def label_normal_=(value: nk_color): Unit = !struct.at5 = value
      def label_hover: nk_color = struct._6
      def label_hover_=(value: nk_color): Unit = !struct.at6 = value
      def label_active: nk_color = struct._7
      def label_active_=(value: nk_color): Unit = !struct.at7 = value
      def symbol_normal: nk_color = struct._8
      def symbol_normal_=(value: nk_color): Unit = !struct.at8 = value
      def symbol_hover: nk_color = struct._9
      def symbol_hover_=(value: nk_color): Unit = !struct.at9 = value
      def symbol_active: nk_color = struct._10
      def symbol_active_=(value: nk_color): Unit = !struct.at10 = value
      def button: nk_style_button = struct._11
      def button_=(value: nk_style_button): Unit = !struct.at11 = value
      def sym_normal: nk_symbol_type = struct._12
      def sym_normal_=(value: nk_symbol_type): Unit = !struct.at12 = value
      def sym_hover: nk_symbol_type = struct._13
      def sym_hover_=(value: nk_symbol_type): Unit = !struct.at13 = value
      def sym_active: nk_symbol_type = struct._14
      def sym_active_=(value: nk_symbol_type): Unit = !struct.at14 = value
      def border: Float = struct._15
      def border_=(value: Float): Unit = !struct.at15 = value
      def rounding: Float = struct._16
      def rounding_=(value: Float): Unit = !struct.at16 = value
      def content_padding: nk_vec2 = struct._17
      def content_padding_=(value: nk_vec2): Unit = !struct.at17 = value
      def button_padding: nk_vec2 = struct._18
      def button_padding_=(value: nk_vec2): Unit = !struct.at18 = value
      def spacing: nk_vec2 = struct._19
      def spacing_=(value: nk_vec2): Unit = !struct.at19 = value

  opaque type nk_style_edit = CStruct22[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_style_scrollbar, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, Float, Float, Float, nk_vec2, nk_vec2, Float]
  object nk_style_edit:
    given _tag: Tag[nk_style_edit] = Tag.materializeCStruct22Tag[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_style_scrollbar, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, Float, Float, Float, nk_vec2, nk_vec2, Float]
    def apply()(using Zone): Ptr[nk_style_edit] = scala.scalanative.unsafe.alloc[nk_style_edit](1)
    def apply(normal: nk_style_item, hover: nk_style_item, active: nk_style_item, border_color: nk_color, scrollbar: nk_style_scrollbar, cursor_normal: nk_color, cursor_hover: nk_color, cursor_text_normal: nk_color, cursor_text_hover: nk_color, text_normal: nk_color, text_hover: nk_color, text_active: nk_color, selected_normal: nk_color, selected_hover: nk_color, selected_text_normal: nk_color, selected_text_hover: nk_color, border: Float, rounding: Float, cursor_size: Float, scrollbar_size: nk_vec2, padding: nk_vec2, row_padding: Float)(using Zone): Ptr[nk_style_edit] = 
      val ____ptr = apply()
      (!____ptr).normal = normal
      (!____ptr).hover = hover
      (!____ptr).active = active
      (!____ptr).border_color = border_color
      (!____ptr).scrollbar = scrollbar
      (!____ptr).cursor_normal = cursor_normal
      (!____ptr).cursor_hover = cursor_hover
      (!____ptr).cursor_text_normal = cursor_text_normal
      (!____ptr).cursor_text_hover = cursor_text_hover
      (!____ptr).text_normal = text_normal
      (!____ptr).text_hover = text_hover
      (!____ptr).text_active = text_active
      (!____ptr).selected_normal = selected_normal
      (!____ptr).selected_hover = selected_hover
      (!____ptr).selected_text_normal = selected_text_normal
      (!____ptr).selected_text_hover = selected_text_hover
      (!____ptr).border = border
      (!____ptr).rounding = rounding
      (!____ptr).cursor_size = cursor_size
      (!____ptr).scrollbar_size = scrollbar_size
      (!____ptr).padding = padding
      (!____ptr).row_padding = row_padding
      ____ptr
    extension (struct: nk_style_edit)
      def normal: nk_style_item = struct._1
      def normal_=(value: nk_style_item): Unit = !struct.at1 = value
      def hover: nk_style_item = struct._2
      def hover_=(value: nk_style_item): Unit = !struct.at2 = value
      def active: nk_style_item = struct._3
      def active_=(value: nk_style_item): Unit = !struct.at3 = value
      def border_color: nk_color = struct._4
      def border_color_=(value: nk_color): Unit = !struct.at4 = value
      def scrollbar: nk_style_scrollbar = struct._5
      def scrollbar_=(value: nk_style_scrollbar): Unit = !struct.at5 = value
      def cursor_normal: nk_color = struct._6
      def cursor_normal_=(value: nk_color): Unit = !struct.at6 = value
      def cursor_hover: nk_color = struct._7
      def cursor_hover_=(value: nk_color): Unit = !struct.at7 = value
      def cursor_text_normal: nk_color = struct._8
      def cursor_text_normal_=(value: nk_color): Unit = !struct.at8 = value
      def cursor_text_hover: nk_color = struct._9
      def cursor_text_hover_=(value: nk_color): Unit = !struct.at9 = value
      def text_normal: nk_color = struct._10
      def text_normal_=(value: nk_color): Unit = !struct.at10 = value
      def text_hover: nk_color = struct._11
      def text_hover_=(value: nk_color): Unit = !struct.at11 = value
      def text_active: nk_color = struct._12
      def text_active_=(value: nk_color): Unit = !struct.at12 = value
      def selected_normal: nk_color = struct._13
      def selected_normal_=(value: nk_color): Unit = !struct.at13 = value
      def selected_hover: nk_color = struct._14
      def selected_hover_=(value: nk_color): Unit = !struct.at14 = value
      def selected_text_normal: nk_color = struct._15
      def selected_text_normal_=(value: nk_color): Unit = !struct.at15 = value
      def selected_text_hover: nk_color = struct._16
      def selected_text_hover_=(value: nk_color): Unit = !struct.at16 = value
      def border: Float = struct._17
      def border_=(value: Float): Unit = !struct.at17 = value
      def rounding: Float = struct._18
      def rounding_=(value: Float): Unit = !struct.at18 = value
      def cursor_size: Float = struct._19
      def cursor_size_=(value: Float): Unit = !struct.at19 = value
      def scrollbar_size: nk_vec2 = struct._20
      def scrollbar_size_=(value: nk_vec2): Unit = !struct.at20 = value
      def padding: nk_vec2 = struct._21
      def padding_=(value: nk_vec2): Unit = !struct.at21 = value
      def row_padding: Float = struct._22
      def row_padding_=(value: Float): Unit = !struct.at22 = value

  opaque type nk_style_item = CStruct2[nk_style_item_type, nk_style_item_data]
  object nk_style_item:
    given _tag: Tag[nk_style_item] = Tag.materializeCStruct2Tag[nk_style_item_type, nk_style_item_data]
    def apply()(using Zone): Ptr[nk_style_item] = scala.scalanative.unsafe.alloc[nk_style_item](1)
    def apply(`type`: nk_style_item_type, data: nk_style_item_data)(using Zone): Ptr[nk_style_item] = 
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).data = data
      ____ptr
    extension (struct: nk_style_item)
      def `type`: nk_style_item_type = struct._1
      def type_=(value: nk_style_item_type): Unit = !struct.at1 = value
      def data: nk_style_item_data = struct._2
      def data_=(value: nk_style_item_data): Unit = !struct.at2 = value

  opaque type nk_style_progress = CStruct16[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_style_item, nk_style_item, nk_style_item, nk_color, Float, Float, Float, Float, nk_vec2, nk_handle, CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]
  object nk_style_progress:
    given _tag: Tag[nk_style_progress] = Tag.materializeCStruct16Tag[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_style_item, nk_style_item, nk_style_item, nk_color, Float, Float, Float, Float, nk_vec2, nk_handle, CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]
    def apply()(using Zone): Ptr[nk_style_progress] = scala.scalanative.unsafe.alloc[nk_style_progress](1)
    def apply(normal: nk_style_item, hover: nk_style_item, active: nk_style_item, border_color: nk_color, cursor_normal: nk_style_item, cursor_hover: nk_style_item, cursor_active: nk_style_item, cursor_border_color: nk_color, rounding: Float, border: Float, cursor_border: Float, cursor_rounding: Float, padding: nk_vec2, userdata: nk_handle, draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit])(using Zone): Ptr[nk_style_progress] = 
      val ____ptr = apply()
      (!____ptr).normal = normal
      (!____ptr).hover = hover
      (!____ptr).active = active
      (!____ptr).border_color = border_color
      (!____ptr).cursor_normal = cursor_normal
      (!____ptr).cursor_hover = cursor_hover
      (!____ptr).cursor_active = cursor_active
      (!____ptr).cursor_border_color = cursor_border_color
      (!____ptr).rounding = rounding
      (!____ptr).border = border
      (!____ptr).cursor_border = cursor_border
      (!____ptr).cursor_rounding = cursor_rounding
      (!____ptr).padding = padding
      (!____ptr).userdata = userdata
      (!____ptr).draw_begin = draw_begin
      (!____ptr).draw_end = draw_end
      ____ptr
    extension (struct: nk_style_progress)
      def normal: nk_style_item = struct._1
      def normal_=(value: nk_style_item): Unit = !struct.at1 = value
      def hover: nk_style_item = struct._2
      def hover_=(value: nk_style_item): Unit = !struct.at2 = value
      def active: nk_style_item = struct._3
      def active_=(value: nk_style_item): Unit = !struct.at3 = value
      def border_color: nk_color = struct._4
      def border_color_=(value: nk_color): Unit = !struct.at4 = value
      def cursor_normal: nk_style_item = struct._5
      def cursor_normal_=(value: nk_style_item): Unit = !struct.at5 = value
      def cursor_hover: nk_style_item = struct._6
      def cursor_hover_=(value: nk_style_item): Unit = !struct.at6 = value
      def cursor_active: nk_style_item = struct._7
      def cursor_active_=(value: nk_style_item): Unit = !struct.at7 = value
      def cursor_border_color: nk_color = struct._8
      def cursor_border_color_=(value: nk_color): Unit = !struct.at8 = value
      def rounding: Float = struct._9
      def rounding_=(value: Float): Unit = !struct.at9 = value
      def border: Float = struct._10
      def border_=(value: Float): Unit = !struct.at10 = value
      def cursor_border: Float = struct._11
      def cursor_border_=(value: Float): Unit = !struct.at11 = value
      def cursor_rounding: Float = struct._12
      def cursor_rounding_=(value: Float): Unit = !struct.at12 = value
      def padding: nk_vec2 = struct._13
      def padding_=(value: nk_vec2): Unit = !struct.at13 = value
      def userdata: nk_handle = struct._14
      def userdata_=(value: nk_handle): Unit = !struct.at14 = value
      def draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = struct._15
      def draw_begin_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at15 = value
      def draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = struct._16
      def draw_end_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at16 = value

  opaque type nk_style_property = CStruct18[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_color, nk_color, nk_color, nk_symbol_type, nk_symbol_type, Float, Float, nk_vec2, nk_style_edit, nk_style_button, nk_style_button, nk_handle, CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]
  object nk_style_property:
    given _tag: Tag[nk_style_property] = Tag.materializeCStruct18Tag[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_color, nk_color, nk_color, nk_symbol_type, nk_symbol_type, Float, Float, nk_vec2, nk_style_edit, nk_style_button, nk_style_button, nk_handle, CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]
    def apply()(using Zone): Ptr[nk_style_property] = scala.scalanative.unsafe.alloc[nk_style_property](1)
    def apply(normal: nk_style_item, hover: nk_style_item, active: nk_style_item, border_color: nk_color, label_normal: nk_color, label_hover: nk_color, label_active: nk_color, sym_left: nk_symbol_type, sym_right: nk_symbol_type, border: Float, rounding: Float, padding: nk_vec2, edit: nk_style_edit, inc_button: nk_style_button, dec_button: nk_style_button, userdata: nk_handle, draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit])(using Zone): Ptr[nk_style_property] = 
      val ____ptr = apply()
      (!____ptr).normal = normal
      (!____ptr).hover = hover
      (!____ptr).active = active
      (!____ptr).border_color = border_color
      (!____ptr).label_normal = label_normal
      (!____ptr).label_hover = label_hover
      (!____ptr).label_active = label_active
      (!____ptr).sym_left = sym_left
      (!____ptr).sym_right = sym_right
      (!____ptr).border = border
      (!____ptr).rounding = rounding
      (!____ptr).padding = padding
      (!____ptr).edit = edit
      (!____ptr).inc_button = inc_button
      (!____ptr).dec_button = dec_button
      (!____ptr).userdata = userdata
      (!____ptr).draw_begin = draw_begin
      (!____ptr).draw_end = draw_end
      ____ptr
    extension (struct: nk_style_property)
      def normal: nk_style_item = struct._1
      def normal_=(value: nk_style_item): Unit = !struct.at1 = value
      def hover: nk_style_item = struct._2
      def hover_=(value: nk_style_item): Unit = !struct.at2 = value
      def active: nk_style_item = struct._3
      def active_=(value: nk_style_item): Unit = !struct.at3 = value
      def border_color: nk_color = struct._4
      def border_color_=(value: nk_color): Unit = !struct.at4 = value
      def label_normal: nk_color = struct._5
      def label_normal_=(value: nk_color): Unit = !struct.at5 = value
      def label_hover: nk_color = struct._6
      def label_hover_=(value: nk_color): Unit = !struct.at6 = value
      def label_active: nk_color = struct._7
      def label_active_=(value: nk_color): Unit = !struct.at7 = value
      def sym_left: nk_symbol_type = struct._8
      def sym_left_=(value: nk_symbol_type): Unit = !struct.at8 = value
      def sym_right: nk_symbol_type = struct._9
      def sym_right_=(value: nk_symbol_type): Unit = !struct.at9 = value
      def border: Float = struct._10
      def border_=(value: Float): Unit = !struct.at10 = value
      def rounding: Float = struct._11
      def rounding_=(value: Float): Unit = !struct.at11 = value
      def padding: nk_vec2 = struct._12
      def padding_=(value: nk_vec2): Unit = !struct.at12 = value
      def edit: nk_style_edit = struct._13
      def edit_=(value: nk_style_edit): Unit = !struct.at13 = value
      def inc_button: nk_style_button = struct._14
      def inc_button_=(value: nk_style_button): Unit = !struct.at14 = value
      def dec_button: nk_style_button = struct._15
      def dec_button_=(value: nk_style_button): Unit = !struct.at15 = value
      def userdata: nk_handle = struct._16
      def userdata_=(value: nk_handle): Unit = !struct.at16 = value
      def draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = struct._17
      def draw_begin_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at17 = value
      def draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = struct._18
      def draw_end_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at18 = value

  opaque type nk_style_scrollbar = CStruct21[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_style_item, nk_style_item, nk_style_item, nk_color, Float, Float, Float, Float, nk_vec2, CInt, nk_style_button, nk_style_button, nk_symbol_type, nk_symbol_type, nk_handle, CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]
  object nk_style_scrollbar:
    given _tag: Tag[nk_style_scrollbar] = Tag.materializeCStruct21Tag[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_style_item, nk_style_item, nk_style_item, nk_color, Float, Float, Float, Float, nk_vec2, CInt, nk_style_button, nk_style_button, nk_symbol_type, nk_symbol_type, nk_handle, CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]
    def apply()(using Zone): Ptr[nk_style_scrollbar] = scala.scalanative.unsafe.alloc[nk_style_scrollbar](1)
    def apply(normal: nk_style_item, hover: nk_style_item, active: nk_style_item, border_color: nk_color, cursor_normal: nk_style_item, cursor_hover: nk_style_item, cursor_active: nk_style_item, cursor_border_color: nk_color, border: Float, rounding: Float, border_cursor: Float, rounding_cursor: Float, padding: nk_vec2, show_buttons: CInt, inc_button: nk_style_button, dec_button: nk_style_button, inc_symbol: nk_symbol_type, dec_symbol: nk_symbol_type, userdata: nk_handle, draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit])(using Zone): Ptr[nk_style_scrollbar] = 
      val ____ptr = apply()
      (!____ptr).normal = normal
      (!____ptr).hover = hover
      (!____ptr).active = active
      (!____ptr).border_color = border_color
      (!____ptr).cursor_normal = cursor_normal
      (!____ptr).cursor_hover = cursor_hover
      (!____ptr).cursor_active = cursor_active
      (!____ptr).cursor_border_color = cursor_border_color
      (!____ptr).border = border
      (!____ptr).rounding = rounding
      (!____ptr).border_cursor = border_cursor
      (!____ptr).rounding_cursor = rounding_cursor
      (!____ptr).padding = padding
      (!____ptr).show_buttons = show_buttons
      (!____ptr).inc_button = inc_button
      (!____ptr).dec_button = dec_button
      (!____ptr).inc_symbol = inc_symbol
      (!____ptr).dec_symbol = dec_symbol
      (!____ptr).userdata = userdata
      (!____ptr).draw_begin = draw_begin
      (!____ptr).draw_end = draw_end
      ____ptr
    extension (struct: nk_style_scrollbar)
      def normal: nk_style_item = struct._1
      def normal_=(value: nk_style_item): Unit = !struct.at1 = value
      def hover: nk_style_item = struct._2
      def hover_=(value: nk_style_item): Unit = !struct.at2 = value
      def active: nk_style_item = struct._3
      def active_=(value: nk_style_item): Unit = !struct.at3 = value
      def border_color: nk_color = struct._4
      def border_color_=(value: nk_color): Unit = !struct.at4 = value
      def cursor_normal: nk_style_item = struct._5
      def cursor_normal_=(value: nk_style_item): Unit = !struct.at5 = value
      def cursor_hover: nk_style_item = struct._6
      def cursor_hover_=(value: nk_style_item): Unit = !struct.at6 = value
      def cursor_active: nk_style_item = struct._7
      def cursor_active_=(value: nk_style_item): Unit = !struct.at7 = value
      def cursor_border_color: nk_color = struct._8
      def cursor_border_color_=(value: nk_color): Unit = !struct.at8 = value
      def border: Float = struct._9
      def border_=(value: Float): Unit = !struct.at9 = value
      def rounding: Float = struct._10
      def rounding_=(value: Float): Unit = !struct.at10 = value
      def border_cursor: Float = struct._11
      def border_cursor_=(value: Float): Unit = !struct.at11 = value
      def rounding_cursor: Float = struct._12
      def rounding_cursor_=(value: Float): Unit = !struct.at12 = value
      def padding: nk_vec2 = struct._13
      def padding_=(value: nk_vec2): Unit = !struct.at13 = value
      def show_buttons: CInt = struct._14
      def show_buttons_=(value: CInt): Unit = !struct.at14 = value
      def inc_button: nk_style_button = struct._15
      def inc_button_=(value: nk_style_button): Unit = !struct.at15 = value
      def dec_button: nk_style_button = struct._16
      def dec_button_=(value: nk_style_button): Unit = !struct.at16 = value
      def inc_symbol: nk_symbol_type = struct._17
      def inc_symbol_=(value: nk_symbol_type): Unit = !struct.at17 = value
      def dec_symbol: nk_symbol_type = struct._18
      def dec_symbol_=(value: nk_symbol_type): Unit = !struct.at18 = value
      def userdata: nk_handle = struct._19
      def userdata_=(value: nk_handle): Unit = !struct.at19 = value
      def draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = struct._20
      def draw_begin_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at20 = value
      def draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = struct._21
      def draw_end_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at21 = value

  opaque type nk_style_selectable = CStruct21[nk_style_item, nk_style_item, nk_style_item, nk_style_item, nk_style_item, nk_style_item, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_flags, Float, nk_vec2, nk_vec2, nk_vec2, nk_handle, CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]
  object nk_style_selectable:
    given _tag: Tag[nk_style_selectable] = Tag.materializeCStruct21Tag[nk_style_item, nk_style_item, nk_style_item, nk_style_item, nk_style_item, nk_style_item, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_color, nk_flags, Float, nk_vec2, nk_vec2, nk_vec2, nk_handle, CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]
    def apply()(using Zone): Ptr[nk_style_selectable] = scala.scalanative.unsafe.alloc[nk_style_selectable](1)
    def apply(normal: nk_style_item, hover: nk_style_item, pressed: nk_style_item, normal_active: nk_style_item, hover_active: nk_style_item, pressed_active: nk_style_item, text_normal: nk_color, text_hover: nk_color, text_pressed: nk_color, text_normal_active: nk_color, text_hover_active: nk_color, text_pressed_active: nk_color, text_background: nk_color, text_alignment: nk_flags, rounding: Float, padding: nk_vec2, touch_padding: nk_vec2, image_padding: nk_vec2, userdata: nk_handle, draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit])(using Zone): Ptr[nk_style_selectable] = 
      val ____ptr = apply()
      (!____ptr).normal = normal
      (!____ptr).hover = hover
      (!____ptr).pressed = pressed
      (!____ptr).normal_active = normal_active
      (!____ptr).hover_active = hover_active
      (!____ptr).pressed_active = pressed_active
      (!____ptr).text_normal = text_normal
      (!____ptr).text_hover = text_hover
      (!____ptr).text_pressed = text_pressed
      (!____ptr).text_normal_active = text_normal_active
      (!____ptr).text_hover_active = text_hover_active
      (!____ptr).text_pressed_active = text_pressed_active
      (!____ptr).text_background = text_background
      (!____ptr).text_alignment = text_alignment
      (!____ptr).rounding = rounding
      (!____ptr).padding = padding
      (!____ptr).touch_padding = touch_padding
      (!____ptr).image_padding = image_padding
      (!____ptr).userdata = userdata
      (!____ptr).draw_begin = draw_begin
      (!____ptr).draw_end = draw_end
      ____ptr
    extension (struct: nk_style_selectable)
      def normal: nk_style_item = struct._1
      def normal_=(value: nk_style_item): Unit = !struct.at1 = value
      def hover: nk_style_item = struct._2
      def hover_=(value: nk_style_item): Unit = !struct.at2 = value
      def pressed: nk_style_item = struct._3
      def pressed_=(value: nk_style_item): Unit = !struct.at3 = value
      def normal_active: nk_style_item = struct._4
      def normal_active_=(value: nk_style_item): Unit = !struct.at4 = value
      def hover_active: nk_style_item = struct._5
      def hover_active_=(value: nk_style_item): Unit = !struct.at5 = value
      def pressed_active: nk_style_item = struct._6
      def pressed_active_=(value: nk_style_item): Unit = !struct.at6 = value
      def text_normal: nk_color = struct._7
      def text_normal_=(value: nk_color): Unit = !struct.at7 = value
      def text_hover: nk_color = struct._8
      def text_hover_=(value: nk_color): Unit = !struct.at8 = value
      def text_pressed: nk_color = struct._9
      def text_pressed_=(value: nk_color): Unit = !struct.at9 = value
      def text_normal_active: nk_color = struct._10
      def text_normal_active_=(value: nk_color): Unit = !struct.at10 = value
      def text_hover_active: nk_color = struct._11
      def text_hover_active_=(value: nk_color): Unit = !struct.at11 = value
      def text_pressed_active: nk_color = struct._12
      def text_pressed_active_=(value: nk_color): Unit = !struct.at12 = value
      def text_background: nk_color = struct._13
      def text_background_=(value: nk_color): Unit = !struct.at13 = value
      def text_alignment: nk_flags = struct._14
      def text_alignment_=(value: nk_flags): Unit = !struct.at14 = value
      def rounding: Float = struct._15
      def rounding_=(value: Float): Unit = !struct.at15 = value
      def padding: nk_vec2 = struct._16
      def padding_=(value: nk_vec2): Unit = !struct.at16 = value
      def touch_padding: nk_vec2 = struct._17
      def touch_padding_=(value: nk_vec2): Unit = !struct.at17 = value
      def image_padding: nk_vec2 = struct._18
      def image_padding_=(value: nk_vec2): Unit = !struct.at18 = value
      def userdata: nk_handle = struct._19
      def userdata_=(value: nk_handle): Unit = !struct.at19 = value
      def draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = struct._20
      def draw_begin_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at20 = value
      def draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = struct._21
      def draw_end_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at21 = value

  opaque type nk_style_slide = CStruct0
  object nk_style_slide:
    given _tag: Tag[nk_style_slide] = Tag.materializeCStruct0Tag

  opaque type nk_style_slider = CArray[Byte, Nat.Digit3[Nat._6, Nat._4, Nat._0]]
  object nk_style_slider:
    given _tag: Tag[nk_style_slider] = Tag.CArray[CChar, Nat.Digit3[Nat._6, Nat._4, Nat._0]](Tag.Byte, Tag.Digit3[Nat._6, Nat._4, Nat._0](Tag.Nat6, Tag.Nat4, Tag.Nat0))
    def apply()(using Zone): Ptr[nk_style_slider] = scala.scalanative.unsafe.alloc[nk_style_slider](1)
    def apply(normal: nk_style_item, hover: nk_style_item, active: nk_style_item, border_color: nk_color, bar_normal: nk_color, bar_hover: nk_color, bar_active: nk_color, bar_filled: nk_color, cursor_normal: nk_style_item, cursor_hover: nk_style_item, cursor_active: nk_style_item, border: Float, rounding: Float, bar_height: Float, padding: nk_vec2, spacing: nk_vec2, cursor_size: nk_vec2, show_buttons: CInt, inc_button: nk_style_button, dec_button: nk_style_button, inc_symbol: nk_symbol_type, dec_symbol: nk_symbol_type, userdata: nk_handle, draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit])(using Zone): Ptr[nk_style_slider] = 
      val ____ptr = apply()
      (!____ptr).normal = normal
      (!____ptr).hover = hover
      (!____ptr).active = active
      (!____ptr).border_color = border_color
      (!____ptr).bar_normal = bar_normal
      (!____ptr).bar_hover = bar_hover
      (!____ptr).bar_active = bar_active
      (!____ptr).bar_filled = bar_filled
      (!____ptr).cursor_normal = cursor_normal
      (!____ptr).cursor_hover = cursor_hover
      (!____ptr).cursor_active = cursor_active
      (!____ptr).border = border
      (!____ptr).rounding = rounding
      (!____ptr).bar_height = bar_height
      (!____ptr).padding = padding
      (!____ptr).spacing = spacing
      (!____ptr).cursor_size = cursor_size
      (!____ptr).show_buttons = show_buttons
      (!____ptr).inc_button = inc_button
      (!____ptr).dec_button = dec_button
      (!____ptr).inc_symbol = inc_symbol
      (!____ptr).dec_symbol = dec_symbol
      (!____ptr).userdata = userdata
      (!____ptr).draw_begin = draw_begin
      (!____ptr).draw_end = draw_end
      ____ptr
    extension (struct: nk_style_slider)
      def normal: nk_style_item = !struct.at(0).asInstanceOf[Ptr[nk_style_item]]
      def normal_=(value: nk_style_item): Unit = !struct.at(0).asInstanceOf[Ptr[nk_style_item]] = value
      def hover: nk_style_item = !struct.at(32).asInstanceOf[Ptr[nk_style_item]]
      def hover_=(value: nk_style_item): Unit = !struct.at(32).asInstanceOf[Ptr[nk_style_item]] = value
      def active: nk_style_item = !struct.at(64).asInstanceOf[Ptr[nk_style_item]]
      def active_=(value: nk_style_item): Unit = !struct.at(64).asInstanceOf[Ptr[nk_style_item]] = value
      def border_color: nk_color = !struct.at(96).asInstanceOf[Ptr[nk_color]]
      def border_color_=(value: nk_color): Unit = !struct.at(96).asInstanceOf[Ptr[nk_color]] = value
      def bar_normal: nk_color = !struct.at(100).asInstanceOf[Ptr[nk_color]]
      def bar_normal_=(value: nk_color): Unit = !struct.at(100).asInstanceOf[Ptr[nk_color]] = value
      def bar_hover: nk_color = !struct.at(104).asInstanceOf[Ptr[nk_color]]
      def bar_hover_=(value: nk_color): Unit = !struct.at(104).asInstanceOf[Ptr[nk_color]] = value
      def bar_active: nk_color = !struct.at(108).asInstanceOf[Ptr[nk_color]]
      def bar_active_=(value: nk_color): Unit = !struct.at(108).asInstanceOf[Ptr[nk_color]] = value
      def bar_filled: nk_color = !struct.at(112).asInstanceOf[Ptr[nk_color]]
      def bar_filled_=(value: nk_color): Unit = !struct.at(112).asInstanceOf[Ptr[nk_color]] = value
      def cursor_normal: nk_style_item = !struct.at(116).asInstanceOf[Ptr[nk_style_item]]
      def cursor_normal_=(value: nk_style_item): Unit = !struct.at(116).asInstanceOf[Ptr[nk_style_item]] = value
      def cursor_hover: nk_style_item = !struct.at(148).asInstanceOf[Ptr[nk_style_item]]
      def cursor_hover_=(value: nk_style_item): Unit = !struct.at(148).asInstanceOf[Ptr[nk_style_item]] = value
      def cursor_active: nk_style_item = !struct.at(180).asInstanceOf[Ptr[nk_style_item]]
      def cursor_active_=(value: nk_style_item): Unit = !struct.at(180).asInstanceOf[Ptr[nk_style_item]] = value
      def border: Float = !struct.at(212).asInstanceOf[Ptr[Float]]
      def border_=(value: Float): Unit = !struct.at(212).asInstanceOf[Ptr[Float]] = value
      def rounding: Float = !struct.at(216).asInstanceOf[Ptr[Float]]
      def rounding_=(value: Float): Unit = !struct.at(216).asInstanceOf[Ptr[Float]] = value
      def bar_height: Float = !struct.at(220).asInstanceOf[Ptr[Float]]
      def bar_height_=(value: Float): Unit = !struct.at(220).asInstanceOf[Ptr[Float]] = value
      def padding: nk_vec2 = !struct.at(224).asInstanceOf[Ptr[nk_vec2]]
      def padding_=(value: nk_vec2): Unit = !struct.at(224).asInstanceOf[Ptr[nk_vec2]] = value
      def spacing: nk_vec2 = !struct.at(232).asInstanceOf[Ptr[nk_vec2]]
      def spacing_=(value: nk_vec2): Unit = !struct.at(232).asInstanceOf[Ptr[nk_vec2]] = value
      def cursor_size: nk_vec2 = !struct.at(240).asInstanceOf[Ptr[nk_vec2]]
      def cursor_size_=(value: nk_vec2): Unit = !struct.at(240).asInstanceOf[Ptr[nk_vec2]] = value
      def show_buttons: CInt = !struct.at(248).asInstanceOf[Ptr[CInt]]
      def show_buttons_=(value: CInt): Unit = !struct.at(248).asInstanceOf[Ptr[CInt]] = value
      def inc_button: nk_style_button = !struct.at(256).asInstanceOf[Ptr[nk_style_button]]
      def inc_button_=(value: nk_style_button): Unit = !struct.at(256).asInstanceOf[Ptr[nk_style_button]] = value
      def dec_button: nk_style_button = !struct.at(432).asInstanceOf[Ptr[nk_style_button]]
      def dec_button_=(value: nk_style_button): Unit = !struct.at(432).asInstanceOf[Ptr[nk_style_button]] = value
      def inc_symbol: nk_symbol_type = !struct.at(608).asInstanceOf[Ptr[nk_symbol_type]]
      def inc_symbol_=(value: nk_symbol_type): Unit = !struct.at(608).asInstanceOf[Ptr[nk_symbol_type]] = value
      def dec_symbol: nk_symbol_type = !struct.at(612).asInstanceOf[Ptr[nk_symbol_type]]
      def dec_symbol_=(value: nk_symbol_type): Unit = !struct.at(612).asInstanceOf[Ptr[nk_symbol_type]] = value
      def userdata: nk_handle = !struct.at(616).asInstanceOf[Ptr[nk_handle]]
      def userdata_=(value: nk_handle): Unit = !struct.at(616).asInstanceOf[Ptr[nk_handle]] = value
      def draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = !struct.at(624).asInstanceOf[Ptr[CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]]
      def draw_begin_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at(624).asInstanceOf[Ptr[CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]] = value
      def draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = !struct.at(632).asInstanceOf[Ptr[CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]]
      def draw_end_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at(632).asInstanceOf[Ptr[CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]] = value

  opaque type nk_style_tab = CStruct14[nk_style_item, nk_color, nk_color, nk_style_button, nk_style_button, nk_style_button, nk_style_button, nk_symbol_type, nk_symbol_type, Float, Float, Float, nk_vec2, nk_vec2]
  object nk_style_tab:
    given _tag: Tag[nk_style_tab] = Tag.materializeCStruct14Tag[nk_style_item, nk_color, nk_color, nk_style_button, nk_style_button, nk_style_button, nk_style_button, nk_symbol_type, nk_symbol_type, Float, Float, Float, nk_vec2, nk_vec2]
    def apply()(using Zone): Ptr[nk_style_tab] = scala.scalanative.unsafe.alloc[nk_style_tab](1)
    def apply(background: nk_style_item, border_color: nk_color, text: nk_color, tab_maximize_button: nk_style_button, tab_minimize_button: nk_style_button, node_maximize_button: nk_style_button, node_minimize_button: nk_style_button, sym_minimize: nk_symbol_type, sym_maximize: nk_symbol_type, border: Float, rounding: Float, indent: Float, padding: nk_vec2, spacing: nk_vec2)(using Zone): Ptr[nk_style_tab] = 
      val ____ptr = apply()
      (!____ptr).background = background
      (!____ptr).border_color = border_color
      (!____ptr).text = text
      (!____ptr).tab_maximize_button = tab_maximize_button
      (!____ptr).tab_minimize_button = tab_minimize_button
      (!____ptr).node_maximize_button = node_maximize_button
      (!____ptr).node_minimize_button = node_minimize_button
      (!____ptr).sym_minimize = sym_minimize
      (!____ptr).sym_maximize = sym_maximize
      (!____ptr).border = border
      (!____ptr).rounding = rounding
      (!____ptr).indent = indent
      (!____ptr).padding = padding
      (!____ptr).spacing = spacing
      ____ptr
    extension (struct: nk_style_tab)
      def background: nk_style_item = struct._1
      def background_=(value: nk_style_item): Unit = !struct.at1 = value
      def border_color: nk_color = struct._2
      def border_color_=(value: nk_color): Unit = !struct.at2 = value
      def text: nk_color = struct._3
      def text_=(value: nk_color): Unit = !struct.at3 = value
      def tab_maximize_button: nk_style_button = struct._4
      def tab_maximize_button_=(value: nk_style_button): Unit = !struct.at4 = value
      def tab_minimize_button: nk_style_button = struct._5
      def tab_minimize_button_=(value: nk_style_button): Unit = !struct.at5 = value
      def node_maximize_button: nk_style_button = struct._6
      def node_maximize_button_=(value: nk_style_button): Unit = !struct.at6 = value
      def node_minimize_button: nk_style_button = struct._7
      def node_minimize_button_=(value: nk_style_button): Unit = !struct.at7 = value
      def sym_minimize: nk_symbol_type = struct._8
      def sym_minimize_=(value: nk_symbol_type): Unit = !struct.at8 = value
      def sym_maximize: nk_symbol_type = struct._9
      def sym_maximize_=(value: nk_symbol_type): Unit = !struct.at9 = value
      def border: Float = struct._10
      def border_=(value: Float): Unit = !struct.at10 = value
      def rounding: Float = struct._11
      def rounding_=(value: Float): Unit = !struct.at11 = value
      def indent: Float = struct._12
      def indent_=(value: Float): Unit = !struct.at12 = value
      def padding: nk_vec2 = struct._13
      def padding_=(value: nk_vec2): Unit = !struct.at13 = value
      def spacing: nk_vec2 = struct._14
      def spacing_=(value: nk_vec2): Unit = !struct.at14 = value

  opaque type nk_style_text = CStruct2[nk_color, nk_vec2]
  object nk_style_text:
    given _tag: Tag[nk_style_text] = Tag.materializeCStruct2Tag[nk_color, nk_vec2]
    def apply()(using Zone): Ptr[nk_style_text] = scala.scalanative.unsafe.alloc[nk_style_text](1)
    def apply(color: nk_color, padding: nk_vec2)(using Zone): Ptr[nk_style_text] = 
      val ____ptr = apply()
      (!____ptr).color = color
      (!____ptr).padding = padding
      ____ptr
    extension (struct: nk_style_text)
      def color: nk_color = struct._1
      def color_=(value: nk_color): Unit = !struct.at1 = value
      def padding: nk_vec2 = struct._2
      def padding_=(value: nk_vec2): Unit = !struct.at2 = value

  opaque type nk_style_toggle = CStruct18[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_style_item, nk_style_item, nk_color, nk_color, nk_color, nk_color, nk_flags, nk_vec2, nk_vec2, Float, Float, nk_handle, CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]
  object nk_style_toggle:
    given _tag: Tag[nk_style_toggle] = Tag.materializeCStruct18Tag[nk_style_item, nk_style_item, nk_style_item, nk_color, nk_style_item, nk_style_item, nk_color, nk_color, nk_color, nk_color, nk_flags, nk_vec2, nk_vec2, Float, Float, nk_handle, CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]]
    def apply()(using Zone): Ptr[nk_style_toggle] = scala.scalanative.unsafe.alloc[nk_style_toggle](1)
    def apply(normal: nk_style_item, hover: nk_style_item, active: nk_style_item, border_color: nk_color, cursor_normal: nk_style_item, cursor_hover: nk_style_item, text_normal: nk_color, text_hover: nk_color, text_active: nk_color, text_background: nk_color, text_alignment: nk_flags, padding: nk_vec2, touch_padding: nk_vec2, spacing: Float, border: Float, userdata: nk_handle, draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit], draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit])(using Zone): Ptr[nk_style_toggle] = 
      val ____ptr = apply()
      (!____ptr).normal = normal
      (!____ptr).hover = hover
      (!____ptr).active = active
      (!____ptr).border_color = border_color
      (!____ptr).cursor_normal = cursor_normal
      (!____ptr).cursor_hover = cursor_hover
      (!____ptr).text_normal = text_normal
      (!____ptr).text_hover = text_hover
      (!____ptr).text_active = text_active
      (!____ptr).text_background = text_background
      (!____ptr).text_alignment = text_alignment
      (!____ptr).padding = padding
      (!____ptr).touch_padding = touch_padding
      (!____ptr).spacing = spacing
      (!____ptr).border = border
      (!____ptr).userdata = userdata
      (!____ptr).draw_begin = draw_begin
      (!____ptr).draw_end = draw_end
      ____ptr
    extension (struct: nk_style_toggle)
      def normal: nk_style_item = struct._1
      def normal_=(value: nk_style_item): Unit = !struct.at1 = value
      def hover: nk_style_item = struct._2
      def hover_=(value: nk_style_item): Unit = !struct.at2 = value
      def active: nk_style_item = struct._3
      def active_=(value: nk_style_item): Unit = !struct.at3 = value
      def border_color: nk_color = struct._4
      def border_color_=(value: nk_color): Unit = !struct.at4 = value
      def cursor_normal: nk_style_item = struct._5
      def cursor_normal_=(value: nk_style_item): Unit = !struct.at5 = value
      def cursor_hover: nk_style_item = struct._6
      def cursor_hover_=(value: nk_style_item): Unit = !struct.at6 = value
      def text_normal: nk_color = struct._7
      def text_normal_=(value: nk_color): Unit = !struct.at7 = value
      def text_hover: nk_color = struct._8
      def text_hover_=(value: nk_color): Unit = !struct.at8 = value
      def text_active: nk_color = struct._9
      def text_active_=(value: nk_color): Unit = !struct.at9 = value
      def text_background: nk_color = struct._10
      def text_background_=(value: nk_color): Unit = !struct.at10 = value
      def text_alignment: nk_flags = struct._11
      def text_alignment_=(value: nk_flags): Unit = !struct.at11 = value
      def padding: nk_vec2 = struct._12
      def padding_=(value: nk_vec2): Unit = !struct.at12 = value
      def touch_padding: nk_vec2 = struct._13
      def touch_padding_=(value: nk_vec2): Unit = !struct.at13 = value
      def spacing: Float = struct._14
      def spacing_=(value: Float): Unit = !struct.at14 = value
      def border: Float = struct._15
      def border_=(value: Float): Unit = !struct.at15 = value
      def userdata: nk_handle = struct._16
      def userdata_=(value: nk_handle): Unit = !struct.at16 = value
      def draw_begin: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = struct._17
      def draw_begin_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at17 = value
      def draw_end: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit] = struct._18
      def draw_end_=(value: CFuncPtr2[Ptr[nk_command_buffer], nk_handle, Unit]): Unit = !struct.at18 = value

  opaque type nk_style_window = CArray[Byte, Nat.Digit3[Nat._7, Nat._2, Nat._0]]
  object nk_style_window:
    given _tag: Tag[nk_style_window] = Tag.CArray[CChar, Nat.Digit3[Nat._7, Nat._2, Nat._0]](Tag.Byte, Tag.Digit3[Nat._7, Nat._2, Nat._0](Tag.Nat7, Tag.Nat2, Tag.Nat0))
    def apply()(using Zone): Ptr[nk_style_window] = scala.scalanative.unsafe.alloc[nk_style_window](1)
    def apply(header: nk_style_window_header, fixed_background: nk_style_item, background: nk_color, border_color: nk_color, popup_border_color: nk_color, combo_border_color: nk_color, contextual_border_color: nk_color, menu_border_color: nk_color, group_border_color: nk_color, tooltip_border_color: nk_color, scaler: nk_style_item, border: Float, combo_border: Float, contextual_border: Float, menu_border: Float, group_border: Float, tooltip_border: Float, popup_border: Float, min_row_height_padding: Float, rounding: Float, spacing: nk_vec2, scrollbar_size: nk_vec2, min_size: nk_vec2, padding: nk_vec2, group_padding: nk_vec2, popup_padding: nk_vec2, combo_padding: nk_vec2, contextual_padding: nk_vec2, menu_padding: nk_vec2, tooltip_padding: nk_vec2)(using Zone): Ptr[nk_style_window] = 
      val ____ptr = apply()
      (!____ptr).header = header
      (!____ptr).fixed_background = fixed_background
      (!____ptr).background = background
      (!____ptr).border_color = border_color
      (!____ptr).popup_border_color = popup_border_color
      (!____ptr).combo_border_color = combo_border_color
      (!____ptr).contextual_border_color = contextual_border_color
      (!____ptr).menu_border_color = menu_border_color
      (!____ptr).group_border_color = group_border_color
      (!____ptr).tooltip_border_color = tooltip_border_color
      (!____ptr).scaler = scaler
      (!____ptr).border = border
      (!____ptr).combo_border = combo_border
      (!____ptr).contextual_border = contextual_border
      (!____ptr).menu_border = menu_border
      (!____ptr).group_border = group_border
      (!____ptr).tooltip_border = tooltip_border
      (!____ptr).popup_border = popup_border
      (!____ptr).min_row_height_padding = min_row_height_padding
      (!____ptr).rounding = rounding
      (!____ptr).spacing = spacing
      (!____ptr).scrollbar_size = scrollbar_size
      (!____ptr).min_size = min_size
      (!____ptr).padding = padding
      (!____ptr).group_padding = group_padding
      (!____ptr).popup_padding = popup_padding
      (!____ptr).combo_padding = combo_padding
      (!____ptr).contextual_padding = contextual_padding
      (!____ptr).menu_padding = menu_padding
      (!____ptr).tooltip_padding = tooltip_padding
      ____ptr
    extension (struct: nk_style_window)
      def header: nk_style_window_header = !struct.at(0).asInstanceOf[Ptr[nk_style_window_header]]
      def header_=(value: nk_style_window_header): Unit = !struct.at(0).asInstanceOf[Ptr[nk_style_window_header]] = value
      def fixed_background: nk_style_item = !struct.at(504).asInstanceOf[Ptr[nk_style_item]]
      def fixed_background_=(value: nk_style_item): Unit = !struct.at(504).asInstanceOf[Ptr[nk_style_item]] = value
      def background: nk_color = !struct.at(536).asInstanceOf[Ptr[nk_color]]
      def background_=(value: nk_color): Unit = !struct.at(536).asInstanceOf[Ptr[nk_color]] = value
      def border_color: nk_color = !struct.at(540).asInstanceOf[Ptr[nk_color]]
      def border_color_=(value: nk_color): Unit = !struct.at(540).asInstanceOf[Ptr[nk_color]] = value
      def popup_border_color: nk_color = !struct.at(544).asInstanceOf[Ptr[nk_color]]
      def popup_border_color_=(value: nk_color): Unit = !struct.at(544).asInstanceOf[Ptr[nk_color]] = value
      def combo_border_color: nk_color = !struct.at(548).asInstanceOf[Ptr[nk_color]]
      def combo_border_color_=(value: nk_color): Unit = !struct.at(548).asInstanceOf[Ptr[nk_color]] = value
      def contextual_border_color: nk_color = !struct.at(552).asInstanceOf[Ptr[nk_color]]
      def contextual_border_color_=(value: nk_color): Unit = !struct.at(552).asInstanceOf[Ptr[nk_color]] = value
      def menu_border_color: nk_color = !struct.at(556).asInstanceOf[Ptr[nk_color]]
      def menu_border_color_=(value: nk_color): Unit = !struct.at(556).asInstanceOf[Ptr[nk_color]] = value
      def group_border_color: nk_color = !struct.at(560).asInstanceOf[Ptr[nk_color]]
      def group_border_color_=(value: nk_color): Unit = !struct.at(560).asInstanceOf[Ptr[nk_color]] = value
      def tooltip_border_color: nk_color = !struct.at(564).asInstanceOf[Ptr[nk_color]]
      def tooltip_border_color_=(value: nk_color): Unit = !struct.at(564).asInstanceOf[Ptr[nk_color]] = value
      def scaler: nk_style_item = !struct.at(568).asInstanceOf[Ptr[nk_style_item]]
      def scaler_=(value: nk_style_item): Unit = !struct.at(568).asInstanceOf[Ptr[nk_style_item]] = value
      def border: Float = !struct.at(600).asInstanceOf[Ptr[Float]]
      def border_=(value: Float): Unit = !struct.at(600).asInstanceOf[Ptr[Float]] = value
      def combo_border: Float = !struct.at(604).asInstanceOf[Ptr[Float]]
      def combo_border_=(value: Float): Unit = !struct.at(604).asInstanceOf[Ptr[Float]] = value
      def contextual_border: Float = !struct.at(608).asInstanceOf[Ptr[Float]]
      def contextual_border_=(value: Float): Unit = !struct.at(608).asInstanceOf[Ptr[Float]] = value
      def menu_border: Float = !struct.at(612).asInstanceOf[Ptr[Float]]
      def menu_border_=(value: Float): Unit = !struct.at(612).asInstanceOf[Ptr[Float]] = value
      def group_border: Float = !struct.at(616).asInstanceOf[Ptr[Float]]
      def group_border_=(value: Float): Unit = !struct.at(616).asInstanceOf[Ptr[Float]] = value
      def tooltip_border: Float = !struct.at(620).asInstanceOf[Ptr[Float]]
      def tooltip_border_=(value: Float): Unit = !struct.at(620).asInstanceOf[Ptr[Float]] = value
      def popup_border: Float = !struct.at(624).asInstanceOf[Ptr[Float]]
      def popup_border_=(value: Float): Unit = !struct.at(624).asInstanceOf[Ptr[Float]] = value
      def min_row_height_padding: Float = !struct.at(628).asInstanceOf[Ptr[Float]]
      def min_row_height_padding_=(value: Float): Unit = !struct.at(628).asInstanceOf[Ptr[Float]] = value
      def rounding: Float = !struct.at(632).asInstanceOf[Ptr[Float]]
      def rounding_=(value: Float): Unit = !struct.at(632).asInstanceOf[Ptr[Float]] = value
      def spacing: nk_vec2 = !struct.at(636).asInstanceOf[Ptr[nk_vec2]]
      def spacing_=(value: nk_vec2): Unit = !struct.at(636).asInstanceOf[Ptr[nk_vec2]] = value
      def scrollbar_size: nk_vec2 = !struct.at(644).asInstanceOf[Ptr[nk_vec2]]
      def scrollbar_size_=(value: nk_vec2): Unit = !struct.at(644).asInstanceOf[Ptr[nk_vec2]] = value
      def min_size: nk_vec2 = !struct.at(652).asInstanceOf[Ptr[nk_vec2]]
      def min_size_=(value: nk_vec2): Unit = !struct.at(652).asInstanceOf[Ptr[nk_vec2]] = value
      def padding: nk_vec2 = !struct.at(660).asInstanceOf[Ptr[nk_vec2]]
      def padding_=(value: nk_vec2): Unit = !struct.at(660).asInstanceOf[Ptr[nk_vec2]] = value
      def group_padding: nk_vec2 = !struct.at(668).asInstanceOf[Ptr[nk_vec2]]
      def group_padding_=(value: nk_vec2): Unit = !struct.at(668).asInstanceOf[Ptr[nk_vec2]] = value
      def popup_padding: nk_vec2 = !struct.at(676).asInstanceOf[Ptr[nk_vec2]]
      def popup_padding_=(value: nk_vec2): Unit = !struct.at(676).asInstanceOf[Ptr[nk_vec2]] = value
      def combo_padding: nk_vec2 = !struct.at(684).asInstanceOf[Ptr[nk_vec2]]
      def combo_padding_=(value: nk_vec2): Unit = !struct.at(684).asInstanceOf[Ptr[nk_vec2]] = value
      def contextual_padding: nk_vec2 = !struct.at(692).asInstanceOf[Ptr[nk_vec2]]
      def contextual_padding_=(value: nk_vec2): Unit = !struct.at(692).asInstanceOf[Ptr[nk_vec2]] = value
      def menu_padding: nk_vec2 = !struct.at(700).asInstanceOf[Ptr[nk_vec2]]
      def menu_padding_=(value: nk_vec2): Unit = !struct.at(700).asInstanceOf[Ptr[nk_vec2]] = value
      def tooltip_padding: nk_vec2 = !struct.at(708).asInstanceOf[Ptr[nk_vec2]]
      def tooltip_padding_=(value: nk_vec2): Unit = !struct.at(708).asInstanceOf[Ptr[nk_vec2]] = value

  opaque type nk_style_window_header = CStruct15[nk_style_item, nk_style_item, nk_style_item, nk_style_button, nk_style_button, nk_symbol_type, nk_symbol_type, nk_symbol_type, nk_color, nk_color, nk_color, nk_style_header_align, nk_vec2, nk_vec2, nk_vec2]
  object nk_style_window_header:
    given _tag: Tag[nk_style_window_header] = Tag.materializeCStruct15Tag[nk_style_item, nk_style_item, nk_style_item, nk_style_button, nk_style_button, nk_symbol_type, nk_symbol_type, nk_symbol_type, nk_color, nk_color, nk_color, nk_style_header_align, nk_vec2, nk_vec2, nk_vec2]
    def apply()(using Zone): Ptr[nk_style_window_header] = scala.scalanative.unsafe.alloc[nk_style_window_header](1)
    def apply(normal: nk_style_item, hover: nk_style_item, active: nk_style_item, close_button: nk_style_button, minimize_button: nk_style_button, close_symbol: nk_symbol_type, minimize_symbol: nk_symbol_type, maximize_symbol: nk_symbol_type, label_normal: nk_color, label_hover: nk_color, label_active: nk_color, align: nk_style_header_align, padding: nk_vec2, label_padding: nk_vec2, spacing: nk_vec2)(using Zone): Ptr[nk_style_window_header] = 
      val ____ptr = apply()
      (!____ptr).normal = normal
      (!____ptr).hover = hover
      (!____ptr).active = active
      (!____ptr).close_button = close_button
      (!____ptr).minimize_button = minimize_button
      (!____ptr).close_symbol = close_symbol
      (!____ptr).minimize_symbol = minimize_symbol
      (!____ptr).maximize_symbol = maximize_symbol
      (!____ptr).label_normal = label_normal
      (!____ptr).label_hover = label_hover
      (!____ptr).label_active = label_active
      (!____ptr).align = align
      (!____ptr).padding = padding
      (!____ptr).label_padding = label_padding
      (!____ptr).spacing = spacing
      ____ptr
    extension (struct: nk_style_window_header)
      def normal: nk_style_item = struct._1
      def normal_=(value: nk_style_item): Unit = !struct.at1 = value
      def hover: nk_style_item = struct._2
      def hover_=(value: nk_style_item): Unit = !struct.at2 = value
      def active: nk_style_item = struct._3
      def active_=(value: nk_style_item): Unit = !struct.at3 = value
      def close_button: nk_style_button = struct._4
      def close_button_=(value: nk_style_button): Unit = !struct.at4 = value
      def minimize_button: nk_style_button = struct._5
      def minimize_button_=(value: nk_style_button): Unit = !struct.at5 = value
      def close_symbol: nk_symbol_type = struct._6
      def close_symbol_=(value: nk_symbol_type): Unit = !struct.at6 = value
      def minimize_symbol: nk_symbol_type = struct._7
      def minimize_symbol_=(value: nk_symbol_type): Unit = !struct.at7 = value
      def maximize_symbol: nk_symbol_type = struct._8
      def maximize_symbol_=(value: nk_symbol_type): Unit = !struct.at8 = value
      def label_normal: nk_color = struct._9
      def label_normal_=(value: nk_color): Unit = !struct.at9 = value
      def label_hover: nk_color = struct._10
      def label_hover_=(value: nk_color): Unit = !struct.at10 = value
      def label_active: nk_color = struct._11
      def label_active_=(value: nk_color): Unit = !struct.at11 = value
      def align: nk_style_header_align = struct._12
      def align_=(value: nk_style_header_align): Unit = !struct.at12 = value
      def padding: nk_vec2 = struct._13
      def padding_=(value: nk_vec2): Unit = !struct.at13 = value
      def label_padding: nk_vec2 = struct._14
      def label_padding_=(value: nk_vec2): Unit = !struct.at14 = value
      def spacing: nk_vec2 = struct._15
      def spacing_=(value: nk_vec2): Unit = !struct.at15 = value

  opaque type nk_table = CStruct6[CUnsignedInt, CUnsignedInt, CArray[nk_hash, Nat.Digit2[Nat._5, Nat._9]], CArray[nk_uint, Nat.Digit2[Nat._5, Nat._9]], Ptr[Byte], Ptr[Byte]]
  object nk_table:
    given _tag: Tag[nk_table] = Tag.materializeCStruct6Tag[CUnsignedInt, CUnsignedInt, CArray[nk_hash, Nat.Digit2[Nat._5, Nat._9]], CArray[nk_uint, Nat.Digit2[Nat._5, Nat._9]], Ptr[Byte], Ptr[Byte]]
    def apply()(using Zone): Ptr[nk_table] = scala.scalanative.unsafe.alloc[nk_table](1)
    def apply(seq: CUnsignedInt, size: CUnsignedInt, keys: CArray[nk_hash, Nat.Digit2[Nat._5, Nat._9]], values: CArray[nk_uint, Nat.Digit2[Nat._5, Nat._9]], next: Ptr[nk_table], prev: Ptr[nk_table])(using Zone): Ptr[nk_table] = 
      val ____ptr = apply()
      (!____ptr).seq = seq
      (!____ptr).size = size
      (!____ptr).keys = keys
      (!____ptr).values = values
      (!____ptr).next = next
      (!____ptr).prev = prev
      ____ptr
    extension (struct: nk_table)
      def seq: CUnsignedInt = struct._1
      def seq_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def size: CUnsignedInt = struct._2
      def size_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def keys: CArray[nk_hash, Nat.Digit2[Nat._5, Nat._9]] = struct._3
      def keys_=(value: CArray[nk_hash, Nat.Digit2[Nat._5, Nat._9]]): Unit = !struct.at3 = value
      def values: CArray[nk_uint, Nat.Digit2[Nat._5, Nat._9]] = struct._4
      def values_=(value: CArray[nk_uint, Nat.Digit2[Nat._5, Nat._9]]): Unit = !struct.at4 = value
      def next: Ptr[nk_table] = struct._5.asInstanceOf[Ptr[nk_table]]
      def next_=(value: Ptr[nk_table]): Unit = !struct.at5 = value.asInstanceOf[Ptr[Byte]]
      def prev: Ptr[nk_table] = struct._6.asInstanceOf[Ptr[nk_table]]
      def prev_=(value: Ptr[nk_table]): Unit = !struct.at6 = value.asInstanceOf[Ptr[Byte]]

  opaque type nk_text = CStruct3[nk_vec2, nk_color, nk_color]
  object nk_text:
    given _tag: Tag[nk_text] = Tag.materializeCStruct3Tag[nk_vec2, nk_color, nk_color]
    def apply()(using Zone): Ptr[nk_text] = scala.scalanative.unsafe.alloc[nk_text](1)
    def apply(padding: nk_vec2, background: nk_color, text: nk_color)(using Zone): Ptr[nk_text] = 
      val ____ptr = apply()
      (!____ptr).padding = padding
      (!____ptr).background = background
      (!____ptr).text = text
      ____ptr
    extension (struct: nk_text)
      def padding: nk_vec2 = struct._1
      def padding_=(value: nk_vec2): Unit = !struct.at1 = value
      def background: nk_color = struct._2
      def background_=(value: nk_color): Unit = !struct.at2 = value
      def text: nk_color = struct._3
      def text_=(value: nk_color): Unit = !struct.at3 = value

  opaque type nk_text_edit = CStruct16[nk_clipboard, nk_str, Ptr[Byte], nk_vec2, CInt, CInt, CInt, CUnsignedChar, CUnsignedChar, CUnsignedChar, CUnsignedChar, CUnsignedChar, CUnsignedChar, CUnsignedChar, Float, nk_text_undo_state]
  object nk_text_edit:
    given _tag: Tag[nk_text_edit] = Tag.materializeCStruct16Tag[nk_clipboard, nk_str, Ptr[Byte], nk_vec2, CInt, CInt, CInt, CUnsignedChar, CUnsignedChar, CUnsignedChar, CUnsignedChar, CUnsignedChar, CUnsignedChar, CUnsignedChar, Float, nk_text_undo_state]
    def apply()(using Zone): Ptr[nk_text_edit] = scala.scalanative.unsafe.alloc[nk_text_edit](1)
    def apply(clip: nk_clipboard, string: nk_str, filter: nk_plugin_filter, scrollbar: nk_vec2, cursor: CInt, select_start: CInt, select_end: CInt, mode: CUnsignedChar, cursor_at_end_of_line: CUnsignedChar, initialized: CUnsignedChar, has_preferred_x: CUnsignedChar, single_line: CUnsignedChar, active: CUnsignedChar, padding1: CUnsignedChar, preferred_x: Float, undo: nk_text_undo_state)(using Zone): Ptr[nk_text_edit] = 
      val ____ptr = apply()
      (!____ptr).clip = clip
      (!____ptr).string = string
      (!____ptr).filter = filter
      (!____ptr).scrollbar = scrollbar
      (!____ptr).cursor = cursor
      (!____ptr).select_start = select_start
      (!____ptr).select_end = select_end
      (!____ptr).mode = mode
      (!____ptr).cursor_at_end_of_line = cursor_at_end_of_line
      (!____ptr).initialized = initialized
      (!____ptr).has_preferred_x = has_preferred_x
      (!____ptr).single_line = single_line
      (!____ptr).active = active
      (!____ptr).padding1 = padding1
      (!____ptr).preferred_x = preferred_x
      (!____ptr).undo = undo
      ____ptr
    extension (struct: nk_text_edit)
      def clip: nk_clipboard = struct._1
      def clip_=(value: nk_clipboard): Unit = !struct.at1 = value
      def string: nk_str = struct._2
      def string_=(value: nk_str): Unit = !struct.at2 = value
      def filter: nk_plugin_filter = struct._3.asInstanceOf[nk_plugin_filter]
      def filter_=(value: nk_plugin_filter): Unit = !struct.at3 = value.asInstanceOf[Ptr[Byte]]
      def scrollbar: nk_vec2 = struct._4
      def scrollbar_=(value: nk_vec2): Unit = !struct.at4 = value
      def cursor: CInt = struct._5
      def cursor_=(value: CInt): Unit = !struct.at5 = value
      def select_start: CInt = struct._6
      def select_start_=(value: CInt): Unit = !struct.at6 = value
      def select_end: CInt = struct._7
      def select_end_=(value: CInt): Unit = !struct.at7 = value
      def mode: CUnsignedChar = struct._8
      def mode_=(value: CUnsignedChar): Unit = !struct.at8 = value
      def cursor_at_end_of_line: CUnsignedChar = struct._9
      def cursor_at_end_of_line_=(value: CUnsignedChar): Unit = !struct.at9 = value
      def initialized: CUnsignedChar = struct._10
      def initialized_=(value: CUnsignedChar): Unit = !struct.at10 = value
      def has_preferred_x: CUnsignedChar = struct._11
      def has_preferred_x_=(value: CUnsignedChar): Unit = !struct.at11 = value
      def single_line: CUnsignedChar = struct._12
      def single_line_=(value: CUnsignedChar): Unit = !struct.at12 = value
      def active: CUnsignedChar = struct._13
      def active_=(value: CUnsignedChar): Unit = !struct.at13 = value
      def padding1: CUnsignedChar = struct._14
      def padding1_=(value: CUnsignedChar): Unit = !struct.at14 = value
      def preferred_x: Float = struct._15
      def preferred_x_=(value: Float): Unit = !struct.at15 = value
      def undo: nk_text_undo_state = struct._16
      def undo_=(value: nk_text_undo_state): Unit = !struct.at16 = value

  opaque type nk_text_edit_row = CStruct6[Float, Float, Float, Float, Float, CInt]
  object nk_text_edit_row:
    given _tag: Tag[nk_text_edit_row] = Tag.materializeCStruct6Tag[Float, Float, Float, Float, Float, CInt]
    def apply()(using Zone): Ptr[nk_text_edit_row] = scala.scalanative.unsafe.alloc[nk_text_edit_row](1)
    def apply(x0: Float, x1: Float, baseline_y_delta: Float, ymin: Float, ymax: Float, num_chars: CInt)(using Zone): Ptr[nk_text_edit_row] = 
      val ____ptr = apply()
      (!____ptr).x0 = x0
      (!____ptr).x1 = x1
      (!____ptr).baseline_y_delta = baseline_y_delta
      (!____ptr).ymin = ymin
      (!____ptr).ymax = ymax
      (!____ptr).num_chars = num_chars
      ____ptr
    extension (struct: nk_text_edit_row)
      def x0: Float = struct._1
      def x0_=(value: Float): Unit = !struct.at1 = value
      def x1: Float = struct._2
      def x1_=(value: Float): Unit = !struct.at2 = value
      def baseline_y_delta: Float = struct._3
      def baseline_y_delta_=(value: Float): Unit = !struct.at3 = value
      def ymin: Float = struct._4
      def ymin_=(value: Float): Unit = !struct.at4 = value
      def ymax: Float = struct._5
      def ymax_=(value: Float): Unit = !struct.at5 = value
      def num_chars: CInt = struct._6
      def num_chars_=(value: CInt): Unit = !struct.at6 = value

  opaque type nk_text_find = CStruct6[Float, Float, Float, CInt, CInt, CInt]
  object nk_text_find:
    given _tag: Tag[nk_text_find] = Tag.materializeCStruct6Tag[Float, Float, Float, CInt, CInt, CInt]
    def apply()(using Zone): Ptr[nk_text_find] = scala.scalanative.unsafe.alloc[nk_text_find](1)
    def apply(x: Float, y: Float, height: Float, first_char: CInt, length: CInt, prev_first: CInt)(using Zone): Ptr[nk_text_find] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).height = height
      (!____ptr).first_char = first_char
      (!____ptr).length = length
      (!____ptr).prev_first = prev_first
      ____ptr
    extension (struct: nk_text_find)
      def x: Float = struct._1
      def x_=(value: Float): Unit = !struct.at1 = value
      def y: Float = struct._2
      def y_=(value: Float): Unit = !struct.at2 = value
      def height: Float = struct._3
      def height_=(value: Float): Unit = !struct.at3 = value
      def first_char: CInt = struct._4
      def first_char_=(value: CInt): Unit = !struct.at4 = value
      def length: CInt = struct._5
      def length_=(value: CInt): Unit = !struct.at5 = value
      def prev_first: CInt = struct._6
      def prev_first_=(value: CInt): Unit = !struct.at6 = value

  opaque type nk_text_undo_record = CStruct4[CInt, CShort, CShort, CShort]
  object nk_text_undo_record:
    given _tag: Tag[nk_text_undo_record] = Tag.materializeCStruct4Tag[CInt, CShort, CShort, CShort]
    def apply()(using Zone): Ptr[nk_text_undo_record] = scala.scalanative.unsafe.alloc[nk_text_undo_record](1)
    def apply(where: CInt, insert_length: CShort, delete_length: CShort, char_storage: CShort)(using Zone): Ptr[nk_text_undo_record] = 
      val ____ptr = apply()
      (!____ptr).where = where
      (!____ptr).insert_length = insert_length
      (!____ptr).delete_length = delete_length
      (!____ptr).char_storage = char_storage
      ____ptr
    extension (struct: nk_text_undo_record)
      def where: CInt = struct._1
      def where_=(value: CInt): Unit = !struct.at1 = value
      def insert_length: CShort = struct._2
      def insert_length_=(value: CShort): Unit = !struct.at2 = value
      def delete_length: CShort = struct._3
      def delete_length_=(value: CShort): Unit = !struct.at3 = value
      def char_storage: CShort = struct._4
      def char_storage_=(value: CShort): Unit = !struct.at4 = value

  opaque type nk_text_undo_state = CStruct6[CArray[nk_text_undo_record, Nat.Digit2[Nat._9, Nat._9]], CArray[nk_rune, Nat.Digit3[Nat._9, Nat._9, Nat._9]], CShort, CShort, CShort, CShort]
  object nk_text_undo_state:
    given _tag: Tag[nk_text_undo_state] = Tag.materializeCStruct6Tag[CArray[nk_text_undo_record, Nat.Digit2[Nat._9, Nat._9]], CArray[nk_rune, Nat.Digit3[Nat._9, Nat._9, Nat._9]], CShort, CShort, CShort, CShort]
    def apply()(using Zone): Ptr[nk_text_undo_state] = scala.scalanative.unsafe.alloc[nk_text_undo_state](1)
    def apply(undo_rec: CArray[nk_text_undo_record, Nat.Digit2[Nat._9, Nat._9]], undo_char: CArray[nk_rune, Nat.Digit3[Nat._9, Nat._9, Nat._9]], undo_point: CShort, redo_point: CShort, undo_char_point: CShort, redo_char_point: CShort)(using Zone): Ptr[nk_text_undo_state] = 
      val ____ptr = apply()
      (!____ptr).undo_rec = undo_rec
      (!____ptr).undo_char = undo_char
      (!____ptr).undo_point = undo_point
      (!____ptr).redo_point = redo_point
      (!____ptr).undo_char_point = undo_char_point
      (!____ptr).redo_char_point = redo_char_point
      ____ptr
    extension (struct: nk_text_undo_state)
      def undo_rec: CArray[nk_text_undo_record, Nat.Digit2[Nat._9, Nat._9]] = struct._1
      def undo_rec_=(value: CArray[nk_text_undo_record, Nat.Digit2[Nat._9, Nat._9]]): Unit = !struct.at1 = value
      def undo_char: CArray[nk_rune, Nat.Digit3[Nat._9, Nat._9, Nat._9]] = struct._2
      def undo_char_=(value: CArray[nk_rune, Nat.Digit3[Nat._9, Nat._9, Nat._9]]): Unit = !struct.at2 = value
      def undo_point: CShort = struct._3
      def undo_point_=(value: CShort): Unit = !struct.at3 = value
      def redo_point: CShort = struct._4
      def redo_point_=(value: CShort): Unit = !struct.at4 = value
      def undo_char_point: CShort = struct._5
      def undo_char_point_=(value: CShort): Unit = !struct.at5 = value
      def redo_char_point: CShort = struct._6
      def redo_char_point_=(value: CShort): Unit = !struct.at6 = value

  opaque type nk_user_font = CStruct3[nk_handle, Float, nk_text_width_f]
  object nk_user_font:
    given _tag: Tag[nk_user_font] = Tag.materializeCStruct3Tag[nk_handle, Float, nk_text_width_f]
    def apply()(using Zone): Ptr[nk_user_font] = scala.scalanative.unsafe.alloc[nk_user_font](1)
    def apply(userdata: nk_handle, height: Float, width: nk_text_width_f)(using Zone): Ptr[nk_user_font] = 
      val ____ptr = apply()
      (!____ptr).userdata = userdata
      (!____ptr).height = height
      (!____ptr).width = width
      ____ptr
    extension (struct: nk_user_font)
      def userdata: nk_handle = struct._1
      def userdata_=(value: nk_handle): Unit = !struct.at1 = value
      def height: Float = struct._2
      def height_=(value: Float): Unit = !struct.at2 = value
      def width: nk_text_width_f = struct._3
      def width_=(value: nk_text_width_f): Unit = !struct.at3 = value

  opaque type nk_user_font_glyph = CStruct0
  object nk_user_font_glyph:
    given _tag: Tag[nk_user_font_glyph] = Tag.materializeCStruct0Tag

  opaque type nk_vec2 = CStruct2[Float, Float]
  object nk_vec2:
    given _tag: Tag[nk_vec2] = Tag.materializeCStruct2Tag[Float, Float]
    def apply()(using Zone): Ptr[nk_vec2] = scala.scalanative.unsafe.alloc[nk_vec2](1)
    def apply(x: Float, y: Float)(using Zone): Ptr[nk_vec2] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      ____ptr
    extension (struct: nk_vec2)
      def x: Float = struct._1
      def x_=(value: Float): Unit = !struct.at1 = value
      def y: Float = struct._2
      def y_=(value: Float): Unit = !struct.at2 = value

  opaque type nk_vec2i = CStruct2[CShort, CShort]
  object nk_vec2i:
    given _tag: Tag[nk_vec2i] = Tag.materializeCStruct2Tag[CShort, CShort]
    def apply()(using Zone): Ptr[nk_vec2i] = scala.scalanative.unsafe.alloc[nk_vec2i](1)
    def apply(x: CShort, y: CShort)(using Zone): Ptr[nk_vec2i] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      ____ptr
    extension (struct: nk_vec2i)
      def x: CShort = struct._1
      def x_=(value: CShort): Unit = !struct.at1 = value
      def y: CShort = struct._2
      def y_=(value: CShort): Unit = !struct.at2 = value

  opaque type nk_window = CStruct18[CUnsignedInt, nk_hash, CArray[CChar, Nat.Digit2[Nat._6, Nat._4]], nk_flags, nk_rect, nk_scroll, nk_command_buffer, Ptr[Byte], Float, nk_property_state, nk_popup_state, nk_edit_state, CUnsignedInt, Ptr[Byte], CUnsignedInt, Ptr[Byte], Ptr[Byte], Ptr[Byte]]
  object nk_window:
    given _tag: Tag[nk_window] = Tag.materializeCStruct18Tag[CUnsignedInt, nk_hash, CArray[CChar, Nat.Digit2[Nat._6, Nat._4]], nk_flags, nk_rect, nk_scroll, nk_command_buffer, Ptr[Byte], Float, nk_property_state, nk_popup_state, nk_edit_state, CUnsignedInt, Ptr[Byte], CUnsignedInt, Ptr[Byte], Ptr[Byte], Ptr[Byte]]
    def apply()(using Zone): Ptr[nk_window] = scala.scalanative.unsafe.alloc[nk_window](1)
    def apply(seq: CUnsignedInt, name: nk_hash, name_string: CArray[CChar, Nat.Digit2[Nat._6, Nat._4]], flags: nk_flags, bounds: nk_rect, scrollbar: nk_scroll, buffer: nk_command_buffer, layout: Ptr[nk_panel], scrollbar_hiding_timer: Float, property: nk_property_state, popup: nk_popup_state, edit: nk_edit_state, scrolled: CUnsignedInt, tables: Ptr[nk_table], table_count: CUnsignedInt, next: Ptr[nk_window], prev: Ptr[nk_window], parent: Ptr[nk_window])(using Zone): Ptr[nk_window] = 
      val ____ptr = apply()
      (!____ptr).seq = seq
      (!____ptr).name = name
      (!____ptr).name_string = name_string
      (!____ptr).flags = flags
      (!____ptr).bounds = bounds
      (!____ptr).scrollbar = scrollbar
      (!____ptr).buffer = buffer
      (!____ptr).layout = layout
      (!____ptr).scrollbar_hiding_timer = scrollbar_hiding_timer
      (!____ptr).property = property
      (!____ptr).popup = popup
      (!____ptr).edit = edit
      (!____ptr).scrolled = scrolled
      (!____ptr).tables = tables
      (!____ptr).table_count = table_count
      (!____ptr).next = next
      (!____ptr).prev = prev
      (!____ptr).parent = parent
      ____ptr
    extension (struct: nk_window)
      def seq: CUnsignedInt = struct._1
      def seq_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def name: nk_hash = struct._2
      def name_=(value: nk_hash): Unit = !struct.at2 = value
      def name_string: CArray[CChar, Nat.Digit2[Nat._6, Nat._4]] = struct._3
      def name_string_=(value: CArray[CChar, Nat.Digit2[Nat._6, Nat._4]]): Unit = !struct.at3 = value
      def flags: nk_flags = struct._4
      def flags_=(value: nk_flags): Unit = !struct.at4 = value
      def bounds: nk_rect = struct._5
      def bounds_=(value: nk_rect): Unit = !struct.at5 = value
      def scrollbar: nk_scroll = struct._6
      def scrollbar_=(value: nk_scroll): Unit = !struct.at6 = value
      def buffer: nk_command_buffer = struct._7
      def buffer_=(value: nk_command_buffer): Unit = !struct.at7 = value
      def layout: Ptr[nk_panel] = struct._8.asInstanceOf[Ptr[nk_panel]]
      def layout_=(value: Ptr[nk_panel]): Unit = !struct.at8 = value.asInstanceOf[Ptr[Byte]]
      def scrollbar_hiding_timer: Float = struct._9
      def scrollbar_hiding_timer_=(value: Float): Unit = !struct.at9 = value
      def property: nk_property_state = struct._10
      def property_=(value: nk_property_state): Unit = !struct.at10 = value
      def popup: nk_popup_state = struct._11
      def popup_=(value: nk_popup_state): Unit = !struct.at11 = value
      def edit: nk_edit_state = struct._12
      def edit_=(value: nk_edit_state): Unit = !struct.at12 = value
      def scrolled: CUnsignedInt = struct._13
      def scrolled_=(value: CUnsignedInt): Unit = !struct.at13 = value
      def tables: Ptr[nk_table] = struct._14.asInstanceOf[Ptr[nk_table]]
      def tables_=(value: Ptr[nk_table]): Unit = !struct.at14 = value.asInstanceOf[Ptr[Byte]]
      def table_count: CUnsignedInt = struct._15
      def table_count_=(value: CUnsignedInt): Unit = !struct.at15 = value
      def next: Ptr[nk_window] = struct._16.asInstanceOf[Ptr[nk_window]]
      def next_=(value: Ptr[nk_window]): Unit = !struct.at16 = value.asInstanceOf[Ptr[Byte]]
      def prev: Ptr[nk_window] = struct._17.asInstanceOf[Ptr[nk_window]]
      def prev_=(value: Ptr[nk_window]): Unit = !struct.at17 = value.asInstanceOf[Ptr[Byte]]
      def parent: Ptr[nk_window] = struct._18.asInstanceOf[Ptr[nk_window]]
      def parent_=(value: Ptr[nk_window]): Unit = !struct.at18 = value.asInstanceOf[Ptr[Byte]]

  opaque type stbrp_context = CStruct9[CInt, CInt, CInt, CInt, CInt, CInt, Ptr[Byte], Ptr[Byte], CArray[stbrp_node, Nat._2]]
  object stbrp_context:
    given _tag: Tag[stbrp_context] = Tag.materializeCStruct9Tag[CInt, CInt, CInt, CInt, CInt, CInt, Ptr[Byte], Ptr[Byte], CArray[stbrp_node, Nat._2]]
    def apply()(using Zone): Ptr[stbrp_context] = scala.scalanative.unsafe.alloc[stbrp_context](1)
    def apply(width: CInt, height: CInt, align: CInt, init_mode: CInt, heuristic: CInt, num_nodes: CInt, active_head: Ptr[stbrp_node], free_head: Ptr[stbrp_node], extra: CArray[stbrp_node, Nat._2])(using Zone): Ptr[stbrp_context] = 
      val ____ptr = apply()
      (!____ptr).width = width
      (!____ptr).height = height
      (!____ptr).align = align
      (!____ptr).init_mode = init_mode
      (!____ptr).heuristic = heuristic
      (!____ptr).num_nodes = num_nodes
      (!____ptr).active_head = active_head
      (!____ptr).free_head = free_head
      (!____ptr).extra = extra
      ____ptr
    extension (struct: stbrp_context)
      def width: CInt = struct._1
      def width_=(value: CInt): Unit = !struct.at1 = value
      def height: CInt = struct._2
      def height_=(value: CInt): Unit = !struct.at2 = value
      def align: CInt = struct._3
      def align_=(value: CInt): Unit = !struct.at3 = value
      def init_mode: CInt = struct._4
      def init_mode_=(value: CInt): Unit = !struct.at4 = value
      def heuristic: CInt = struct._5
      def heuristic_=(value: CInt): Unit = !struct.at5 = value
      def num_nodes: CInt = struct._6
      def num_nodes_=(value: CInt): Unit = !struct.at6 = value
      def active_head: Ptr[stbrp_node] = struct._7.asInstanceOf[Ptr[stbrp_node]]
      def active_head_=(value: Ptr[stbrp_node]): Unit = !struct.at7 = value.asInstanceOf[Ptr[Byte]]
      def free_head: Ptr[stbrp_node] = struct._8.asInstanceOf[Ptr[stbrp_node]]
      def free_head_=(value: Ptr[stbrp_node]): Unit = !struct.at8 = value.asInstanceOf[Ptr[Byte]]
      def extra: CArray[stbrp_node, Nat._2] = struct._9
      def extra_=(value: CArray[stbrp_node, Nat._2]): Unit = !struct.at9 = value

  opaque type stbrp_node = CStruct3[stbrp_coord, stbrp_coord, Ptr[Byte]]
  object stbrp_node:
    given _tag: Tag[stbrp_node] = Tag.materializeCStruct3Tag[stbrp_coord, stbrp_coord, Ptr[Byte]]
    def apply()(using Zone): Ptr[stbrp_node] = scala.scalanative.unsafe.alloc[stbrp_node](1)
    def apply(x: stbrp_coord, y: stbrp_coord, next: Ptr[stbrp_node])(using Zone): Ptr[stbrp_node] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).next = next
      ____ptr
    extension (struct: stbrp_node)
      def x: stbrp_coord = struct._1
      def x_=(value: stbrp_coord): Unit = !struct.at1 = value
      def y: stbrp_coord = struct._2
      def y_=(value: stbrp_coord): Unit = !struct.at2 = value
      def next: Ptr[stbrp_node] = struct._3.asInstanceOf[Ptr[stbrp_node]]
      def next_=(value: Ptr[stbrp_node]): Unit = !struct.at3 = value.asInstanceOf[Ptr[Byte]]

  opaque type stbrp_rect = CStruct6[CInt, stbrp_coord, stbrp_coord, stbrp_coord, stbrp_coord, CInt]
  object stbrp_rect:
    given _tag: Tag[stbrp_rect] = Tag.materializeCStruct6Tag[CInt, stbrp_coord, stbrp_coord, stbrp_coord, stbrp_coord, CInt]
    def apply()(using Zone): Ptr[stbrp_rect] = scala.scalanative.unsafe.alloc[stbrp_rect](1)
    def apply(id: CInt, w: stbrp_coord, h: stbrp_coord, x: stbrp_coord, y: stbrp_coord, was_packed: CInt)(using Zone): Ptr[stbrp_rect] = 
      val ____ptr = apply()
      (!____ptr).id = id
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).was_packed = was_packed
      ____ptr
    extension (struct: stbrp_rect)
      def id: CInt = struct._1
      def id_=(value: CInt): Unit = !struct.at1 = value
      def w: stbrp_coord = struct._2
      def w_=(value: stbrp_coord): Unit = !struct.at2 = value
      def h: stbrp_coord = struct._3
      def h_=(value: stbrp_coord): Unit = !struct.at3 = value
      def x: stbrp_coord = struct._4
      def x_=(value: stbrp_coord): Unit = !struct.at4 = value
      def y: stbrp_coord = struct._5
      def y_=(value: stbrp_coord): Unit = !struct.at5 = value
      def was_packed: CInt = struct._6
      def was_packed_=(value: CInt): Unit = !struct.at6 = value

  opaque type stbtt__bitmap = CStruct4[CInt, CInt, CInt, Ptr[CUnsignedChar]]
  object stbtt__bitmap:
    given _tag: Tag[stbtt__bitmap] = Tag.materializeCStruct4Tag[CInt, CInt, CInt, Ptr[CUnsignedChar]]
    def apply()(using Zone): Ptr[stbtt__bitmap] = scala.scalanative.unsafe.alloc[stbtt__bitmap](1)
    def apply(w: CInt, h: CInt, stride: CInt, pixels: Ptr[CUnsignedChar])(using Zone): Ptr[stbtt__bitmap] = 
      val ____ptr = apply()
      (!____ptr).w = w
      (!____ptr).h = h
      (!____ptr).stride = stride
      (!____ptr).pixels = pixels
      ____ptr
    extension (struct: stbtt__bitmap)
      def w: CInt = struct._1
      def w_=(value: CInt): Unit = !struct.at1 = value
      def h: CInt = struct._2
      def h_=(value: CInt): Unit = !struct.at2 = value
      def stride: CInt = struct._3
      def stride_=(value: CInt): Unit = !struct.at3 = value
      def pixels: Ptr[CUnsignedChar] = struct._4
      def pixels_=(value: Ptr[CUnsignedChar]): Unit = !struct.at4 = value

  opaque type stbtt__buf = CStruct3[Ptr[CUnsignedChar], CInt, CInt]
  object stbtt__buf:
    given _tag: Tag[stbtt__buf] = Tag.materializeCStruct3Tag[Ptr[CUnsignedChar], CInt, CInt]
    def apply()(using Zone): Ptr[stbtt__buf] = scala.scalanative.unsafe.alloc[stbtt__buf](1)
    def apply(data: Ptr[CUnsignedChar], cursor: CInt, size: CInt)(using Zone): Ptr[stbtt__buf] = 
      val ____ptr = apply()
      (!____ptr).data = data
      (!____ptr).cursor = cursor
      (!____ptr).size = size
      ____ptr
    extension (struct: stbtt__buf)
      def data: Ptr[CUnsignedChar] = struct._1
      def data_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
      def cursor: CInt = struct._2
      def cursor_=(value: CInt): Unit = !struct.at2 = value
      def size: CInt = struct._3
      def size_=(value: CInt): Unit = !struct.at3 = value

  opaque type stbtt_aligned_quad = CStruct8[Float, Float, Float, Float, Float, Float, Float, Float]
  object stbtt_aligned_quad:
    given _tag: Tag[stbtt_aligned_quad] = Tag.materializeCStruct8Tag[Float, Float, Float, Float, Float, Float, Float, Float]
    def apply()(using Zone): Ptr[stbtt_aligned_quad] = scala.scalanative.unsafe.alloc[stbtt_aligned_quad](1)
    def apply(x0: Float, y0: Float, s0: Float, t0: Float, x1: Float, y1: Float, s1: Float, t1: Float)(using Zone): Ptr[stbtt_aligned_quad] = 
      val ____ptr = apply()
      (!____ptr).x0 = x0
      (!____ptr).y0 = y0
      (!____ptr).s0 = s0
      (!____ptr).t0 = t0
      (!____ptr).x1 = x1
      (!____ptr).y1 = y1
      (!____ptr).s1 = s1
      (!____ptr).t1 = t1
      ____ptr
    extension (struct: stbtt_aligned_quad)
      def x0: Float = struct._1
      def x0_=(value: Float): Unit = !struct.at1 = value
      def y0: Float = struct._2
      def y0_=(value: Float): Unit = !struct.at2 = value
      def s0: Float = struct._3
      def s0_=(value: Float): Unit = !struct.at3 = value
      def t0: Float = struct._4
      def t0_=(value: Float): Unit = !struct.at4 = value
      def x1: Float = struct._5
      def x1_=(value: Float): Unit = !struct.at5 = value
      def y1: Float = struct._6
      def y1_=(value: Float): Unit = !struct.at6 = value
      def s1: Float = struct._7
      def s1_=(value: Float): Unit = !struct.at7 = value
      def t1: Float = struct._8
      def t1_=(value: Float): Unit = !struct.at8 = value

  opaque type stbtt_bakedchar = CStruct7[CUnsignedShort, CUnsignedShort, CUnsignedShort, CUnsignedShort, Float, Float, Float]
  object stbtt_bakedchar:
    given _tag: Tag[stbtt_bakedchar] = Tag.materializeCStruct7Tag[CUnsignedShort, CUnsignedShort, CUnsignedShort, CUnsignedShort, Float, Float, Float]
    def apply()(using Zone): Ptr[stbtt_bakedchar] = scala.scalanative.unsafe.alloc[stbtt_bakedchar](1)
    def apply(x0: CUnsignedShort, y0: CUnsignedShort, x1: CUnsignedShort, y1: CUnsignedShort, xoff: Float, yoff: Float, xadvance: Float)(using Zone): Ptr[stbtt_bakedchar] = 
      val ____ptr = apply()
      (!____ptr).x0 = x0
      (!____ptr).y0 = y0
      (!____ptr).x1 = x1
      (!____ptr).y1 = y1
      (!____ptr).xoff = xoff
      (!____ptr).yoff = yoff
      (!____ptr).xadvance = xadvance
      ____ptr
    extension (struct: stbtt_bakedchar)
      def x0: CUnsignedShort = struct._1
      def x0_=(value: CUnsignedShort): Unit = !struct.at1 = value
      def y0: CUnsignedShort = struct._2
      def y0_=(value: CUnsignedShort): Unit = !struct.at2 = value
      def x1: CUnsignedShort = struct._3
      def x1_=(value: CUnsignedShort): Unit = !struct.at3 = value
      def y1: CUnsignedShort = struct._4
      def y1_=(value: CUnsignedShort): Unit = !struct.at4 = value
      def xoff: Float = struct._5
      def xoff_=(value: Float): Unit = !struct.at5 = value
      def yoff: Float = struct._6
      def yoff_=(value: Float): Unit = !struct.at6 = value
      def xadvance: Float = struct._7
      def xadvance_=(value: Float): Unit = !struct.at7 = value

  opaque type stbtt_fontinfo = CStruct20[Ptr[Byte], Ptr[CUnsignedChar], CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, stbtt__buf, stbtt__buf, stbtt__buf, stbtt__buf, stbtt__buf, stbtt__buf]
  object stbtt_fontinfo:
    given _tag: Tag[stbtt_fontinfo] = Tag.materializeCStruct20Tag[Ptr[Byte], Ptr[CUnsignedChar], CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, stbtt__buf, stbtt__buf, stbtt__buf, stbtt__buf, stbtt__buf, stbtt__buf]
    def apply()(using Zone): Ptr[stbtt_fontinfo] = scala.scalanative.unsafe.alloc[stbtt_fontinfo](1)
    def apply(userdata: Ptr[Byte], data: Ptr[CUnsignedChar], fontstart: CInt, numGlyphs: CInt, loca: CInt, head: CInt, glyf: CInt, hhea: CInt, hmtx: CInt, kern: CInt, gpos: CInt, svg: CInt, index_map: CInt, indexToLocFormat: CInt, cff: stbtt__buf, charstrings: stbtt__buf, gsubrs: stbtt__buf, subrs: stbtt__buf, fontdicts: stbtt__buf, fdselect: stbtt__buf)(using Zone): Ptr[stbtt_fontinfo] = 
      val ____ptr = apply()
      (!____ptr).userdata = userdata
      (!____ptr).data = data
      (!____ptr).fontstart = fontstart
      (!____ptr).numGlyphs = numGlyphs
      (!____ptr).loca = loca
      (!____ptr).head = head
      (!____ptr).glyf = glyf
      (!____ptr).hhea = hhea
      (!____ptr).hmtx = hmtx
      (!____ptr).kern = kern
      (!____ptr).gpos = gpos
      (!____ptr).svg = svg
      (!____ptr).index_map = index_map
      (!____ptr).indexToLocFormat = indexToLocFormat
      (!____ptr).cff = cff
      (!____ptr).charstrings = charstrings
      (!____ptr).gsubrs = gsubrs
      (!____ptr).subrs = subrs
      (!____ptr).fontdicts = fontdicts
      (!____ptr).fdselect = fdselect
      ____ptr
    extension (struct: stbtt_fontinfo)
      def userdata: Ptr[Byte] = struct._1
      def userdata_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def data: Ptr[CUnsignedChar] = struct._2
      def data_=(value: Ptr[CUnsignedChar]): Unit = !struct.at2 = value
      def fontstart: CInt = struct._3
      def fontstart_=(value: CInt): Unit = !struct.at3 = value
      def numGlyphs: CInt = struct._4
      def numGlyphs_=(value: CInt): Unit = !struct.at4 = value
      def loca: CInt = struct._5
      def loca_=(value: CInt): Unit = !struct.at5 = value
      def head: CInt = struct._6
      def head_=(value: CInt): Unit = !struct.at6 = value
      def glyf: CInt = struct._7
      def glyf_=(value: CInt): Unit = !struct.at7 = value
      def hhea: CInt = struct._8
      def hhea_=(value: CInt): Unit = !struct.at8 = value
      def hmtx: CInt = struct._9
      def hmtx_=(value: CInt): Unit = !struct.at9 = value
      def kern: CInt = struct._10
      def kern_=(value: CInt): Unit = !struct.at10 = value
      def gpos: CInt = struct._11
      def gpos_=(value: CInt): Unit = !struct.at11 = value
      def svg: CInt = struct._12
      def svg_=(value: CInt): Unit = !struct.at12 = value
      def index_map: CInt = struct._13
      def index_map_=(value: CInt): Unit = !struct.at13 = value
      def indexToLocFormat: CInt = struct._14
      def indexToLocFormat_=(value: CInt): Unit = !struct.at14 = value
      def cff: stbtt__buf = struct._15
      def cff_=(value: stbtt__buf): Unit = !struct.at15 = value
      def charstrings: stbtt__buf = struct._16
      def charstrings_=(value: stbtt__buf): Unit = !struct.at16 = value
      def gsubrs: stbtt__buf = struct._17
      def gsubrs_=(value: stbtt__buf): Unit = !struct.at17 = value
      def subrs: stbtt__buf = struct._18
      def subrs_=(value: stbtt__buf): Unit = !struct.at18 = value
      def fontdicts: stbtt__buf = struct._19
      def fontdicts_=(value: stbtt__buf): Unit = !struct.at19 = value
      def fdselect: stbtt__buf = struct._20
      def fdselect_=(value: stbtt__buf): Unit = !struct.at20 = value

  opaque type stbtt_kerningentry = CStruct3[CInt, CInt, CInt]
  object stbtt_kerningentry:
    given _tag: Tag[stbtt_kerningentry] = Tag.materializeCStruct3Tag[CInt, CInt, CInt]
    def apply()(using Zone): Ptr[stbtt_kerningentry] = scala.scalanative.unsafe.alloc[stbtt_kerningentry](1)
    def apply(glyph1: CInt, glyph2: CInt, advance: CInt)(using Zone): Ptr[stbtt_kerningentry] = 
      val ____ptr = apply()
      (!____ptr).glyph1 = glyph1
      (!____ptr).glyph2 = glyph2
      (!____ptr).advance = advance
      ____ptr
    extension (struct: stbtt_kerningentry)
      def glyph1: CInt = struct._1
      def glyph1_=(value: CInt): Unit = !struct.at1 = value
      def glyph2: CInt = struct._2
      def glyph2_=(value: CInt): Unit = !struct.at2 = value
      def advance: CInt = struct._3
      def advance_=(value: CInt): Unit = !struct.at3 = value

  opaque type stbtt_pack_context = CStruct11[Ptr[Byte], Ptr[Byte], CInt, CInt, CInt, CInt, CInt, CUnsignedInt, CUnsignedInt, Ptr[CUnsignedChar], Ptr[Byte]]
  object stbtt_pack_context:
    given _tag: Tag[stbtt_pack_context] = Tag.materializeCStruct11Tag[Ptr[Byte], Ptr[Byte], CInt, CInt, CInt, CInt, CInt, CUnsignedInt, CUnsignedInt, Ptr[CUnsignedChar], Ptr[Byte]]
    def apply()(using Zone): Ptr[stbtt_pack_context] = scala.scalanative.unsafe.alloc[stbtt_pack_context](1)
    def apply(user_allocator_context: Ptr[Byte], pack_info: Ptr[Byte], width: CInt, height: CInt, stride_in_bytes: CInt, padding: CInt, skip_missing: CInt, h_oversample: CUnsignedInt, v_oversample: CUnsignedInt, pixels: Ptr[CUnsignedChar], nodes: Ptr[Byte])(using Zone): Ptr[stbtt_pack_context] = 
      val ____ptr = apply()
      (!____ptr).user_allocator_context = user_allocator_context
      (!____ptr).pack_info = pack_info
      (!____ptr).width = width
      (!____ptr).height = height
      (!____ptr).stride_in_bytes = stride_in_bytes
      (!____ptr).padding = padding
      (!____ptr).skip_missing = skip_missing
      (!____ptr).h_oversample = h_oversample
      (!____ptr).v_oversample = v_oversample
      (!____ptr).pixels = pixels
      (!____ptr).nodes = nodes
      ____ptr
    extension (struct: stbtt_pack_context)
      def user_allocator_context: Ptr[Byte] = struct._1
      def user_allocator_context_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def pack_info: Ptr[Byte] = struct._2
      def pack_info_=(value: Ptr[Byte]): Unit = !struct.at2 = value
      def width: CInt = struct._3
      def width_=(value: CInt): Unit = !struct.at3 = value
      def height: CInt = struct._4
      def height_=(value: CInt): Unit = !struct.at4 = value
      def stride_in_bytes: CInt = struct._5
      def stride_in_bytes_=(value: CInt): Unit = !struct.at5 = value
      def padding: CInt = struct._6
      def padding_=(value: CInt): Unit = !struct.at6 = value
      def skip_missing: CInt = struct._7
      def skip_missing_=(value: CInt): Unit = !struct.at7 = value
      def h_oversample: CUnsignedInt = struct._8
      def h_oversample_=(value: CUnsignedInt): Unit = !struct.at8 = value
      def v_oversample: CUnsignedInt = struct._9
      def v_oversample_=(value: CUnsignedInt): Unit = !struct.at9 = value
      def pixels: Ptr[CUnsignedChar] = struct._10
      def pixels_=(value: Ptr[CUnsignedChar]): Unit = !struct.at10 = value
      def nodes: Ptr[Byte] = struct._11
      def nodes_=(value: Ptr[Byte]): Unit = !struct.at11 = value

  opaque type stbtt_pack_range = CStruct7[Float, CInt, Ptr[CInt], CInt, Ptr[stbtt_packedchar], CUnsignedChar, CUnsignedChar]
  object stbtt_pack_range:
    given _tag: Tag[stbtt_pack_range] = Tag.materializeCStruct7Tag[Float, CInt, Ptr[CInt], CInt, Ptr[stbtt_packedchar], CUnsignedChar, CUnsignedChar]
    def apply()(using Zone): Ptr[stbtt_pack_range] = scala.scalanative.unsafe.alloc[stbtt_pack_range](1)
    def apply(font_size: Float, first_unicode_codepoint_in_range: CInt, array_of_unicode_codepoints: Ptr[CInt], num_chars: CInt, chardata_for_range: Ptr[stbtt_packedchar], h_oversample: CUnsignedChar, v_oversample: CUnsignedChar)(using Zone): Ptr[stbtt_pack_range] = 
      val ____ptr = apply()
      (!____ptr).font_size = font_size
      (!____ptr).first_unicode_codepoint_in_range = first_unicode_codepoint_in_range
      (!____ptr).array_of_unicode_codepoints = array_of_unicode_codepoints
      (!____ptr).num_chars = num_chars
      (!____ptr).chardata_for_range = chardata_for_range
      (!____ptr).h_oversample = h_oversample
      (!____ptr).v_oversample = v_oversample
      ____ptr
    extension (struct: stbtt_pack_range)
      def font_size: Float = struct._1
      def font_size_=(value: Float): Unit = !struct.at1 = value
      def first_unicode_codepoint_in_range: CInt = struct._2
      def first_unicode_codepoint_in_range_=(value: CInt): Unit = !struct.at2 = value
      def array_of_unicode_codepoints: Ptr[CInt] = struct._3
      def array_of_unicode_codepoints_=(value: Ptr[CInt]): Unit = !struct.at3 = value
      def num_chars: CInt = struct._4
      def num_chars_=(value: CInt): Unit = !struct.at4 = value
      def chardata_for_range: Ptr[stbtt_packedchar] = struct._5
      def chardata_for_range_=(value: Ptr[stbtt_packedchar]): Unit = !struct.at5 = value
      def h_oversample: CUnsignedChar = struct._6
      def h_oversample_=(value: CUnsignedChar): Unit = !struct.at6 = value
      def v_oversample: CUnsignedChar = struct._7
      def v_oversample_=(value: CUnsignedChar): Unit = !struct.at7 = value

  opaque type stbtt_packedchar = CStruct9[CUnsignedShort, CUnsignedShort, CUnsignedShort, CUnsignedShort, Float, Float, Float, Float, Float]
  object stbtt_packedchar:
    given _tag: Tag[stbtt_packedchar] = Tag.materializeCStruct9Tag[CUnsignedShort, CUnsignedShort, CUnsignedShort, CUnsignedShort, Float, Float, Float, Float, Float]
    def apply()(using Zone): Ptr[stbtt_packedchar] = scala.scalanative.unsafe.alloc[stbtt_packedchar](1)
    def apply(x0: CUnsignedShort, y0: CUnsignedShort, x1: CUnsignedShort, y1: CUnsignedShort, xoff: Float, yoff: Float, xadvance: Float, xoff2: Float, yoff2: Float)(using Zone): Ptr[stbtt_packedchar] = 
      val ____ptr = apply()
      (!____ptr).x0 = x0
      (!____ptr).y0 = y0
      (!____ptr).x1 = x1
      (!____ptr).y1 = y1
      (!____ptr).xoff = xoff
      (!____ptr).yoff = yoff
      (!____ptr).xadvance = xadvance
      (!____ptr).xoff2 = xoff2
      (!____ptr).yoff2 = yoff2
      ____ptr
    extension (struct: stbtt_packedchar)
      def x0: CUnsignedShort = struct._1
      def x0_=(value: CUnsignedShort): Unit = !struct.at1 = value
      def y0: CUnsignedShort = struct._2
      def y0_=(value: CUnsignedShort): Unit = !struct.at2 = value
      def x1: CUnsignedShort = struct._3
      def x1_=(value: CUnsignedShort): Unit = !struct.at3 = value
      def y1: CUnsignedShort = struct._4
      def y1_=(value: CUnsignedShort): Unit = !struct.at4 = value
      def xoff: Float = struct._5
      def xoff_=(value: Float): Unit = !struct.at5 = value
      def yoff: Float = struct._6
      def yoff_=(value: Float): Unit = !struct.at6 = value
      def xadvance: Float = struct._7
      def xadvance_=(value: Float): Unit = !struct.at7 = value
      def xoff2: Float = struct._8
      def xoff2_=(value: Float): Unit = !struct.at8 = value
      def yoff2: Float = struct._9
      def yoff2_=(value: Float): Unit = !struct.at9 = value

  opaque type stbtt_vertex = CStruct8[CShort, CShort, CShort, CShort, CShort, CShort, CUnsignedChar, CUnsignedChar]
  object stbtt_vertex:
    given _tag: Tag[stbtt_vertex] = Tag.materializeCStruct8Tag[CShort, CShort, CShort, CShort, CShort, CShort, CUnsignedChar, CUnsignedChar]
    def apply()(using Zone): Ptr[stbtt_vertex] = scala.scalanative.unsafe.alloc[stbtt_vertex](1)
    def apply(x: CShort, y: CShort, cx: CShort, cy: CShort, cx1: CShort, cy1: CShort, `type`: CUnsignedChar, padding: CUnsignedChar)(using Zone): Ptr[stbtt_vertex] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).cx = cx
      (!____ptr).cy = cy
      (!____ptr).cx1 = cx1
      (!____ptr).cy1 = cy1
      (!____ptr).`type` = `type`
      (!____ptr).padding = padding
      ____ptr
    extension (struct: stbtt_vertex)
      def x: CShort = struct._1
      def x_=(value: CShort): Unit = !struct.at1 = value
      def y: CShort = struct._2
      def y_=(value: CShort): Unit = !struct.at2 = value
      def cx: CShort = struct._3
      def cx_=(value: CShort): Unit = !struct.at3 = value
      def cy: CShort = struct._4
      def cy_=(value: CShort): Unit = !struct.at4 = value
      def cx1: CShort = struct._5
      def cx1_=(value: CShort): Unit = !struct.at5 = value
      def cy1: CShort = struct._6
      def cy1_=(value: CShort): Unit = !struct.at6 = value
      def `type`: CUnsignedChar = struct._7
      def type_=(value: CUnsignedChar): Unit = !struct.at7 = value
      def padding: CUnsignedChar = struct._8
      def padding_=(value: CUnsignedChar): Unit = !struct.at8 = value
  opaque type __mbstate_t = CArray[Byte, Nat.Digit3[Nat._1, Nat._2, Nat._8]]
  object __mbstate_t:
    given _tag: Tag[__mbstate_t] = Tag.CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]](Tag.Byte, Tag.Digit3[Nat._1, Nat._2, Nat._8](Tag.Nat1, Tag.Nat2, Tag.Nat8))
    extension (struct: __mbstate_t)
      def __mbstate8: CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]] = !struct.at(0).asInstanceOf[Ptr[CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]]]]
      def _mbstateL: CLongLong = !struct.at(0).asInstanceOf[Ptr[CLongLong]]

  opaque type nk_handle = CArray[Byte, Nat._8]
  object nk_handle:
    given _tag: Tag[nk_handle] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
    extension (struct: nk_handle)
      def ptr: Ptr[Byte] = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]]
      def id: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]

  opaque type nk_page_data = CArray[Byte, Nat.Digit3[Nat._4, Nat._9, Nat._6]]
  object nk_page_data:
    given _tag: Tag[nk_page_data] = Tag.CArray[CChar, Nat.Digit3[Nat._4, Nat._9, Nat._6]](Tag.Byte, Tag.Digit3[Nat._4, Nat._9, Nat._6](Tag.Nat4, Tag.Nat9, Tag.Nat6))
    extension (struct: nk_page_data)
      def tbl: nk_table = !struct.at(0).asInstanceOf[Ptr[nk_table]]
      def pan: nk_panel = !struct.at(0).asInstanceOf[Ptr[nk_panel]]
      def win: nk_window = !struct.at(0).asInstanceOf[Ptr[nk_window]]

  opaque type nk_property = CArray[Byte, Nat._8]
  object nk_property:
    given _tag: Tag[nk_property] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
    extension (struct: nk_property)
      def i: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def f: Float = !struct.at(0).asInstanceOf[Ptr[Float]]
      def d: Double = !struct.at(0).asInstanceOf[Ptr[Double]]

  opaque type nk_style_item_data = CArray[Byte, Nat.Digit2[Nat._2, Nat._8]]
  object nk_style_item_data:
    given _tag: Tag[nk_style_item_data] = Tag.CArray[CChar, Nat.Digit2[Nat._2, Nat._8]](Tag.Byte, Tag.Digit2[Nat._2, Nat._8](Tag.Nat2, Tag.Nat8))
    extension (struct: nk_style_item_data)
      def color: nk_color = !struct.at(0).asInstanceOf[Ptr[nk_color]]
      def image: nk_image = !struct.at(0).asInstanceOf[Ptr[nk_image]]
      def slice: nk_nine_slice = !struct.at(0).asInstanceOf[Ptr[nk_nine_slice]]
@link("nuklear")
@extern
private[libnuklear] object extern_functions: 
  import types.*

  def __assert_rtn(_0: CString, _1: CString, _2: CInt, _3: CString): Unit = extern

  @name("__sn_wrap_nk_begin")
  private[libnuklear] def __sn_wrap_nk_begin(ctx: Ptr[nk_context], title: CString, bounds: Ptr[nk_rect], flags: nk_flags): nk_bool = extern

  @name("__sn_wrap_nk_begin_titled")
  private[libnuklear] def __sn_wrap_nk_begin_titled(ctx: Ptr[nk_context], name: CString, title: CString, bounds: Ptr[nk_rect], flags: nk_flags): nk_bool = extern

  @name("__sn_wrap_nk_button_behavior")
  private[libnuklear] def __sn_wrap_nk_button_behavior(state: Ptr[nk_flags], r: Ptr[nk_rect], i: Ptr[nk_input], behavior: nk_button_behavior): nk_bool = extern

  @name("__sn_wrap_nk_button_color")
  private[libnuklear] def __sn_wrap_nk_button_color(ctx: Ptr[nk_context], color: Ptr[nk_color]): nk_bool = extern

  @name("__sn_wrap_nk_button_image")
  private[libnuklear] def __sn_wrap_nk_button_image(ctx: Ptr[nk_context], img: Ptr[nk_image]): nk_bool = extern

  @name("__sn_wrap_nk_button_image_label")
  private[libnuklear] def __sn_wrap_nk_button_image_label(ctx: Ptr[nk_context], img: Ptr[nk_image], label: CString, align: nk_flags): nk_bool = extern

  @name("__sn_wrap_nk_button_image_label_styled")
  private[libnuklear] def __sn_wrap_nk_button_image_label_styled(ctx: Ptr[nk_context], style: Ptr[nk_style_button], img: Ptr[nk_image], label: CString, text_alignment: nk_flags): nk_bool = extern

  @name("__sn_wrap_nk_button_image_styled")
  private[libnuklear] def __sn_wrap_nk_button_image_styled(ctx: Ptr[nk_context], style: Ptr[nk_style_button], img: Ptr[nk_image]): nk_bool = extern

  @name("__sn_wrap_nk_button_image_text")
  private[libnuklear] def __sn_wrap_nk_button_image_text(ctx: Ptr[nk_context], img: Ptr[nk_image], text: CString, len: CInt, align: nk_flags): nk_bool = extern

  @name("__sn_wrap_nk_button_image_text_styled")
  private[libnuklear] def __sn_wrap_nk_button_image_text_styled(ctx: Ptr[nk_context], style: Ptr[nk_style_button], img: Ptr[nk_image], text: CString, len: CInt, align: nk_flags): nk_bool = extern

  @name("__sn_wrap_nk_chart_add_slot_colored")
  private[libnuklear] def __sn_wrap_nk_chart_add_slot_colored(ctx: Ptr[nk_context], `type`: nk_chart_type, color: Ptr[nk_color], highlight: Ptr[nk_color], count: CInt, min_value: Float, max_value: Float): Unit = extern

  @name("__sn_wrap_nk_chart_begin_colored")
  private[libnuklear] def __sn_wrap_nk_chart_begin_colored(ctx: Ptr[nk_context], `type`: nk_chart_type, color: Ptr[nk_color], highlight: Ptr[nk_color], count: CInt, min_value: Float, max_value: Float): nk_bool = extern

  @name("__sn_wrap_nk_color_cf")
  private[libnuklear] def __sn_wrap_nk_color_cf(in: Ptr[nk_color], __return: Ptr[nk_colorf]): Unit = extern

  @name("__sn_wrap_nk_color_d")
  private[libnuklear] def __sn_wrap_nk_color_d(r: Ptr[Double], g: Ptr[Double], b: Ptr[Double], a: Ptr[Double], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_dv")
  private[libnuklear] def __sn_wrap_nk_color_dv(c: Ptr[Double], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_f")
  private[libnuklear] def __sn_wrap_nk_color_f(r: Ptr[Float], g: Ptr[Float], b: Ptr[Float], a: Ptr[Float], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_fv")
  private[libnuklear] def __sn_wrap_nk_color_fv(c: Ptr[Float], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hex_rgb")
  private[libnuklear] def __sn_wrap_nk_color_hex_rgb(output: CString, col: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hex_rgba")
  private[libnuklear] def __sn_wrap_nk_color_hex_rgba(output: CString, col: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hsv_b")
  private[libnuklear] def __sn_wrap_nk_color_hsv_b(out_h: Ptr[nk_byte], out_s: Ptr[nk_byte], out_v: Ptr[nk_byte], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hsv_bv")
  private[libnuklear] def __sn_wrap_nk_color_hsv_bv(out: Ptr[nk_byte], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hsv_f")
  private[libnuklear] def __sn_wrap_nk_color_hsv_f(out_h: Ptr[Float], out_s: Ptr[Float], out_v: Ptr[Float], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hsv_fv")
  private[libnuklear] def __sn_wrap_nk_color_hsv_fv(out: Ptr[Float], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hsv_i")
  private[libnuklear] def __sn_wrap_nk_color_hsv_i(out_h: Ptr[CInt], out_s: Ptr[CInt], out_v: Ptr[CInt], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hsv_iv")
  private[libnuklear] def __sn_wrap_nk_color_hsv_iv(out: Ptr[CInt], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hsva_b")
  private[libnuklear] def __sn_wrap_nk_color_hsva_b(h: Ptr[nk_byte], s: Ptr[nk_byte], v: Ptr[nk_byte], a: Ptr[nk_byte], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hsva_bv")
  private[libnuklear] def __sn_wrap_nk_color_hsva_bv(out: Ptr[nk_byte], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hsva_f")
  private[libnuklear] def __sn_wrap_nk_color_hsva_f(out_h: Ptr[Float], out_s: Ptr[Float], out_v: Ptr[Float], out_a: Ptr[Float], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hsva_fv")
  private[libnuklear] def __sn_wrap_nk_color_hsva_fv(out: Ptr[Float], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hsva_i")
  private[libnuklear] def __sn_wrap_nk_color_hsva_i(out_h: Ptr[CInt], out_s: Ptr[CInt], out_v: Ptr[CInt], out_a: Ptr[CInt], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_hsva_iv")
  private[libnuklear] def __sn_wrap_nk_color_hsva_iv(out: Ptr[CInt], in: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_color_picker")
  private[libnuklear] def __sn_wrap_nk_color_picker(ctx: Ptr[nk_context], color: Ptr[nk_colorf], fmt: nk_color_format, __return: Ptr[nk_colorf]): Unit = extern

  @name("__sn_wrap_nk_color_u32")
  private[libnuklear] def __sn_wrap_nk_color_u32(in: Ptr[nk_color]): nk_uint = extern

  @name("__sn_wrap_nk_colorf_hsva_f")
  private[libnuklear] def __sn_wrap_nk_colorf_hsva_f(out_h: Ptr[Float], out_s: Ptr[Float], out_v: Ptr[Float], out_a: Ptr[Float], in: Ptr[nk_colorf]): Unit = extern

  @name("__sn_wrap_nk_colorf_hsva_fv")
  private[libnuklear] def __sn_wrap_nk_colorf_hsva_fv(hsva: Ptr[Float], in: Ptr[nk_colorf]): Unit = extern

  @name("__sn_wrap_nk_combo")
  private[libnuklear] def __sn_wrap_nk_combo(ctx: Ptr[nk_context], items: Ptr[CString], count: CInt, selected: CInt, item_height: CInt, size: Ptr[nk_vec2]): CInt = extern

  @name("__sn_wrap_nk_combo_begin")
  private[libnuklear] def __sn_wrap_nk_combo_begin(ctx: Ptr[nk_context], win: Ptr[nk_window], size: Ptr[nk_vec2], is_clicked: nk_bool, header: Ptr[nk_rect]): nk_bool = extern

  @name("__sn_wrap_nk_combo_begin_color")
  private[libnuklear] def __sn_wrap_nk_combo_begin_color(ctx: Ptr[nk_context], color: Ptr[nk_color], size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_combo_begin_image")
  private[libnuklear] def __sn_wrap_nk_combo_begin_image(ctx: Ptr[nk_context], img: Ptr[nk_image], size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_combo_begin_image_label")
  private[libnuklear] def __sn_wrap_nk_combo_begin_image_label(ctx: Ptr[nk_context], selected: CString, img: Ptr[nk_image], size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_combo_begin_image_text")
  private[libnuklear] def __sn_wrap_nk_combo_begin_image_text(ctx: Ptr[nk_context], selected: CString, len: CInt, img: Ptr[nk_image], size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_combo_begin_label")
  private[libnuklear] def __sn_wrap_nk_combo_begin_label(ctx: Ptr[nk_context], selected: CString, size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_combo_begin_symbol")
  private[libnuklear] def __sn_wrap_nk_combo_begin_symbol(ctx: Ptr[nk_context], symbol: nk_symbol_type, size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_combo_begin_symbol_label")
  private[libnuklear] def __sn_wrap_nk_combo_begin_symbol_label(ctx: Ptr[nk_context], selected: CString, `type`: nk_symbol_type, size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_combo_begin_symbol_text")
  private[libnuklear] def __sn_wrap_nk_combo_begin_symbol_text(ctx: Ptr[nk_context], selected: CString, len: CInt, symbol: nk_symbol_type, size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_combo_begin_text")
  private[libnuklear] def __sn_wrap_nk_combo_begin_text(ctx: Ptr[nk_context], selected: CString, len: CInt, size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_combo_callback")
  private[libnuklear] def __sn_wrap_nk_combo_callback(ctx: Ptr[nk_context], item_getter: CFuncPtr3[Ptr[Byte], CInt, Ptr[CString], Unit], userdata: Ptr[Byte], selected: CInt, count: CInt, item_height: CInt, size: Ptr[nk_vec2]): CInt = extern

  @name("__sn_wrap_nk_combo_item_image_label")
  private[libnuklear] def __sn_wrap_nk_combo_item_image_label(ctx: Ptr[nk_context], img: Ptr[nk_image], text: CString, alignment: nk_flags): nk_bool = extern

  @name("__sn_wrap_nk_combo_item_image_text")
  private[libnuklear] def __sn_wrap_nk_combo_item_image_text(ctx: Ptr[nk_context], img: Ptr[nk_image], text: CString, len: CInt, alignment: nk_flags): nk_bool = extern

  @name("__sn_wrap_nk_combo_separator")
  private[libnuklear] def __sn_wrap_nk_combo_separator(ctx: Ptr[nk_context], items_separated_by_separator: CString, separator: CInt, selected: CInt, count: CInt, item_height: CInt, size: Ptr[nk_vec2]): CInt = extern

  @name("__sn_wrap_nk_combo_string")
  private[libnuklear] def __sn_wrap_nk_combo_string(ctx: Ptr[nk_context], items_separated_by_zeros: CString, selected: CInt, count: CInt, item_height: CInt, size: Ptr[nk_vec2]): CInt = extern

  @name("__sn_wrap_nk_combobox")
  private[libnuklear] def __sn_wrap_nk_combobox(ctx: Ptr[nk_context], items: Ptr[CString], count: CInt, selected: Ptr[CInt], item_height: CInt, size: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_combobox_callback")
  private[libnuklear] def __sn_wrap_nk_combobox_callback(ctx: Ptr[nk_context], item_getter: CFuncPtr3[Ptr[Byte], CInt, Ptr[CString], Unit], userdata: Ptr[Byte], selected: Ptr[CInt], count: CInt, item_height: CInt, size: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_combobox_separator")
  private[libnuklear] def __sn_wrap_nk_combobox_separator(ctx: Ptr[nk_context], items_separated_by_separator: CString, separator: CInt, selected: Ptr[CInt], count: CInt, item_height: CInt, size: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_combobox_string")
  private[libnuklear] def __sn_wrap_nk_combobox_string(ctx: Ptr[nk_context], items_separated_by_zeros: CString, selected: Ptr[CInt], count: CInt, item_height: CInt, size: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_contextual_begin")
  private[libnuklear] def __sn_wrap_nk_contextual_begin(ctx: Ptr[nk_context], flags: nk_flags, size: Ptr[nk_vec2], trigger_bounds: Ptr[nk_rect]): nk_bool = extern

  @name("__sn_wrap_nk_contextual_item_image_label")
  private[libnuklear] def __sn_wrap_nk_contextual_item_image_label(ctx: Ptr[nk_context], img: Ptr[nk_image], label: CString, align: nk_flags): nk_bool = extern

  @name("__sn_wrap_nk_contextual_item_image_text")
  private[libnuklear] def __sn_wrap_nk_contextual_item_image_text(ctx: Ptr[nk_context], img: Ptr[nk_image], text: CString, len: CInt, align: nk_flags): nk_bool = extern

  @name("__sn_wrap_nk_do_button")
  private[libnuklear] def __sn_wrap_nk_do_button(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], r: Ptr[nk_rect], style: Ptr[nk_style_button], in: Ptr[nk_input], behavior: nk_button_behavior, content: Ptr[nk_rect]): nk_bool = extern

  @name("__sn_wrap_nk_do_button_image")
  private[libnuklear] def __sn_wrap_nk_do_button_image(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], img: Ptr[nk_image], b: nk_button_behavior, style: Ptr[nk_style_button], in: Ptr[nk_input]): nk_bool = extern

  @name("__sn_wrap_nk_do_button_symbol")
  private[libnuklear] def __sn_wrap_nk_do_button_symbol(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], symbol: nk_symbol_type, behavior: nk_button_behavior, style: Ptr[nk_style_button], in: Ptr[nk_input], font: Ptr[nk_user_font]): nk_bool = extern

  @name("__sn_wrap_nk_do_button_text")
  private[libnuklear] def __sn_wrap_nk_do_button_text(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], string: CString, len: CInt, align: nk_flags, behavior: nk_button_behavior, style: Ptr[nk_style_button], in: Ptr[nk_input], font: Ptr[nk_user_font]): nk_bool = extern

  @name("__sn_wrap_nk_do_button_text_image")
  private[libnuklear] def __sn_wrap_nk_do_button_text_image(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], img: Ptr[nk_image], str: CString, len: CInt, align: nk_flags, behavior: nk_button_behavior, style: Ptr[nk_style_button], font: Ptr[nk_user_font], in: Ptr[nk_input]): nk_bool = extern

  @name("__sn_wrap_nk_do_button_text_symbol")
  private[libnuklear] def __sn_wrap_nk_do_button_text_symbol(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], symbol: nk_symbol_type, str: CString, len: CInt, align: nk_flags, behavior: nk_button_behavior, style: Ptr[nk_style_button], font: Ptr[nk_user_font], in: Ptr[nk_input]): nk_bool = extern

  @name("__sn_wrap_nk_do_color_picker")
  private[libnuklear] def __sn_wrap_nk_do_color_picker(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], col: Ptr[nk_colorf], fmt: nk_color_format, bounds: Ptr[nk_rect], padding: Ptr[nk_vec2], in: Ptr[nk_input], font: Ptr[nk_user_font]): nk_bool = extern

  @name("__sn_wrap_nk_do_edit")
  private[libnuklear] def __sn_wrap_nk_do_edit(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], flags: nk_flags, filter: nk_plugin_filter, edit: Ptr[nk_text_edit], style: Ptr[nk_style_edit], in: Ptr[nk_input], font: Ptr[nk_user_font]): nk_flags = extern

  @name("__sn_wrap_nk_do_progress")
  private[libnuklear] def __sn_wrap_nk_do_progress(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], value: nk_size, max: nk_size, modifiable: nk_bool, style: Ptr[nk_style_progress], in: Ptr[nk_input]): nk_size = extern

  @name("__sn_wrap_nk_do_property")
  private[libnuklear] def __sn_wrap_nk_do_property(ws: Ptr[nk_flags], out: Ptr[nk_command_buffer], property: Ptr[nk_rect], name: CString, variant: Ptr[nk_property_variant], inc_per_pixel: Float, buffer: CString, len: Ptr[CInt], state: Ptr[CInt], cursor: Ptr[CInt], select_begin: Ptr[CInt], select_end: Ptr[CInt], style: Ptr[nk_style_property], filter: nk_property_filter, in: Ptr[nk_input], font: Ptr[nk_user_font], text_edit: Ptr[nk_text_edit], behavior: nk_button_behavior): Unit = extern

  @name("__sn_wrap_nk_do_scrollbarh")
  private[libnuklear] def __sn_wrap_nk_do_scrollbarh(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], scroll: Ptr[nk_rect], has_scrolling: CInt, offset: Float, target: Float, step: Float, button_pixel_inc: Float, style: Ptr[nk_style_scrollbar], in: Ptr[nk_input], font: Ptr[nk_user_font]): Float = extern

  @name("__sn_wrap_nk_do_scrollbarv")
  private[libnuklear] def __sn_wrap_nk_do_scrollbarv(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], scroll: Ptr[nk_rect], has_scrolling: CInt, offset: Float, target: Float, step: Float, button_pixel_inc: Float, style: Ptr[nk_style_scrollbar], in: Ptr[nk_input], font: Ptr[nk_user_font]): Float = extern

  @name("__sn_wrap_nk_do_selectable")
  private[libnuklear] def __sn_wrap_nk_do_selectable(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], str: CString, len: CInt, align: nk_flags, value: Ptr[nk_bool], style: Ptr[nk_style_selectable], in: Ptr[nk_input], font: Ptr[nk_user_font]): nk_bool = extern

  @name("__sn_wrap_nk_do_selectable_image")
  private[libnuklear] def __sn_wrap_nk_do_selectable_image(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], str: CString, len: CInt, align: nk_flags, value: Ptr[nk_bool], img: Ptr[nk_image], style: Ptr[nk_style_selectable], in: Ptr[nk_input], font: Ptr[nk_user_font]): nk_bool = extern

  @name("__sn_wrap_nk_do_selectable_symbol")
  private[libnuklear] def __sn_wrap_nk_do_selectable_symbol(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], str: CString, len: CInt, align: nk_flags, value: Ptr[nk_bool], sym: nk_symbol_type, style: Ptr[nk_style_selectable], in: Ptr[nk_input], font: Ptr[nk_user_font]): nk_bool = extern

  @name("__sn_wrap_nk_do_slider")
  private[libnuklear] def __sn_wrap_nk_do_slider(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], min: Float, `val`: Float, max: Float, step: Float, style: Ptr[nk_style_slider], in: Ptr[nk_input], font: Ptr[nk_user_font]): Float = extern

  @name("__sn_wrap_nk_do_toggle")
  private[libnuklear] def __sn_wrap_nk_do_toggle(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], r: Ptr[nk_rect], active: Ptr[nk_bool], str: CString, len: CInt, `type`: nk_toggle_type, style: Ptr[nk_style_toggle], in: Ptr[nk_input], font: Ptr[nk_user_font]): nk_bool = extern

  @name("__sn_wrap_nk_drag_behavior")
  private[libnuklear] def __sn_wrap_nk_drag_behavior(state: Ptr[nk_flags], in: Ptr[nk_input], drag: Ptr[nk_rect], variant: Ptr[nk_property_variant], inc_per_pixel: Float): Unit = extern

  @name("__sn_wrap_nk_draw_color_picker")
  private[libnuklear] def __sn_wrap_nk_draw_color_picker(o: Ptr[nk_command_buffer], matrix: Ptr[nk_rect], hue_bar: Ptr[nk_rect], alpha_bar: Ptr[nk_rect], col: Ptr[nk_colorf]): Unit = extern

  @name("__sn_wrap_nk_draw_image")
  private[libnuklear] def __sn_wrap_nk_draw_image(b: Ptr[nk_command_buffer], r: Ptr[nk_rect], img: Ptr[nk_image], col: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_draw_nine_slice")
  private[libnuklear] def __sn_wrap_nk_draw_nine_slice(b: Ptr[nk_command_buffer], r: Ptr[nk_rect], slc: Ptr[nk_nine_slice], col: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_draw_symbol")
  private[libnuklear] def __sn_wrap_nk_draw_symbol(out: Ptr[nk_command_buffer], `type`: nk_symbol_type, content: Ptr[nk_rect], background: Ptr[nk_color], foreground: Ptr[nk_color], border_width: Float, font: Ptr[nk_user_font]): Unit = extern

  @name("__sn_wrap_nk_draw_text")
  private[libnuklear] def __sn_wrap_nk_draw_text(b: Ptr[nk_command_buffer], r: Ptr[nk_rect], string: CString, length: CInt, font: Ptr[nk_user_font], bg: Ptr[nk_color], fg: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_edit_draw_text")
  private[libnuklear] def __sn_wrap_nk_edit_draw_text(out: Ptr[nk_command_buffer], style: Ptr[nk_style_edit], pos_x: Float, pos_y: Float, x_offset: Float, text: CString, byte_len: CInt, row_height: Float, font: Ptr[nk_user_font], background: Ptr[nk_color], foreground: Ptr[nk_color], is_selected: nk_bool): Unit = extern

  @name("__sn_wrap_nk_fill_arc")
  private[libnuklear] def __sn_wrap_nk_fill_arc(b: Ptr[nk_command_buffer], cx: Float, cy: Float, radius: Float, a_min: Float, a_max: Float, c: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_fill_circle")
  private[libnuklear] def __sn_wrap_nk_fill_circle(b: Ptr[nk_command_buffer], r: Ptr[nk_rect], c: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_fill_polygon")
  private[libnuklear] def __sn_wrap_nk_fill_polygon(b: Ptr[nk_command_buffer], points: Ptr[Float], point_count: CInt, col: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_fill_rect")
  private[libnuklear] def __sn_wrap_nk_fill_rect(b: Ptr[nk_command_buffer], rect: Ptr[nk_rect], rounding: Float, c: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_fill_rect_multi_color")
  private[libnuklear] def __sn_wrap_nk_fill_rect_multi_color(b: Ptr[nk_command_buffer], rect: Ptr[nk_rect], left: Ptr[nk_color], top: Ptr[nk_color], right: Ptr[nk_color], bottom: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_fill_triangle")
  private[libnuklear] def __sn_wrap_nk_fill_triangle(b: Ptr[nk_command_buffer], x0: Float, y0: Float, x1: Float, y1: Float, x2: Float, y2: Float, c: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_get_null_rect")
  private[libnuklear] def __sn_wrap_nk_get_null_rect(__return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_hsv")
  private[libnuklear] def __sn_wrap_nk_hsv(h: CInt, s: CInt, v: CInt, __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_hsv_bv")
  private[libnuklear] def __sn_wrap_nk_hsv_bv(hsv: Ptr[nk_byte], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_hsv_f")
  private[libnuklear] def __sn_wrap_nk_hsv_f(h: Float, s: Float, v: Float, __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_hsv_fv")
  private[libnuklear] def __sn_wrap_nk_hsv_fv(c: Ptr[Float], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_hsv_iv")
  private[libnuklear] def __sn_wrap_nk_hsv_iv(hsv: Ptr[CInt], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_hsva")
  private[libnuklear] def __sn_wrap_nk_hsva(h: CInt, s: CInt, v: CInt, a: CInt, __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_hsva_bv")
  private[libnuklear] def __sn_wrap_nk_hsva_bv(hsva: Ptr[nk_byte], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_hsva_colorf")
  private[libnuklear] def __sn_wrap_nk_hsva_colorf(h: Float, s: Float, v: Float, a: Float, __return: Ptr[nk_colorf]): Unit = extern

  @name("__sn_wrap_nk_hsva_colorfv")
  private[libnuklear] def __sn_wrap_nk_hsva_colorfv(c: Ptr[Float], __return: Ptr[nk_colorf]): Unit = extern

  @name("__sn_wrap_nk_hsva_f")
  private[libnuklear] def __sn_wrap_nk_hsva_f(h: Float, s: Float, v: Float, a: Float, __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_hsva_fv")
  private[libnuklear] def __sn_wrap_nk_hsva_fv(c: Ptr[Float], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_hsva_iv")
  private[libnuklear] def __sn_wrap_nk_hsva_iv(c: Ptr[CInt], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_image")
  private[libnuklear] def __sn_wrap_nk_image(ctx: Ptr[nk_context], img: Ptr[nk_image]): Unit = extern

  @name("__sn_wrap_nk_image_color")
  private[libnuklear] def __sn_wrap_nk_image_color(ctx: Ptr[nk_context], img: Ptr[nk_image], col: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_image_handle")
  private[libnuklear] def __sn_wrap_nk_image_handle(handle: nk_handle, __return: Ptr[nk_image]): Unit = extern

  @name("__sn_wrap_nk_image_id")
  private[libnuklear] def __sn_wrap_nk_image_id(id: CInt, __return: Ptr[nk_image]): Unit = extern

  @name("__sn_wrap_nk_image_ptr")
  private[libnuklear] def __sn_wrap_nk_image_ptr(ptr: Ptr[Byte], __return: Ptr[nk_image]): Unit = extern

  @name("__sn_wrap_nk_input_any_mouse_click_in_rect")
  private[libnuklear] def __sn_wrap_nk_input_any_mouse_click_in_rect(in: Ptr[nk_input], b: Ptr[nk_rect]): nk_bool = extern

  @name("__sn_wrap_nk_input_has_mouse_click_down_in_rect")
  private[libnuklear] def __sn_wrap_nk_input_has_mouse_click_down_in_rect(i: Ptr[nk_input], id: nk_buttons, b: Ptr[nk_rect], down: nk_bool): nk_bool = extern

  @name("__sn_wrap_nk_input_has_mouse_click_in_rect")
  private[libnuklear] def __sn_wrap_nk_input_has_mouse_click_in_rect(i: Ptr[nk_input], id: nk_buttons, b: Ptr[nk_rect]): nk_bool = extern

  @name("__sn_wrap_nk_input_is_mouse_click_down_in_rect")
  private[libnuklear] def __sn_wrap_nk_input_is_mouse_click_down_in_rect(i: Ptr[nk_input], id: nk_buttons, b: Ptr[nk_rect], down: nk_bool): nk_bool = extern

  @name("__sn_wrap_nk_input_is_mouse_click_in_rect")
  private[libnuklear] def __sn_wrap_nk_input_is_mouse_click_in_rect(i: Ptr[nk_input], id: nk_buttons, b: Ptr[nk_rect]): nk_bool = extern

  @name("__sn_wrap_nk_input_is_mouse_hovering_rect")
  private[libnuklear] def __sn_wrap_nk_input_is_mouse_hovering_rect(i: Ptr[nk_input], rect: Ptr[nk_rect]): nk_bool = extern

  @name("__sn_wrap_nk_input_is_mouse_prev_hovering_rect")
  private[libnuklear] def __sn_wrap_nk_input_is_mouse_prev_hovering_rect(i: Ptr[nk_input], rect: Ptr[nk_rect]): nk_bool = extern

  @name("__sn_wrap_nk_input_mouse_clicked")
  private[libnuklear] def __sn_wrap_nk_input_mouse_clicked(i: Ptr[nk_input], id: nk_buttons, rect: Ptr[nk_rect]): nk_bool = extern

  @name("__sn_wrap_nk_input_scroll")
  private[libnuklear] def __sn_wrap_nk_input_scroll(ctx: Ptr[nk_context], `val`: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_label_colored")
  private[libnuklear] def __sn_wrap_nk_label_colored(ctx: Ptr[nk_context], str: CString, align: nk_flags, color: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_label_colored_wrap")
  private[libnuklear] def __sn_wrap_nk_label_colored_wrap(ctx: Ptr[nk_context], str: CString, color: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_layout_space_bounds")
  private[libnuklear] def __sn_wrap_nk_layout_space_bounds(ctx: Ptr[nk_context], __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_layout_space_push")
  private[libnuklear] def __sn_wrap_nk_layout_space_push(ctx: Ptr[nk_context], rect: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_layout_space_rect_to_local")
  private[libnuklear] def __sn_wrap_nk_layout_space_rect_to_local(ctx: Ptr[nk_context], ret: Ptr[nk_rect], __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_layout_space_rect_to_screen")
  private[libnuklear] def __sn_wrap_nk_layout_space_rect_to_screen(ctx: Ptr[nk_context], ret: Ptr[nk_rect], __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_layout_space_to_local")
  private[libnuklear] def __sn_wrap_nk_layout_space_to_local(ctx: Ptr[nk_context], ret: Ptr[nk_vec2], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_layout_space_to_screen")
  private[libnuklear] def __sn_wrap_nk_layout_space_to_screen(ctx: Ptr[nk_context], ret: Ptr[nk_vec2], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_layout_widget_bounds")
  private[libnuklear] def __sn_wrap_nk_layout_widget_bounds(ctx: Ptr[nk_context], __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_menu_begin")
  private[libnuklear] def __sn_wrap_nk_menu_begin(ctx: Ptr[nk_context], win: Ptr[nk_window], id: CString, is_clicked: CInt, header: Ptr[nk_rect], size: Ptr[nk_vec2]): CInt = extern

  @name("__sn_wrap_nk_menu_begin_image")
  private[libnuklear] def __sn_wrap_nk_menu_begin_image(ctx: Ptr[nk_context], id: CString, img: Ptr[nk_image], size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_menu_begin_image_label")
  private[libnuklear] def __sn_wrap_nk_menu_begin_image_label(ctx: Ptr[nk_context], title: CString, align: nk_flags, img: Ptr[nk_image], size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_menu_begin_image_text")
  private[libnuklear] def __sn_wrap_nk_menu_begin_image_text(ctx: Ptr[nk_context], title: CString, len: CInt, align: nk_flags, img: Ptr[nk_image], size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_menu_begin_label")
  private[libnuklear] def __sn_wrap_nk_menu_begin_label(ctx: Ptr[nk_context], text: CString, align: nk_flags, size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_menu_begin_symbol")
  private[libnuklear] def __sn_wrap_nk_menu_begin_symbol(ctx: Ptr[nk_context], id: CString, sym: nk_symbol_type, size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_menu_begin_symbol_label")
  private[libnuklear] def __sn_wrap_nk_menu_begin_symbol_label(ctx: Ptr[nk_context], title: CString, align: nk_flags, sym: nk_symbol_type, size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_menu_begin_symbol_text")
  private[libnuklear] def __sn_wrap_nk_menu_begin_symbol_text(ctx: Ptr[nk_context], title: CString, len: CInt, align: nk_flags, sym: nk_symbol_type, size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_menu_begin_text")
  private[libnuklear] def __sn_wrap_nk_menu_begin_text(ctx: Ptr[nk_context], title: CString, len: CInt, align: nk_flags, size: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_menu_item_image_label")
  private[libnuklear] def __sn_wrap_nk_menu_item_image_label(ctx: Ptr[nk_context], img: Ptr[nk_image], label: CString, align: nk_flags): nk_bool = extern

  @name("__sn_wrap_nk_menu_item_image_text")
  private[libnuklear] def __sn_wrap_nk_menu_item_image_text(ctx: Ptr[nk_context], img: Ptr[nk_image], text: CString, len: CInt, align: nk_flags): nk_bool = extern

  @name("__sn_wrap_nk_nine_slice_handle")
  private[libnuklear] def __sn_wrap_nk_nine_slice_handle(handle: nk_handle, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort, __return: Ptr[nk_nine_slice]): Unit = extern

  @name("__sn_wrap_nk_nine_slice_id")
  private[libnuklear] def __sn_wrap_nk_nine_slice_id(id: CInt, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort, __return: Ptr[nk_nine_slice]): Unit = extern

  @name("__sn_wrap_nk_nine_slice_ptr")
  private[libnuklear] def __sn_wrap_nk_nine_slice_ptr(ptr: Ptr[Byte], l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort, __return: Ptr[nk_nine_slice]): Unit = extern

  @name("__sn_wrap_nk_nonblock_begin")
  private[libnuklear] def __sn_wrap_nk_nonblock_begin(ctx: Ptr[nk_context], flags: nk_flags, body: Ptr[nk_rect], header: Ptr[nk_rect], panel_type: nk_panel_type): nk_bool = extern

  @name("__sn_wrap_nk_pad_rect")
  private[libnuklear] def __sn_wrap_nk_pad_rect(r: Ptr[nk_rect], pad: Ptr[nk_vec2], __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_panel_get_border_color")
  private[libnuklear] def __sn_wrap_nk_panel_get_border_color(style: Ptr[nk_style], `type`: nk_panel_type, __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_panel_get_padding")
  private[libnuklear] def __sn_wrap_nk_panel_get_padding(style: Ptr[nk_style], `type`: nk_panel_type, __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_popup_begin")
  private[libnuklear] def __sn_wrap_nk_popup_begin(ctx: Ptr[nk_context], `type`: nk_popup_type, title: CString, flags: nk_flags, rect: Ptr[nk_rect]): nk_bool = extern

  @name("__sn_wrap_nk_progress_behavior")
  private[libnuklear] def __sn_wrap_nk_progress_behavior(state: Ptr[nk_flags], in: Ptr[nk_input], r: Ptr[nk_rect], cursor: Ptr[nk_rect], max: nk_size, value: nk_size, modifiable: nk_bool): nk_size = extern

  @name("__sn_wrap_nk_property_behavior")
  private[libnuklear] def __sn_wrap_nk_property_behavior(ws: Ptr[nk_flags], in: Ptr[nk_input], property: Ptr[nk_rect], label: Ptr[nk_rect], edit: Ptr[nk_rect], empty: Ptr[nk_rect], state: Ptr[CInt], variant: Ptr[nk_property_variant], inc_per_pixel: Float): Unit = extern

  @name("__sn_wrap_nk_property_variant_double")
  private[libnuklear] def __sn_wrap_nk_property_variant_double(value: Double, min_value: Double, max_value: Double, step: Double, __return: Ptr[nk_property_variant]): Unit = extern

  @name("__sn_wrap_nk_property_variant_float")
  private[libnuklear] def __sn_wrap_nk_property_variant_float(value: Float, min_value: Float, max_value: Float, step: Float, __return: Ptr[nk_property_variant]): Unit = extern

  @name("__sn_wrap_nk_property_variant_int")
  private[libnuklear] def __sn_wrap_nk_property_variant_int(value: CInt, min_value: CInt, max_value: CInt, step: CInt, __return: Ptr[nk_property_variant]): Unit = extern

  @name("__sn_wrap_nk_push_custom")
  private[libnuklear] def __sn_wrap_nk_push_custom(b: Ptr[nk_command_buffer], r: Ptr[nk_rect], cb: nk_command_custom_callback, usr: nk_handle): Unit = extern

  @name("__sn_wrap_nk_push_scissor")
  private[libnuklear] def __sn_wrap_nk_push_scissor(b: Ptr[nk_command_buffer], r: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_rect")
  private[libnuklear] def __sn_wrap_nk_rect(x: Float, y: Float, w: Float, h: Float, __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_rect_pos")
  private[libnuklear] def __sn_wrap_nk_rect_pos(r: Ptr[nk_rect], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_rect_size")
  private[libnuklear] def __sn_wrap_nk_rect_size(r: Ptr[nk_rect], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_recta")
  private[libnuklear] def __sn_wrap_nk_recta(pos: Ptr[nk_vec2], size: Ptr[nk_vec2], __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_recti")
  private[libnuklear] def __sn_wrap_nk_recti(x: CInt, y: CInt, w: CInt, h: CInt, __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_rectiv")
  private[libnuklear] def __sn_wrap_nk_rectiv(r: Ptr[CInt], __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_rectv")
  private[libnuklear] def __sn_wrap_nk_rectv(xywh: Ptr[Float], __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_rgb")
  private[libnuklear] def __sn_wrap_nk_rgb(r: CInt, g: CInt, b: CInt, __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgb_bv")
  private[libnuklear] def __sn_wrap_nk_rgb_bv(c: Ptr[nk_byte], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgb_cf")
  private[libnuklear] def __sn_wrap_nk_rgb_cf(c: Ptr[nk_colorf], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgb_f")
  private[libnuklear] def __sn_wrap_nk_rgb_f(r: Float, g: Float, b: Float, __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgb_fv")
  private[libnuklear] def __sn_wrap_nk_rgb_fv(rgb: Ptr[Float], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgb_hex")
  private[libnuklear] def __sn_wrap_nk_rgb_hex(rgb: CString, __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgb_iv")
  private[libnuklear] def __sn_wrap_nk_rgb_iv(rgb: Ptr[CInt], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgba")
  private[libnuklear] def __sn_wrap_nk_rgba(r: CInt, g: CInt, b: CInt, a: CInt, __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgba_bv")
  private[libnuklear] def __sn_wrap_nk_rgba_bv(c: Ptr[nk_byte], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgba_cf")
  private[libnuklear] def __sn_wrap_nk_rgba_cf(c: Ptr[nk_colorf], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgba_f")
  private[libnuklear] def __sn_wrap_nk_rgba_f(r: Float, g: Float, b: Float, a: Float, __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgba_fv")
  private[libnuklear] def __sn_wrap_nk_rgba_fv(c: Ptr[Float], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgba_hex")
  private[libnuklear] def __sn_wrap_nk_rgba_hex(rgb: CString, __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgba_iv")
  private[libnuklear] def __sn_wrap_nk_rgba_iv(rgba: Ptr[CInt], __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_rgba_u32")
  private[libnuklear] def __sn_wrap_nk_rgba_u32(in: nk_uint, __return: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_select_image_label")
  private[libnuklear] def __sn_wrap_nk_select_image_label(ctx: Ptr[nk_context], img: Ptr[nk_image], str: CString, align: nk_flags, value: nk_bool): nk_bool = extern

  @name("__sn_wrap_nk_select_image_text")
  private[libnuklear] def __sn_wrap_nk_select_image_text(ctx: Ptr[nk_context], img: Ptr[nk_image], str: CString, len: CInt, align: nk_flags, value: nk_bool): nk_bool = extern

  @name("__sn_wrap_nk_selectable_image_label")
  private[libnuklear] def __sn_wrap_nk_selectable_image_label(ctx: Ptr[nk_context], img: Ptr[nk_image], str: CString, align: nk_flags, value: Ptr[nk_bool]): nk_bool = extern

  @name("__sn_wrap_nk_selectable_image_text")
  private[libnuklear] def __sn_wrap_nk_selectable_image_text(ctx: Ptr[nk_context], img: Ptr[nk_image], str: CString, len: CInt, align: nk_flags, value: Ptr[nk_bool]): nk_bool = extern

  @name("__sn_wrap_nk_shrink_rect")
  private[libnuklear] def __sn_wrap_nk_shrink_rect(r: Ptr[nk_rect], amount: Float, __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_slider_behavior")
  private[libnuklear] def __sn_wrap_nk_slider_behavior(state: Ptr[nk_flags], logical_cursor: Ptr[nk_rect], visual_cursor: Ptr[nk_rect], in: Ptr[nk_input], bounds: Ptr[nk_rect], slider_min: Float, slider_max: Float, slider_value: Float, slider_step: Float, slider_steps: Float): Float = extern

  @name("__sn_wrap_nk_stroke_arc")
  private[libnuklear] def __sn_wrap_nk_stroke_arc(b: Ptr[nk_command_buffer], cx: Float, cy: Float, radius: Float, a_min: Float, a_max: Float, line_thickness: Float, c: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_stroke_circle")
  private[libnuklear] def __sn_wrap_nk_stroke_circle(b: Ptr[nk_command_buffer], r: Ptr[nk_rect], line_thickness: Float, c: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_stroke_curve")
  private[libnuklear] def __sn_wrap_nk_stroke_curve(b: Ptr[nk_command_buffer], ax: Float, ay: Float, ctrl0x: Float, ctrl0y: Float, ctrl1x: Float, ctrl1y: Float, bx: Float, by: Float, line_thickness: Float, col: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_stroke_line")
  private[libnuklear] def __sn_wrap_nk_stroke_line(b: Ptr[nk_command_buffer], x0: Float, y0: Float, x1: Float, y1: Float, line_thickness: Float, c: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_stroke_polygon")
  private[libnuklear] def __sn_wrap_nk_stroke_polygon(b: Ptr[nk_command_buffer], points: Ptr[Float], point_count: CInt, line_thickness: Float, col: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_stroke_polyline")
  private[libnuklear] def __sn_wrap_nk_stroke_polyline(b: Ptr[nk_command_buffer], points: Ptr[Float], point_count: CInt, line_thickness: Float, col: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_stroke_rect")
  private[libnuklear] def __sn_wrap_nk_stroke_rect(b: Ptr[nk_command_buffer], rect: Ptr[nk_rect], rounding: Float, line_thickness: Float, c: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_stroke_triangle")
  private[libnuklear] def __sn_wrap_nk_stroke_triangle(b: Ptr[nk_command_buffer], x0: Float, y0: Float, x1: Float, y1: Float, x2: Float, y2: Float, line_thickness: Float, c: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_style_item_color")
  private[libnuklear] def __sn_wrap_nk_style_item_color(col: Ptr[nk_color], __return: Ptr[nk_style_item]): Unit = extern

  @name("__sn_wrap_nk_style_item_hide")
  private[libnuklear] def __sn_wrap_nk_style_item_hide(__return: Ptr[nk_style_item]): Unit = extern

  @name("__sn_wrap_nk_style_item_image")
  private[libnuklear] def __sn_wrap_nk_style_item_image(img: Ptr[nk_image], __return: Ptr[nk_style_item]): Unit = extern

  @name("__sn_wrap_nk_style_item_nine_slice")
  private[libnuklear] def __sn_wrap_nk_style_item_nine_slice(slice: Ptr[nk_nine_slice], __return: Ptr[nk_style_item]): Unit = extern

  @name("__sn_wrap_nk_style_push_color")
  private[libnuklear] def __sn_wrap_nk_style_push_color(ctx: Ptr[nk_context], address: Ptr[nk_color], value: Ptr[nk_color]): nk_bool = extern

  @name("__sn_wrap_nk_style_push_style_item")
  private[libnuklear] def __sn_wrap_nk_style_push_style_item(ctx: Ptr[nk_context], address: Ptr[nk_style_item], value: Ptr[nk_style_item]): nk_bool = extern

  @name("__sn_wrap_nk_style_push_vec2")
  private[libnuklear] def __sn_wrap_nk_style_push_vec2(ctx: Ptr[nk_context], address: Ptr[nk_vec2], value: Ptr[nk_vec2]): nk_bool = extern

  @name("__sn_wrap_nk_sub9slice_handle")
  private[libnuklear] def __sn_wrap_nk_sub9slice_handle(handle: nk_handle, w: nk_ushort, h: nk_ushort, rgn: Ptr[nk_rect], l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort, __return: Ptr[nk_nine_slice]): Unit = extern

  @name("__sn_wrap_nk_sub9slice_id")
  private[libnuklear] def __sn_wrap_nk_sub9slice_id(id: CInt, w: nk_ushort, h: nk_ushort, rgn: Ptr[nk_rect], l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort, __return: Ptr[nk_nine_slice]): Unit = extern

  @name("__sn_wrap_nk_sub9slice_ptr")
  private[libnuklear] def __sn_wrap_nk_sub9slice_ptr(ptr: Ptr[Byte], w: nk_ushort, h: nk_ushort, rgn: Ptr[nk_rect], l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort, __return: Ptr[nk_nine_slice]): Unit = extern

  @name("__sn_wrap_nk_subimage_handle")
  private[libnuklear] def __sn_wrap_nk_subimage_handle(handle: nk_handle, w: nk_ushort, h: nk_ushort, r: Ptr[nk_rect], __return: Ptr[nk_image]): Unit = extern

  @name("__sn_wrap_nk_subimage_id")
  private[libnuklear] def __sn_wrap_nk_subimage_id(id: CInt, w: nk_ushort, h: nk_ushort, r: Ptr[nk_rect], __return: Ptr[nk_image]): Unit = extern

  @name("__sn_wrap_nk_subimage_ptr")
  private[libnuklear] def __sn_wrap_nk_subimage_ptr(ptr: Ptr[Byte], w: nk_ushort, h: nk_ushort, r: Ptr[nk_rect], __return: Ptr[nk_image]): Unit = extern

  @name("__sn_wrap_nk_text_calculate_text_bounds")
  private[libnuklear] def __sn_wrap_nk_text_calculate_text_bounds(font: Ptr[nk_user_font], begin: CString, byte_len: CInt, row_height: Float, remaining: Ptr[CString], out_offset: Ptr[nk_vec2], glyphs: Ptr[CInt], op: CInt, __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_text_colored")
  private[libnuklear] def __sn_wrap_nk_text_colored(ctx: Ptr[nk_context], str: CString, len: CInt, alignment: nk_flags, color: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_text_wrap_colored")
  private[libnuklear] def __sn_wrap_nk_text_wrap_colored(ctx: Ptr[nk_context], str: CString, len: CInt, color: Ptr[nk_color]): Unit = extern

  @name("__sn_wrap_nk_toggle_behavior")
  private[libnuklear] def __sn_wrap_nk_toggle_behavior(in: Ptr[nk_input], select: Ptr[nk_rect], state: Ptr[nk_flags], active: nk_bool): nk_bool = extern

  @name("__sn_wrap_nk_tree_element_image_push_hashed")
  private[libnuklear] def __sn_wrap_nk_tree_element_image_push_hashed(ctx: Ptr[nk_context], `type`: nk_tree_type, img: Ptr[nk_image], title: CString, initial_state: nk_collapse_states, selected: Ptr[nk_bool], hash: CString, len: CInt, seed: CInt): nk_bool = extern

  @name("__sn_wrap_nk_tree_image_push_hashed")
  private[libnuklear] def __sn_wrap_nk_tree_image_push_hashed(ctx: Ptr[nk_context], `type`: nk_tree_type, img: Ptr[nk_image], title: CString, initial_state: nk_collapse_states, hash: CString, len: CInt, seed: CInt): nk_bool = extern

  @name("__sn_wrap_nk_tree_state_image_push")
  private[libnuklear] def __sn_wrap_nk_tree_state_image_push(ctx: Ptr[nk_context], `type`: nk_tree_type, img: Ptr[nk_image], title: CString, state: Ptr[nk_collapse_states]): nk_bool = extern

  @name("__sn_wrap_nk_triangle_from_direction")
  private[libnuklear] def __sn_wrap_nk_triangle_from_direction(result: Ptr[nk_vec2], r: Ptr[nk_rect], pad_x: Float, pad_y: Float, direction: nk_heading): Unit = extern

  @name("__sn_wrap_nk_vec2")
  private[libnuklear] def __sn_wrap_nk_vec2(x: Float, y: Float, __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_vec2i")
  private[libnuklear] def __sn_wrap_nk_vec2i(x: CInt, y: CInt, __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_vec2iv")
  private[libnuklear] def __sn_wrap_nk_vec2iv(xy: Ptr[CInt], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_vec2v")
  private[libnuklear] def __sn_wrap_nk_vec2v(xy: Ptr[Float], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_widget_bounds")
  private[libnuklear] def __sn_wrap_nk_widget_bounds(ctx: Ptr[nk_context], __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_widget_fitting")
  private[libnuklear] def __sn_wrap_nk_widget_fitting(bounds: Ptr[nk_rect], ctx: Ptr[nk_context], item_padding: Ptr[nk_vec2]): nk_widget_layout_states = extern

  @name("__sn_wrap_nk_widget_position")
  private[libnuklear] def __sn_wrap_nk_widget_position(ctx: Ptr[nk_context], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_widget_size")
  private[libnuklear] def __sn_wrap_nk_widget_size(ctx: Ptr[nk_context], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_widget_text")
  private[libnuklear] def __sn_wrap_nk_widget_text(o: Ptr[nk_command_buffer], b: Ptr[nk_rect], string: CString, len: CInt, t: Ptr[nk_text], a: nk_flags, f: Ptr[nk_user_font]): Unit = extern

  @name("__sn_wrap_nk_widget_text_wrap")
  private[libnuklear] def __sn_wrap_nk_widget_text_wrap(o: Ptr[nk_command_buffer], b: Ptr[nk_rect], string: CString, len: CInt, t: Ptr[nk_text], f: Ptr[nk_user_font]): Unit = extern

  @name("__sn_wrap_nk_window_get_bounds")
  private[libnuklear] def __sn_wrap_nk_window_get_bounds(ctx: Ptr[nk_context], __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_window_get_content_region")
  private[libnuklear] def __sn_wrap_nk_window_get_content_region(ctx: Ptr[nk_context], __return: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_window_get_content_region_max")
  private[libnuklear] def __sn_wrap_nk_window_get_content_region_max(ctx: Ptr[nk_context], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_window_get_content_region_min")
  private[libnuklear] def __sn_wrap_nk_window_get_content_region_min(ctx: Ptr[nk_context], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_window_get_content_region_size")
  private[libnuklear] def __sn_wrap_nk_window_get_content_region_size(ctx: Ptr[nk_context], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_window_get_position")
  private[libnuklear] def __sn_wrap_nk_window_get_position(ctx: Ptr[nk_context], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_window_get_size")
  private[libnuklear] def __sn_wrap_nk_window_get_size(ctx: Ptr[nk_context], __return: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_window_set_bounds")
  private[libnuklear] def __sn_wrap_nk_window_set_bounds(ctx: Ptr[nk_context], name: CString, bounds: Ptr[nk_rect]): Unit = extern

  @name("__sn_wrap_nk_window_set_position")
  private[libnuklear] def __sn_wrap_nk_window_set_position(ctx: Ptr[nk_context], name: CString, pos: Ptr[nk_vec2]): Unit = extern

  @name("__sn_wrap_nk_window_set_size")
  private[libnuklear] def __sn_wrap_nk_window_set_size(ctx: Ptr[nk_context], name: CString, size: Ptr[nk_vec2]): Unit = extern

  def nk__begin(ctx: Ptr[nk_context]): Ptr[nk_command] = extern

  def nk__next(ctx: Ptr[nk_context], cmd: Ptr[nk_command]): Ptr[nk_command] = extern

  def nk_add_value(ctx: Ptr[nk_context], win: Ptr[nk_window], name: nk_hash, value: nk_uint): Ptr[nk_uint] = extern

  def nk_buffer_align(unaligned: Ptr[Byte], align: nk_size, alignment: Ptr[nk_size], `type`: nk_buffer_allocation_type): Ptr[Byte] = extern

  def nk_buffer_alloc(b: Ptr[nk_buffer], `type`: nk_buffer_allocation_type, size: nk_size, align: nk_size): Ptr[Byte] = extern

  def nk_buffer_clear(b: Ptr[nk_buffer]): Unit = extern

  def nk_buffer_free(b: Ptr[nk_buffer]): Unit = extern

  def nk_buffer_info(s: Ptr[nk_memory_status], b: Ptr[nk_buffer]): Unit = extern

  def nk_buffer_init(b: Ptr[nk_buffer], a: Ptr[nk_allocator], initial_size: nk_size): Unit = extern

  def nk_buffer_init_fixed(b: Ptr[nk_buffer], m: Ptr[Byte], size: nk_size): Unit = extern

  def nk_buffer_mark(buffer: Ptr[nk_buffer], `type`: nk_buffer_allocation_type): Unit = extern

  def nk_buffer_memory(buffer: Ptr[nk_buffer]): Ptr[Byte] = extern

  def nk_buffer_memory_const(buffer: Ptr[nk_buffer]): Ptr[Byte] = extern

  def nk_buffer_push(b: Ptr[nk_buffer], `type`: nk_buffer_allocation_type, memory: Ptr[Byte], size: nk_size, align: nk_size): Unit = extern

  def nk_buffer_realloc(b: Ptr[nk_buffer], capacity: nk_size, size: Ptr[nk_size]): Ptr[Byte] = extern

  def nk_buffer_reset(buffer: Ptr[nk_buffer], `type`: nk_buffer_allocation_type): Unit = extern

  def nk_buffer_total(buffer: Ptr[nk_buffer]): nk_size = extern

  def nk_build(ctx: Ptr[nk_context]): Unit = extern

  def nk_button_label(ctx: Ptr[nk_context], title: CString): nk_bool = extern

  def nk_button_label_styled(ctx: Ptr[nk_context], style: Ptr[nk_style_button], title: CString): nk_bool = extern

  def nk_button_pop_behavior(ctx: Ptr[nk_context]): nk_bool = extern

  def nk_button_push_behavior(ctx: Ptr[nk_context], behavior: nk_button_behavior): nk_bool = extern

  def nk_button_set_behavior(ctx: Ptr[nk_context], behavior: nk_button_behavior): Unit = extern

  def nk_button_symbol(ctx: Ptr[nk_context], symbol: nk_symbol_type): nk_bool = extern

  def nk_button_symbol_label(ctx: Ptr[nk_context], symbol: nk_symbol_type, label: CString, align: nk_flags): nk_bool = extern

  def nk_button_symbol_label_styled(ctx: Ptr[nk_context], style: Ptr[nk_style_button], symbol: nk_symbol_type, title: CString, align: nk_flags): nk_bool = extern

  def nk_button_symbol_styled(ctx: Ptr[nk_context], style: Ptr[nk_style_button], symbol: nk_symbol_type): nk_bool = extern

  def nk_button_symbol_text(ctx: Ptr[nk_context], symbol: nk_symbol_type, text: CString, len: CInt, align: nk_flags): nk_bool = extern

  def nk_button_symbol_text_styled(ctx: Ptr[nk_context], style: Ptr[nk_style_button], symbol: nk_symbol_type, text: CString, len: CInt, align: nk_flags): nk_bool = extern

  def nk_button_text(ctx: Ptr[nk_context], title: CString, len: CInt): nk_bool = extern

  def nk_button_text_styled(ctx: Ptr[nk_context], style: Ptr[nk_style_button], title: CString, len: CInt): nk_bool = extern

  def nk_chart_add_slot(ctx: Ptr[nk_context], `type`: nk_chart_type, count: CInt, min_value: Float, max_value: Float): Unit = extern

  def nk_chart_begin(ctx: Ptr[nk_context], `type`: nk_chart_type, count: CInt, min_value: Float, max_value: Float): nk_bool = extern

  def nk_chart_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_chart_push(ctx: Ptr[nk_context], value: Float): nk_flags = extern

  def nk_chart_push_column(ctx: Ptr[nk_context], win: Ptr[nk_window], chart: Ptr[nk_chart], value: Float, slot: CInt): nk_flags = extern

  def nk_chart_push_line(ctx: Ptr[nk_context], win: Ptr[nk_window], g: Ptr[nk_chart], value: Float, slot: CInt): nk_flags = extern

  def nk_chart_push_slot(ctx: Ptr[nk_context], value: Float, slot: CInt): nk_flags = extern

  def nk_check_flags_label(ctx: Ptr[nk_context], label: CString, flags: CUnsignedInt, value: CUnsignedInt): CUnsignedInt = extern

  def nk_check_flags_text(ctx: Ptr[nk_context], text: CString, len: CInt, flags: CUnsignedInt, value: CUnsignedInt): CUnsignedInt = extern

  def nk_check_label(ctx: Ptr[nk_context], label: CString, active: nk_bool): nk_bool = extern

  def nk_check_text(ctx: Ptr[nk_context], text: CString, len: CInt, active: nk_bool): nk_bool = extern

  def nk_checkbox_flags_label(ctx: Ptr[nk_context], label: CString, flags: Ptr[CUnsignedInt], value: CUnsignedInt): nk_bool = extern

  def nk_checkbox_flags_text(ctx: Ptr[nk_context], text: CString, len: CInt, flags: Ptr[CUnsignedInt], value: CUnsignedInt): nk_bool = extern

  def nk_checkbox_label(ctx: Ptr[nk_context], label: CString, active: Ptr[nk_bool]): nk_bool = extern

  def nk_checkbox_text(ctx: Ptr[nk_context], text: CString, len: CInt, active: Ptr[nk_bool]): nk_bool = extern

  def nk_clear(ctx: Ptr[nk_context]): Unit = extern

  def nk_color_pick(ctx: Ptr[nk_context], color: Ptr[nk_colorf], fmt: nk_color_format): nk_bool = extern

  def nk_color_picker_behavior(state: Ptr[nk_flags], bounds: Ptr[nk_rect], matrix: Ptr[nk_rect], hue_bar: Ptr[nk_rect], alpha_bar: Ptr[nk_rect], color: Ptr[nk_colorf], in: Ptr[nk_input]): nk_bool = extern

  def nk_combo_close(ctx: Ptr[nk_context]): Unit = extern

  def nk_combo_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_combo_item_label(ctx: Ptr[nk_context], label: CString, align: nk_flags): nk_bool = extern

  def nk_combo_item_symbol_label(ctx: Ptr[nk_context], sym: nk_symbol_type, label: CString, alignment: nk_flags): nk_bool = extern

  def nk_combo_item_symbol_text(ctx: Ptr[nk_context], sym: nk_symbol_type, text: CString, len: CInt, alignment: nk_flags): nk_bool = extern

  def nk_combo_item_text(ctx: Ptr[nk_context], text: CString, len: CInt, align: nk_flags): nk_bool = extern

  def nk_command_buffer_init(cb: Ptr[nk_command_buffer], b: Ptr[nk_buffer], clip: nk_command_clipping): Unit = extern

  def nk_command_buffer_push(b: Ptr[nk_command_buffer], t: nk_command_type, size: nk_size): Ptr[Byte] = extern

  def nk_command_buffer_reset(b: Ptr[nk_command_buffer]): Unit = extern

  def nk_contextual_close(ctx: Ptr[nk_context]): Unit = extern

  def nk_contextual_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_contextual_item_label(ctx: Ptr[nk_context], label: CString, align: nk_flags): nk_bool = extern

  def nk_contextual_item_symbol_label(ctx: Ptr[nk_context], symbol: nk_symbol_type, text: CString, align: nk_flags): nk_bool = extern

  def nk_contextual_item_symbol_text(ctx: Ptr[nk_context], symbol: nk_symbol_type, text: CString, len: CInt, align: nk_flags): nk_bool = extern

  def nk_contextual_item_text(ctx: Ptr[nk_context], text: CString, len: CInt, alignment: nk_flags): nk_bool = extern

  def nk_cos(x: Float): Float = extern

  def nk_create_page_element(ctx: Ptr[nk_context]): Ptr[nk_page_element] = extern

  def nk_create_panel(ctx: Ptr[nk_context]): Ptr[Byte] = extern

  def nk_create_table(ctx: Ptr[nk_context]): Ptr[nk_table] = extern

  def nk_create_window(ctx: Ptr[nk_context]): Ptr[Byte] = extern

  def nk_draw_button(out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], state: nk_flags, style: Ptr[nk_style_button]): Ptr[nk_style_item] = extern

  def nk_draw_button_image(out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], content: Ptr[nk_rect], state: nk_flags, style: Ptr[nk_style_button], img: Ptr[nk_image]): Unit = extern

  def nk_draw_button_symbol(out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], content: Ptr[nk_rect], state: nk_flags, style: Ptr[nk_style_button], `type`: nk_symbol_type, font: Ptr[nk_user_font]): Unit = extern

  def nk_draw_button_text(out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], content: Ptr[nk_rect], state: nk_flags, style: Ptr[nk_style_button], txt: CString, len: CInt, text_alignment: nk_flags, font: Ptr[nk_user_font]): Unit = extern

  def nk_draw_button_text_image(out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], label: Ptr[nk_rect], image: Ptr[nk_rect], state: nk_flags, style: Ptr[nk_style_button], str: CString, len: CInt, font: Ptr[nk_user_font], img: Ptr[nk_image]): Unit = extern

  def nk_draw_button_text_symbol(out: Ptr[nk_command_buffer], bounds: Ptr[nk_rect], label: Ptr[nk_rect], symbol: Ptr[nk_rect], state: nk_flags, style: Ptr[nk_style_button], str: CString, len: CInt, `type`: nk_symbol_type, font: Ptr[nk_user_font]): Unit = extern

  def nk_draw_checkbox(out: Ptr[nk_command_buffer], state: nk_flags, style: Ptr[nk_style_toggle], active: nk_bool, label: Ptr[nk_rect], selector: Ptr[nk_rect], cursors: Ptr[nk_rect], string: CString, len: CInt, font: Ptr[nk_user_font]): Unit = extern

  def nk_draw_option(out: Ptr[nk_command_buffer], state: nk_flags, style: Ptr[nk_style_toggle], active: nk_bool, label: Ptr[nk_rect], selector: Ptr[nk_rect], cursors: Ptr[nk_rect], string: CString, len: CInt, font: Ptr[nk_user_font]): Unit = extern

  def nk_draw_progress(out: Ptr[nk_command_buffer], state: nk_flags, style: Ptr[nk_style_progress], bounds: Ptr[nk_rect], scursor: Ptr[nk_rect], value: nk_size, max: nk_size): Unit = extern

  def nk_draw_property(out: Ptr[nk_command_buffer], style: Ptr[nk_style_property], bounds: Ptr[nk_rect], label: Ptr[nk_rect], state: nk_flags, name: CString, len: CInt, font: Ptr[nk_user_font]): Unit = extern

  def nk_draw_scrollbar(out: Ptr[nk_command_buffer], state: nk_flags, style: Ptr[nk_style_scrollbar], bounds: Ptr[nk_rect], scroll: Ptr[nk_rect]): Unit = extern

  def nk_draw_selectable(out: Ptr[nk_command_buffer], state: nk_flags, style: Ptr[nk_style_selectable], active: nk_bool, bounds: Ptr[nk_rect], icon: Ptr[nk_rect], img: Ptr[nk_image], sym: nk_symbol_type, string: CString, len: CInt, align: nk_flags, font: Ptr[nk_user_font]): Unit = extern

  def nk_draw_slider(out: Ptr[nk_command_buffer], state: nk_flags, style: Ptr[nk_style_slider], bounds: Ptr[nk_rect], visual_cursor: Ptr[nk_rect], min: Float, value: Float, max: Float): Unit = extern

  def nk_dtoa(s: CString, n: Double): CString = extern

  def nk_edit_buffer(ctx: Ptr[nk_context], flags: nk_flags, edit: Ptr[nk_text_edit], filter: nk_plugin_filter): nk_flags = extern

  def nk_edit_focus(ctx: Ptr[nk_context], flags: nk_flags): Unit = extern

  def nk_edit_string(ctx: Ptr[nk_context], flags: nk_flags, memory: CString, len: Ptr[CInt], max: CInt, filter: nk_plugin_filter): nk_flags = extern

  def nk_edit_string_zero_terminated(ctx: Ptr[nk_context], flags: nk_flags, buffer: CString, max: CInt, filter: nk_plugin_filter): nk_flags = extern

  def nk_edit_unfocus(ctx: Ptr[nk_context]): Unit = extern

  def nk_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_filter_ascii(box: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_filter_binary(box: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_filter_decimal(box: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_filter_default(box: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_filter_float(box: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_filter_hex(box: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_filter_oct(box: Ptr[nk_text_edit], unicode: nk_rune): nk_bool = extern

  def nk_find_value(win: Ptr[nk_window], name: nk_hash): Ptr[nk_uint] = extern

  def nk_find_window(ctx: Ptr[nk_context], hash: nk_hash, name: CString): Ptr[nk_window] = extern

  def nk_finish(ctx: Ptr[nk_context], w: Ptr[nk_window]): Unit = extern

  def nk_finish_buffer(ctx: Ptr[nk_context], buffer: Ptr[nk_command_buffer]): Unit = extern

  def nk_finish_popup(ctx: Ptr[nk_context], win: Ptr[nk_window]): Unit = extern

  def nk_free(ctx: Ptr[nk_context]): Unit = extern

  def nk_free_page_element(ctx: Ptr[nk_context], elem: Ptr[nk_page_element]): Unit = extern

  def nk_free_panel(ctx: Ptr[nk_context], pan: Ptr[nk_panel]): Unit = extern

  def nk_free_table(ctx: Ptr[nk_context], tbl: Ptr[nk_table]): Unit = extern

  def nk_free_window(ctx: Ptr[nk_context], win: Ptr[nk_window]): Unit = extern

  def nk_group_begin(ctx: Ptr[nk_context], title: CString, flags: nk_flags): nk_bool = extern

  def nk_group_begin_titled(ctx: Ptr[nk_context], id: CString, title: CString, flags: nk_flags): nk_bool = extern

  def nk_group_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_group_get_scroll(ctx: Ptr[nk_context], id: CString, x_offset: Ptr[nk_uint], y_offset: Ptr[nk_uint]): Unit = extern

  def nk_group_scrolled_begin(ctx: Ptr[nk_context], scroll: Ptr[nk_scroll], title: CString, flags: nk_flags): nk_bool = extern

  def nk_group_scrolled_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_group_scrolled_offset_begin(ctx: Ptr[nk_context], x_offset: Ptr[nk_uint], y_offset: Ptr[nk_uint], title: CString, flags: nk_flags): nk_bool = extern

  def nk_group_set_scroll(ctx: Ptr[nk_context], id: CString, x_offset: nk_uint, y_offset: nk_uint): Unit = extern

  def nk_handle_id(id: CInt): nk_handle = extern

  def nk_handle_ptr(ptr: Ptr[Byte]): nk_handle = extern

  def nk_iceilf(x: Float): CInt = extern

  def nk_ifloord(x: Double): CInt = extern

  def nk_ifloorf(x: Float): CInt = extern

  def nk_image_is_subimage(img: Ptr[nk_image]): nk_bool = extern

  def nk_init(ctx: Ptr[nk_context], alloc: Ptr[nk_allocator], font: Ptr[nk_user_font]): nk_bool = extern

  def nk_init_custom(ctx: Ptr[nk_context], cmds: Ptr[nk_buffer], pool: Ptr[nk_buffer], font: Ptr[nk_user_font]): nk_bool = extern

  def nk_init_fixed(ctx: Ptr[nk_context], memory: Ptr[Byte], size: nk_size, font: Ptr[nk_user_font]): nk_bool = extern

  def nk_input_begin(ctx: Ptr[nk_context]): Unit = extern

  def nk_input_button(ctx: Ptr[nk_context], id: nk_buttons, x: CInt, y: CInt, down: nk_bool): Unit = extern

  def nk_input_char(ctx: Ptr[nk_context], c: CChar): Unit = extern

  def nk_input_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_input_glyph(ctx: Ptr[nk_context], glyph: nk_glyph): Unit = extern

  def nk_input_has_mouse_click(i: Ptr[nk_input], id: nk_buttons): nk_bool = extern

  def nk_input_is_key_down(i: Ptr[nk_input], key: nk_keys): nk_bool = extern

  def nk_input_is_key_pressed(i: Ptr[nk_input], key: nk_keys): nk_bool = extern

  def nk_input_is_key_released(i: Ptr[nk_input], key: nk_keys): nk_bool = extern

  def nk_input_is_mouse_down(i: Ptr[nk_input], id: nk_buttons): nk_bool = extern

  def nk_input_is_mouse_pressed(i: Ptr[nk_input], id: nk_buttons): nk_bool = extern

  def nk_input_is_mouse_released(i: Ptr[nk_input], id: nk_buttons): nk_bool = extern

  def nk_input_key(ctx: Ptr[nk_context], key: nk_keys, down: nk_bool): Unit = extern

  def nk_input_motion(ctx: Ptr[nk_context], x: CInt, y: CInt): Unit = extern

  def nk_input_unicode(ctx: Ptr[nk_context], unicode: nk_rune): Unit = extern

  def nk_insert_window(ctx: Ptr[nk_context], win: Ptr[nk_window], loc: nk_window_insert_location): Unit = extern

  def nk_inv_sqrt(n: Float): Float = extern

  def nk_is_lower(c: CInt): nk_bool = extern

  def nk_is_upper(c: CInt): nk_bool = extern

  def nk_is_word_boundary(state: Ptr[nk_text_edit], idx: CInt): CInt = extern

  def nk_item_is_any_active(ctx: Ptr[nk_context]): nk_bool = extern

  def nk_itoa(s: CString, n: CLongInt): CString = extern

  def nk_label(ctx: Ptr[nk_context], str: CString, alignment: nk_flags): Unit = extern

  def nk_label_wrap(ctx: Ptr[nk_context], str: CString): Unit = extern

  def nk_layout_peek(bounds: Ptr[nk_rect], ctx: Ptr[nk_context]): Unit = extern

  def nk_layout_ratio_from_pixel(ctx: Ptr[nk_context], pixel_width: Float): Float = extern

  def nk_layout_reset_min_row_height(ctx: Ptr[nk_context]): Unit = extern

  def nk_layout_row(ctx: Ptr[nk_context], fmt: nk_layout_format, height: Float, cols: CInt, ratio: Ptr[Float]): Unit = extern

  def nk_layout_row_begin(ctx: Ptr[nk_context], fmt: nk_layout_format, row_height: Float, cols: CInt): Unit = extern

  def nk_layout_row_calculate_usable_space(style: Ptr[nk_style], `type`: nk_panel_type, total_space: Float, columns: CInt): Float = extern

  def nk_layout_row_dynamic(ctx: Ptr[nk_context], height: Float, cols: CInt): Unit = extern

  def nk_layout_row_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_layout_row_push(ctx: Ptr[nk_context], ratio_or_width: Float): Unit = extern

  def nk_layout_row_static(ctx: Ptr[nk_context], height: Float, item_width: CInt, cols: CInt): Unit = extern

  def nk_layout_row_template_begin(ctx: Ptr[nk_context], height: Float): Unit = extern

  def nk_layout_row_template_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_layout_row_template_push_dynamic(ctx: Ptr[nk_context]): Unit = extern

  def nk_layout_row_template_push_static(ctx: Ptr[nk_context], width: Float): Unit = extern

  def nk_layout_row_template_push_variable(ctx: Ptr[nk_context], min_width: Float): Unit = extern

  def nk_layout_set_min_row_height(ctx: Ptr[nk_context], height: Float): Unit = extern

  def nk_layout_space_begin(ctx: Ptr[nk_context], fmt: nk_layout_format, height: Float, widget_count: CInt): Unit = extern

  def nk_layout_space_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_layout_widget_space(bounds: Ptr[nk_rect], ctx: Ptr[nk_context], win: Ptr[nk_window], modify: CInt): Unit = extern

  def nk_link_page_element_into_freelist(ctx: Ptr[nk_context], elem: Ptr[nk_page_element]): Unit = extern

  def nk_list_view_begin(ctx: Ptr[nk_context], view: Ptr[nk_list_view], title: CString, flags: nk_flags, row_height: CInt, row_count: CInt): nk_bool = extern

  def nk_list_view_end(view: Ptr[nk_list_view]): Unit = extern

  def nk_log10(n: Double): CInt = extern

  def nk_memcopy(dst0: Ptr[Byte], src0: Ptr[Byte], length: nk_size): Ptr[Byte] = extern

  def nk_memset(ptr: Ptr[Byte], c0: CInt, size: nk_size): Unit = extern

  def nk_menu_close(ctx: Ptr[nk_context]): Unit = extern

  def nk_menu_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_menu_item_label(ctx: Ptr[nk_context], label: CString, align: nk_flags): nk_bool = extern

  def nk_menu_item_symbol_label(ctx: Ptr[nk_context], sym: nk_symbol_type, label: CString, align: nk_flags): nk_bool = extern

  def nk_menu_item_symbol_text(ctx: Ptr[nk_context], sym: nk_symbol_type, text: CString, len: CInt, align: nk_flags): nk_bool = extern

  def nk_menu_item_text(ctx: Ptr[nk_context], title: CString, len: CInt, align: nk_flags): nk_bool = extern

  def nk_menubar_begin(ctx: Ptr[nk_context]): Unit = extern

  def nk_menubar_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_murmur_hash(key: Ptr[Byte], len: CInt, seed: nk_hash): nk_hash = extern

  def nk_nine_slice_is_sub9slice(slice: Ptr[nk_nine_slice]): CInt = extern

  def nk_option_label(ctx: Ptr[nk_context], label: CString, active: nk_bool): nk_bool = extern

  def nk_option_text(ctx: Ptr[nk_context], text: CString, len: CInt, is_active: nk_bool): nk_bool = extern

  def nk_panel_alloc_row(ctx: Ptr[nk_context], win: Ptr[nk_window]): Unit = extern

  def nk_panel_alloc_space(bounds: Ptr[nk_rect], ctx: Ptr[nk_context]): Unit = extern

  def nk_panel_begin(ctx: Ptr[nk_context], title: CString, panel_type: nk_panel_type): nk_bool = extern

  def nk_panel_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_panel_get_border(style: Ptr[nk_style], flags: nk_flags, `type`: nk_panel_type): Float = extern

  def nk_panel_has_header(flags: nk_flags, title: CString): nk_bool = extern

  def nk_panel_is_nonblock(`type`: nk_panel_type): nk_bool = extern

  def nk_panel_is_sub(`type`: nk_panel_type): nk_bool = extern

  def nk_panel_layout(ctx: Ptr[nk_context], win: Ptr[nk_window], height: Float, cols: CInt): Unit = extern

  def nk_parse_hex(p: CString, length: CInt): CInt = extern

  def nk_plot(ctx: Ptr[nk_context], `type`: nk_chart_type, values: Ptr[Float], count: CInt, offset: CInt): Unit = extern

  def nk_plot_function(ctx: Ptr[nk_context], `type`: nk_chart_type, userdata: Ptr[Byte], value_getter: CFuncPtr2[Ptr[Byte], CInt, Float], count: CInt, offset: CInt): Unit = extern

  def nk_pool_alloc(pool: Ptr[nk_pool]): Ptr[nk_page_element] = extern

  def nk_pool_free(pool: Ptr[nk_pool]): Unit = extern

  def nk_pool_init(pool: Ptr[nk_pool], alloc: Ptr[nk_allocator], capacity: CUnsignedInt): Unit = extern

  def nk_pool_init_fixed(pool: Ptr[nk_pool], memory: Ptr[Byte], size: nk_size): Unit = extern

  def nk_popup_close(ctx: Ptr[nk_context]): Unit = extern

  def nk_popup_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_popup_get_scroll(ctx: Ptr[nk_context], offset_x: Ptr[nk_uint], offset_y: Ptr[nk_uint]): Unit = extern

  def nk_popup_set_scroll(ctx: Ptr[nk_context], offset_x: nk_uint, offset_y: nk_uint): Unit = extern

  def nk_pow(x: Double, n: CInt): Double = extern

  def nk_prog(ctx: Ptr[nk_context], cur: nk_size, max: nk_size, modifyable: nk_bool): nk_size = extern

  def nk_progress(ctx: Ptr[nk_context], cur: Ptr[nk_size], max: nk_size, is_modifyable: nk_bool): nk_bool = extern

  def nk_property(ctx: Ptr[nk_context], name: CString, variant: Ptr[nk_property_variant], inc_per_pixel: Float, filter: nk_property_filter): Unit = extern

  def nk_property_double(ctx: Ptr[nk_context], name: CString, min: Double, `val`: Ptr[Double], max: Double, step: Double, inc_per_pixel: Float): Unit = extern

  def nk_property_float(ctx: Ptr[nk_context], name: CString, min: Float, `val`: Ptr[Float], max: Float, step: Float, inc_per_pixel: Float): Unit = extern

  def nk_property_int(ctx: Ptr[nk_context], name: CString, min: CInt, `val`: Ptr[CInt], max: CInt, step: CInt, inc_per_pixel: Float): Unit = extern

  def nk_propertyd(ctx: Ptr[nk_context], name: CString, min: Double, `val`: Double, max: Double, step: Double, inc_per_pixel: Float): Double = extern

  def nk_propertyf(ctx: Ptr[nk_context], name: CString, min: Float, `val`: Float, max: Float, step: Float, inc_per_pixel: Float): Float = extern

  def nk_propertyi(ctx: Ptr[nk_context], name: CString, min: CInt, `val`: CInt, max: CInt, step: CInt, inc_per_pixel: Float): CInt = extern

  def nk_push_table(win: Ptr[nk_window], tbl: Ptr[nk_table]): Unit = extern

  def nk_radio_label(ctx: Ptr[nk_context], label: CString, active: Ptr[nk_bool]): nk_bool = extern

  def nk_radio_text(ctx: Ptr[nk_context], text: CString, len: CInt, active: Ptr[nk_bool]): nk_bool = extern

  def nk_remove_table(win: Ptr[nk_window], tbl: Ptr[nk_table]): Unit = extern

  def nk_remove_window(ctx: Ptr[nk_context], win: Ptr[nk_window]): Unit = extern

  def nk_round_up_pow2(v: nk_uint): nk_uint = extern

  def nk_row_layout(ctx: Ptr[nk_context], fmt: nk_layout_format, height: Float, cols: CInt, width: CInt): Unit = extern

  def nk_scrollbar_behavior(state: Ptr[nk_flags], in: Ptr[nk_input], has_scrolling: CInt, scroll: Ptr[nk_rect], cursor: Ptr[nk_rect], empty0: Ptr[nk_rect], empty1: Ptr[nk_rect], scroll_offset: Float, target: Float, scroll_step: Float, o: nk_orientation): Float = extern

  def nk_select_label(ctx: Ptr[nk_context], str: CString, align: nk_flags, value: nk_bool): nk_bool = extern

  def nk_select_symbol_label(ctx: Ptr[nk_context], sym: nk_symbol_type, title: CString, align: nk_flags, value: nk_bool): nk_bool = extern

  def nk_select_symbol_text(ctx: Ptr[nk_context], sym: nk_symbol_type, title: CString, title_len: CInt, align: nk_flags, value: nk_bool): nk_bool = extern

  def nk_select_text(ctx: Ptr[nk_context], str: CString, len: CInt, align: nk_flags, value: nk_bool): nk_bool = extern

  def nk_selectable_label(ctx: Ptr[nk_context], str: CString, align: nk_flags, value: Ptr[nk_bool]): nk_bool = extern

  def nk_selectable_symbol_label(ctx: Ptr[nk_context], sym: nk_symbol_type, title: CString, align: nk_flags, value: Ptr[nk_bool]): nk_bool = extern

  def nk_selectable_symbol_text(ctx: Ptr[nk_context], sym: nk_symbol_type, str: CString, len: CInt, align: nk_flags, value: Ptr[nk_bool]): nk_bool = extern

  def nk_selectable_text(ctx: Ptr[nk_context], str: CString, len: CInt, align: nk_flags, value: Ptr[nk_bool]): nk_bool = extern

  def nk_setup(ctx: Ptr[nk_context], font: Ptr[nk_user_font]): Unit = extern

  def nk_sin(x: Float): Float = extern

  def nk_slide_float(ctx: Ptr[nk_context], min: Float, `val`: Float, max: Float, step: Float): Float = extern

  def nk_slide_int(ctx: Ptr[nk_context], min: CInt, `val`: CInt, max: CInt, step: CInt): CInt = extern

  def nk_slider_float(ctx: Ptr[nk_context], min_value: Float, value: Ptr[Float], max_value: Float, value_step: Float): nk_bool = extern

  def nk_slider_int(ctx: Ptr[nk_context], min: CInt, `val`: Ptr[CInt], max: CInt, step: CInt): nk_bool = extern

  def nk_spacer(ctx: Ptr[nk_context]): Unit = extern

  def nk_spacing(ctx: Ptr[nk_context], cols: CInt): Unit = extern

  def nk_start(ctx: Ptr[nk_context], win: Ptr[nk_window]): Unit = extern

  def nk_start_buffer(ctx: Ptr[nk_context], b: Ptr[nk_command_buffer]): Unit = extern

  def nk_start_popup(ctx: Ptr[nk_context], win: Ptr[nk_window]): Unit = extern

  def nk_str_append_str_char(s: Ptr[nk_str], str: CString): CInt = extern

  def nk_str_append_str_runes(str: Ptr[nk_str], runes: Ptr[nk_rune]): CInt = extern

  def nk_str_append_str_utf8(str: Ptr[nk_str], text: CString): CInt = extern

  def nk_str_append_text_char(s: Ptr[nk_str], str: CString, len: CInt): CInt = extern

  def nk_str_append_text_runes(str: Ptr[nk_str], text: Ptr[nk_rune], len: CInt): CInt = extern

  def nk_str_append_text_utf8(str: Ptr[nk_str], text: CString, len: CInt): CInt = extern

  def nk_str_at_char(s: Ptr[nk_str], pos: CInt): CString = extern

  def nk_str_at_char_const(s: Ptr[nk_str], pos: CInt): CString = extern

  def nk_str_at_const(str: Ptr[nk_str], pos: CInt, unicode: Ptr[nk_rune], len: Ptr[CInt]): CString = extern

  def nk_str_at_rune(str: Ptr[nk_str], pos: CInt, unicode: Ptr[nk_rune], len: Ptr[CInt]): CString = extern

  def nk_str_clear(str: Ptr[nk_str]): Unit = extern

  def nk_str_delete_chars(s: Ptr[nk_str], pos: CInt, len: CInt): Unit = extern

  def nk_str_delete_runes(s: Ptr[nk_str], pos: CInt, len: CInt): Unit = extern

  def nk_str_free(str: Ptr[nk_str]): Unit = extern

  def nk_str_get(s: Ptr[nk_str]): CString = extern

  def nk_str_get_const(s: Ptr[nk_str]): CString = extern

  def nk_str_init(str: Ptr[nk_str], alloc: Ptr[nk_allocator], size: nk_size): Unit = extern

  def nk_str_init_fixed(str: Ptr[nk_str], memory: Ptr[Byte], size: nk_size): Unit = extern

  def nk_str_insert_at_char(s: Ptr[nk_str], pos: CInt, str: CString, len: CInt): CInt = extern

  def nk_str_insert_at_rune(str: Ptr[nk_str], pos: CInt, cstr: CString, len: CInt): CInt = extern

  def nk_str_insert_str_char(str: Ptr[nk_str], pos: CInt, text: CString): CInt = extern

  def nk_str_insert_str_runes(str: Ptr[nk_str], pos: CInt, runes: Ptr[nk_rune]): CInt = extern

  def nk_str_insert_str_utf8(str: Ptr[nk_str], pos: CInt, text: CString): CInt = extern

  def nk_str_insert_text_char(str: Ptr[nk_str], pos: CInt, text: CString, len: CInt): CInt = extern

  def nk_str_insert_text_runes(str: Ptr[nk_str], pos: CInt, runes: Ptr[nk_rune], len: CInt): CInt = extern

  def nk_str_insert_text_utf8(str: Ptr[nk_str], pos: CInt, text: CString, len: CInt): CInt = extern

  def nk_str_len(s: Ptr[nk_str]): CInt = extern

  def nk_str_len_char(s: Ptr[nk_str]): CInt = extern

  def nk_str_match_here(regexp: CString, text: CString): CInt = extern

  def nk_str_match_star(c: CInt, regexp: CString, text: CString): CInt = extern

  def nk_str_remove_chars(s: Ptr[nk_str], len: CInt): Unit = extern

  def nk_str_remove_runes(str: Ptr[nk_str], len: CInt): Unit = extern

  def nk_str_rune_at(str: Ptr[nk_str], pos: CInt): nk_rune = extern

  def nk_strfilter(text: CString, regexp: CString): CInt = extern

  def nk_stricmp(s1: CString, s2: CString): CInt = extern

  def nk_stricmpn(s1: CString, s2: CString, n: CInt): CInt = extern

  def nk_string_float_limit(string: CString, prec: CInt): CInt = extern

  def nk_strlen(str: CString): CInt = extern

  def nk_strmatch_fuzzy_string(str: CString, pattern: CString, out_score: Ptr[CInt]): CInt = extern

  def nk_strmatch_fuzzy_text(txt: CString, txt_len: CInt, pattern: CString, out_score: Ptr[CInt]): CInt = extern

  def nk_strrev_ascii(s: CString): Unit = extern

  def nk_strtod(str: CString, endptr: Ptr[CString]): Double = extern

  def nk_strtof(str: CString, endptr: Ptr[CString]): Float = extern

  def nk_strtoi(str: CString, endptr: Ptr[CString]): CInt = extern

  def nk_style_default(ctx: Ptr[nk_context]): Unit = extern

  def nk_style_from_table(ctx: Ptr[nk_context], table: Ptr[nk_color]): Unit = extern

  def nk_style_get_color_by_name(c: nk_style_colors): CString = extern

  def nk_style_hide_cursor(ctx: Ptr[nk_context]): Unit = extern

  def nk_style_load_all_cursors(ctx: Ptr[nk_context], cursors: Ptr[nk_cursor]): Unit = extern

  def nk_style_load_cursor(ctx: Ptr[nk_context], cursor: nk_style_cursor, c: Ptr[nk_cursor]): Unit = extern

  def nk_style_pop_color(ctx: Ptr[nk_context]): nk_bool = extern

  def nk_style_pop_flags(ctx: Ptr[nk_context]): nk_bool = extern

  def nk_style_pop_float(ctx: Ptr[nk_context]): nk_bool = extern

  def nk_style_pop_font(ctx: Ptr[nk_context]): nk_bool = extern

  def nk_style_pop_style_item(ctx: Ptr[nk_context]): nk_bool = extern

  def nk_style_pop_vec2(ctx: Ptr[nk_context]): nk_bool = extern

  def nk_style_push_flags(ctx: Ptr[nk_context], address: Ptr[nk_flags], value: nk_flags): nk_bool = extern

  def nk_style_push_float(ctx: Ptr[nk_context], address: Ptr[Float], value: Float): nk_bool = extern

  def nk_style_push_font(ctx: Ptr[nk_context], font: Ptr[nk_user_font]): nk_bool = extern

  def nk_style_set_cursor(ctx: Ptr[nk_context], c: nk_style_cursor): nk_bool = extern

  def nk_style_set_font(ctx: Ptr[nk_context], font: Ptr[nk_user_font]): Unit = extern

  def nk_style_show_cursor(ctx: Ptr[nk_context]): Unit = extern

  def nk_text(ctx: Ptr[nk_context], str: CString, len: CInt, alignment: nk_flags): Unit = extern

  def nk_text_clamp(font: Ptr[nk_user_font], text: CString, text_len: CInt, space: Float, glyphs: Ptr[CInt], text_width: Ptr[Float], sep_list: Ptr[nk_rune], sep_count: CInt): CInt = extern

  def nk_text_wrap(ctx: Ptr[nk_context], str: CString, len: CInt): Unit = extern

  def nk_textedit_clamp(state: Ptr[nk_text_edit]): Unit = extern

  def nk_textedit_clear_state(state: Ptr[nk_text_edit], `type`: nk_text_edit_type, filter: nk_plugin_filter): Unit = extern

  def nk_textedit_click(state: Ptr[nk_text_edit], x: Float, y: Float, font: Ptr[nk_user_font], row_height: Float): Unit = extern

  def nk_textedit_create_undo_record(state: Ptr[nk_text_undo_state], numchars: CInt): Ptr[nk_text_undo_record] = extern

  def nk_textedit_createundo(state: Ptr[nk_text_undo_state], pos: CInt, insert_len: CInt, delete_len: CInt): Ptr[nk_rune] = extern

  def nk_textedit_cut(state: Ptr[nk_text_edit]): nk_bool = extern

  def nk_textedit_delete(state: Ptr[nk_text_edit], where: CInt, len: CInt): Unit = extern

  def nk_textedit_delete_selection(state: Ptr[nk_text_edit]): Unit = extern

  def nk_textedit_discard_redo(state: Ptr[nk_text_undo_state]): Unit = extern

  def nk_textedit_discard_undo(state: Ptr[nk_text_undo_state]): Unit = extern

  def nk_textedit_drag(state: Ptr[nk_text_edit], x: Float, y: Float, font: Ptr[nk_user_font], row_height: Float): Unit = extern

  def nk_textedit_find_charpos(find: Ptr[nk_text_find], state: Ptr[nk_text_edit], n: CInt, single_line: CInt, font: Ptr[nk_user_font], row_height: Float): Unit = extern

  def nk_textedit_flush_redo(state: Ptr[nk_text_undo_state]): Unit = extern

  def nk_textedit_free(state: Ptr[nk_text_edit]): Unit = extern

  def nk_textedit_get_width(edit: Ptr[nk_text_edit], line_start: CInt, char_id: CInt, font: Ptr[nk_user_font]): Float = extern

  def nk_textedit_init(state: Ptr[nk_text_edit], alloc: Ptr[nk_allocator], size: nk_size): Unit = extern

  def nk_textedit_init_fixed(state: Ptr[nk_text_edit], memory: Ptr[Byte], size: nk_size): Unit = extern

  def nk_textedit_key(state: Ptr[nk_text_edit], key: nk_keys, shift_mod: CInt, font: Ptr[nk_user_font], row_height: Float): Unit = extern

  def nk_textedit_layout_row(r: Ptr[nk_text_edit_row], edit: Ptr[nk_text_edit], line_start_id: CInt, row_height: Float, font: Ptr[nk_user_font]): Unit = extern

  def nk_textedit_locate_coord(edit: Ptr[nk_text_edit], x: Float, y: Float, font: Ptr[nk_user_font], row_height: Float): CInt = extern

  def nk_textedit_makeundo_delete(state: Ptr[nk_text_edit], where: CInt, length: CInt): Unit = extern

  def nk_textedit_makeundo_insert(state: Ptr[nk_text_edit], where: CInt, length: CInt): Unit = extern

  def nk_textedit_makeundo_replace(state: Ptr[nk_text_edit], where: CInt, old_length: CInt, new_length: CInt): Unit = extern

  def nk_textedit_move_to_first(state: Ptr[nk_text_edit]): Unit = extern

  def nk_textedit_move_to_last(state: Ptr[nk_text_edit]): Unit = extern

  def nk_textedit_move_to_word_next(state: Ptr[nk_text_edit]): CInt = extern

  def nk_textedit_move_to_word_previous(state: Ptr[nk_text_edit]): CInt = extern

  def nk_textedit_paste(state: Ptr[nk_text_edit], ctext: CString, len: CInt): nk_bool = extern

  def nk_textedit_prep_selection_at_cursor(state: Ptr[nk_text_edit]): Unit = extern

  def nk_textedit_redo(state: Ptr[nk_text_edit]): Unit = extern

  def nk_textedit_select_all(state: Ptr[nk_text_edit]): Unit = extern

  def nk_textedit_sortselection(state: Ptr[nk_text_edit]): Unit = extern

  def nk_textedit_text(state: Ptr[nk_text_edit], text: CString, total_len: CInt): Unit = extern

  def nk_textedit_undo(state: Ptr[nk_text_edit]): Unit = extern

  def nk_to_lower(c: CInt): CInt = extern

  def nk_to_upper(c: CInt): CInt = extern

  def nk_tooltip(ctx: Ptr[nk_context], text: CString): Unit = extern

  def nk_tooltip_begin(ctx: Ptr[nk_context], width: Float): nk_bool = extern

  def nk_tooltip_end(ctx: Ptr[nk_context]): Unit = extern

  def nk_tree_base(ctx: Ptr[nk_context], `type`: nk_tree_type, img: Ptr[nk_image], title: CString, initial_state: nk_collapse_states, hash: CString, len: CInt, line: CInt): CInt = extern

  def nk_tree_element_base(ctx: Ptr[nk_context], `type`: nk_tree_type, img: Ptr[nk_image], title: CString, initial_state: nk_collapse_states, selected: Ptr[nk_bool], hash: CString, len: CInt, line: CInt): CInt = extern

  def nk_tree_element_image_push_hashed_base(ctx: Ptr[nk_context], `type`: nk_tree_type, img: Ptr[nk_image], title: CString, title_len: CInt, state: Ptr[nk_collapse_states], selected: Ptr[nk_bool]): CInt = extern

  def nk_tree_element_pop(ctx: Ptr[nk_context]): Unit = extern

  def nk_tree_element_push_hashed(ctx: Ptr[nk_context], `type`: nk_tree_type, title: CString, initial_state: nk_collapse_states, selected: Ptr[nk_bool], hash: CString, len: CInt, seed: CInt): nk_bool = extern

  def nk_tree_pop(ctx: Ptr[nk_context]): Unit = extern

  def nk_tree_push_hashed(ctx: Ptr[nk_context], `type`: nk_tree_type, title: CString, initial_state: nk_collapse_states, hash: CString, len: CInt, line: CInt): nk_bool = extern

  def nk_tree_state_base(ctx: Ptr[nk_context], `type`: nk_tree_type, img: Ptr[nk_image], title: CString, state: Ptr[nk_collapse_states]): CInt = extern

  def nk_tree_state_pop(ctx: Ptr[nk_context]): Unit = extern

  def nk_tree_state_push(ctx: Ptr[nk_context], `type`: nk_tree_type, title: CString, state: Ptr[nk_collapse_states]): nk_bool = extern

  def nk_unify(clip: Ptr[nk_rect], a: Ptr[nk_rect], x0: Float, y0: Float, x1: Float, y1: Float): Unit = extern

  def nk_utf_at(buffer: CString, length: CInt, index: CInt, unicode: Ptr[nk_rune], len: Ptr[CInt]): CString = extern

  def nk_utf_decode(c: CString, u: Ptr[nk_rune], clen: CInt): CInt = extern

  def nk_utf_decode_byte(c: CChar, i: Ptr[CInt]): nk_rune = extern

  def nk_utf_encode(u: nk_rune, c: CString, clen: CInt): CInt = extern

  def nk_utf_encode_byte(u: nk_rune, i: CInt): CChar = extern

  def nk_utf_len(str: CString, len: CInt): CInt = extern

  def nk_utf_validate(u: Ptr[nk_rune], i: CInt): CInt = extern

  def nk_widget(bounds: Ptr[nk_rect], ctx: Ptr[nk_context]): nk_widget_layout_states = extern

  def nk_widget_has_mouse_click_down(ctx: Ptr[nk_context], btn: nk_buttons, down: nk_bool): nk_bool = extern

  def nk_widget_height(ctx: Ptr[nk_context]): Float = extern

  def nk_widget_is_hovered(ctx: Ptr[nk_context]): nk_bool = extern

  def nk_widget_is_mouse_clicked(ctx: Ptr[nk_context], btn: nk_buttons): nk_bool = extern

  def nk_widget_width(ctx: Ptr[nk_context]): Float = extern

  def nk_window_close(ctx: Ptr[nk_context], name: CString): Unit = extern

  def nk_window_collapse(ctx: Ptr[nk_context], name: CString, c: nk_collapse_states): Unit = extern

  def nk_window_collapse_if(ctx: Ptr[nk_context], name: CString, c: nk_collapse_states, cond: CInt): Unit = extern

  def nk_window_find(ctx: Ptr[nk_context], name: CString): Ptr[nk_window] = extern

  def nk_window_get_canvas(ctx: Ptr[nk_context]): Ptr[nk_command_buffer] = extern

  def nk_window_get_height(ctx: Ptr[nk_context]): Float = extern

  def nk_window_get_panel(ctx: Ptr[nk_context]): Ptr[nk_panel] = extern

  def nk_window_get_scroll(ctx: Ptr[nk_context], offset_x: Ptr[nk_uint], offset_y: Ptr[nk_uint]): Unit = extern

  def nk_window_get_width(ctx: Ptr[nk_context]): Float = extern

  def nk_window_has_focus(ctx: Ptr[nk_context]): nk_bool = extern

  def nk_window_is_active(ctx: Ptr[nk_context], name: CString): nk_bool = extern

  def nk_window_is_any_hovered(ctx: Ptr[nk_context]): nk_bool = extern

  def nk_window_is_closed(ctx: Ptr[nk_context], name: CString): nk_bool = extern

  def nk_window_is_collapsed(ctx: Ptr[nk_context], name: CString): nk_bool = extern

  def nk_window_is_hidden(ctx: Ptr[nk_context], name: CString): nk_bool = extern

  def nk_window_is_hovered(ctx: Ptr[nk_context]): nk_bool = extern

  def nk_window_set_focus(ctx: Ptr[nk_context], name: CString): Unit = extern

  def nk_window_set_scroll(ctx: Ptr[nk_context], offset_x: nk_uint, offset_y: nk_uint): Unit = extern

  def nk_window_show(ctx: Ptr[nk_context], name: CString, s: nk_show_states): Unit = extern

  def nk_window_show_if(ctx: Ptr[nk_context], name: CString, s: nk_show_states, cond: CInt): Unit = extern

  def nk_zero(ptr: Ptr[Byte], size: nk_size): Unit = extern

  def stbrp_init_target(context: Ptr[stbrp_context], width: CInt, height: CInt, nodes: Ptr[stbrp_node], num_nodes: CInt): Unit = extern

  def stbrp_pack_rects(context: Ptr[stbrp_context], rects: Ptr[stbrp_rect], num_rects: CInt): CInt = extern

  def stbrp_setup_allow_out_of_mem(context: Ptr[stbrp_context], allow_out_of_mem: CInt): Unit = extern

  def stbrp_setup_heuristic(context: Ptr[stbrp_context], heuristic: CInt): Unit = extern

  def stbtt_BakeFontBitmap(data: Ptr[CUnsignedChar], offset: CInt, pixel_height: Float, pixels: Ptr[CUnsignedChar], pw: CInt, ph: CInt, first_char: CInt, num_chars: CInt, chardata: Ptr[stbtt_bakedchar]): CInt = extern

  def stbtt_CompareUTF8toUTF16_bigendian(s1: CString, len1: CInt, s2: CString, len2: CInt): CInt = extern

  def stbtt_FindGlyphIndex(info: Ptr[stbtt_fontinfo], unicode_codepoint: CInt): CInt = extern

  def stbtt_FindMatchingFont(fontdata: Ptr[CUnsignedChar], name: CString, flags: CInt): CInt = extern

  def stbtt_FindSVGDoc(info: Ptr[stbtt_fontinfo], gl: CInt): Ptr[CUnsignedChar] = extern

  def stbtt_FreeBitmap(bitmap: Ptr[CUnsignedChar], userdata: Ptr[Byte]): Unit = extern

  def stbtt_FreeSDF(bitmap: Ptr[CUnsignedChar], userdata: Ptr[Byte]): Unit = extern

  def stbtt_FreeShape(info: Ptr[stbtt_fontinfo], vertices: Ptr[stbtt_vertex]): Unit = extern

  def stbtt_GetBakedQuad(chardata: Ptr[stbtt_bakedchar], pw: CInt, ph: CInt, char_index: CInt, xpos: Ptr[Float], ypos: Ptr[Float], q: Ptr[stbtt_aligned_quad], opengl_fillrule: CInt): Unit = extern

  def stbtt_GetCodepointBitmap(info: Ptr[stbtt_fontinfo], scale_x: Float, scale_y: Float, codepoint: CInt, width: Ptr[CInt], height: Ptr[CInt], xoff: Ptr[CInt], yoff: Ptr[CInt]): Ptr[CUnsignedChar] = extern

  def stbtt_GetCodepointBitmapBox(font: Ptr[stbtt_fontinfo], codepoint: CInt, scale_x: Float, scale_y: Float, ix0: Ptr[CInt], iy0: Ptr[CInt], ix1: Ptr[CInt], iy1: Ptr[CInt]): Unit = extern

  def stbtt_GetCodepointBitmapBoxSubpixel(font: Ptr[stbtt_fontinfo], codepoint: CInt, scale_x: Float, scale_y: Float, shift_x: Float, shift_y: Float, ix0: Ptr[CInt], iy0: Ptr[CInt], ix1: Ptr[CInt], iy1: Ptr[CInt]): Unit = extern

  def stbtt_GetCodepointBitmapSubpixel(info: Ptr[stbtt_fontinfo], scale_x: Float, scale_y: Float, shift_x: Float, shift_y: Float, codepoint: CInt, width: Ptr[CInt], height: Ptr[CInt], xoff: Ptr[CInt], yoff: Ptr[CInt]): Ptr[CUnsignedChar] = extern

  def stbtt_GetCodepointBox(info: Ptr[stbtt_fontinfo], codepoint: CInt, x0: Ptr[CInt], y0: Ptr[CInt], x1: Ptr[CInt], y1: Ptr[CInt]): CInt = extern

  def stbtt_GetCodepointHMetrics(info: Ptr[stbtt_fontinfo], codepoint: CInt, advanceWidth: Ptr[CInt], leftSideBearing: Ptr[CInt]): Unit = extern

  def stbtt_GetCodepointKernAdvance(info: Ptr[stbtt_fontinfo], ch1: CInt, ch2: CInt): CInt = extern

  def stbtt_GetCodepointSDF(info: Ptr[stbtt_fontinfo], scale: Float, codepoint: CInt, padding: CInt, onedge_value: CUnsignedChar, pixel_dist_scale: Float, width: Ptr[CInt], height: Ptr[CInt], xoff: Ptr[CInt], yoff: Ptr[CInt]): Ptr[CUnsignedChar] = extern

  def stbtt_GetCodepointSVG(info: Ptr[stbtt_fontinfo], unicode_codepoint: CInt, svg: Ptr[CString]): CInt = extern

  def stbtt_GetCodepointShape(info: Ptr[stbtt_fontinfo], unicode_codepoint: CInt, vertices: Ptr[Ptr[stbtt_vertex]]): CInt = extern

  def stbtt_GetFontBoundingBox(info: Ptr[stbtt_fontinfo], x0: Ptr[CInt], y0: Ptr[CInt], x1: Ptr[CInt], y1: Ptr[CInt]): Unit = extern

  def stbtt_GetFontNameString(font: Ptr[stbtt_fontinfo], length: Ptr[CInt], platformID: CInt, encodingID: CInt, languageID: CInt, nameID: CInt): CString = extern

  def stbtt_GetFontOffsetForIndex(data: Ptr[CUnsignedChar], index: CInt): CInt = extern

  def stbtt_GetFontVMetrics(info: Ptr[stbtt_fontinfo], ascent: Ptr[CInt], descent: Ptr[CInt], lineGap: Ptr[CInt]): Unit = extern

  def stbtt_GetFontVMetricsOS2(info: Ptr[stbtt_fontinfo], typoAscent: Ptr[CInt], typoDescent: Ptr[CInt], typoLineGap: Ptr[CInt]): CInt = extern

  def stbtt_GetGlyphBitmap(info: Ptr[stbtt_fontinfo], scale_x: Float, scale_y: Float, glyph: CInt, width: Ptr[CInt], height: Ptr[CInt], xoff: Ptr[CInt], yoff: Ptr[CInt]): Ptr[CUnsignedChar] = extern

  def stbtt_GetGlyphBitmapBox(font: Ptr[stbtt_fontinfo], glyph: CInt, scale_x: Float, scale_y: Float, ix0: Ptr[CInt], iy0: Ptr[CInt], ix1: Ptr[CInt], iy1: Ptr[CInt]): Unit = extern

  def stbtt_GetGlyphBitmapBoxSubpixel(font: Ptr[stbtt_fontinfo], glyph: CInt, scale_x: Float, scale_y: Float, shift_x: Float, shift_y: Float, ix0: Ptr[CInt], iy0: Ptr[CInt], ix1: Ptr[CInt], iy1: Ptr[CInt]): Unit = extern

  def stbtt_GetGlyphBitmapSubpixel(info: Ptr[stbtt_fontinfo], scale_x: Float, scale_y: Float, shift_x: Float, shift_y: Float, glyph: CInt, width: Ptr[CInt], height: Ptr[CInt], xoff: Ptr[CInt], yoff: Ptr[CInt]): Ptr[CUnsignedChar] = extern

  def stbtt_GetGlyphBox(info: Ptr[stbtt_fontinfo], glyph_index: CInt, x0: Ptr[CInt], y0: Ptr[CInt], x1: Ptr[CInt], y1: Ptr[CInt]): CInt = extern

  def stbtt_GetGlyphHMetrics(info: Ptr[stbtt_fontinfo], glyph_index: CInt, advanceWidth: Ptr[CInt], leftSideBearing: Ptr[CInt]): Unit = extern

  def stbtt_GetGlyphKernAdvance(info: Ptr[stbtt_fontinfo], glyph1: CInt, glyph2: CInt): CInt = extern

  def stbtt_GetGlyphSDF(info: Ptr[stbtt_fontinfo], scale: Float, glyph: CInt, padding: CInt, onedge_value: CUnsignedChar, pixel_dist_scale: Float, width: Ptr[CInt], height: Ptr[CInt], xoff: Ptr[CInt], yoff: Ptr[CInt]): Ptr[CUnsignedChar] = extern

  def stbtt_GetGlyphSVG(info: Ptr[stbtt_fontinfo], gl: CInt, svg: Ptr[CString]): CInt = extern

  def stbtt_GetGlyphShape(info: Ptr[stbtt_fontinfo], glyph_index: CInt, vertices: Ptr[Ptr[stbtt_vertex]]): CInt = extern

  def stbtt_GetKerningTable(info: Ptr[stbtt_fontinfo], table: Ptr[stbtt_kerningentry], table_length: CInt): CInt = extern

  def stbtt_GetKerningTableLength(info: Ptr[stbtt_fontinfo]): CInt = extern

  def stbtt_GetNumberOfFonts(data: Ptr[CUnsignedChar]): CInt = extern

  def stbtt_GetPackedQuad(chardata: Ptr[stbtt_packedchar], pw: CInt, ph: CInt, char_index: CInt, xpos: Ptr[Float], ypos: Ptr[Float], q: Ptr[stbtt_aligned_quad], align_to_integer: CInt): Unit = extern

  def stbtt_GetScaledFontVMetrics(fontdata: Ptr[CUnsignedChar], index: CInt, size: Float, ascent: Ptr[Float], descent: Ptr[Float], lineGap: Ptr[Float]): Unit = extern

  def stbtt_InitFont(info: Ptr[stbtt_fontinfo], data: Ptr[CUnsignedChar], offset: CInt): CInt = extern

  def stbtt_IsGlyphEmpty(info: Ptr[stbtt_fontinfo], glyph_index: CInt): CInt = extern

  def stbtt_MakeCodepointBitmap(info: Ptr[stbtt_fontinfo], output: Ptr[CUnsignedChar], out_w: CInt, out_h: CInt, out_stride: CInt, scale_x: Float, scale_y: Float, codepoint: CInt): Unit = extern

  def stbtt_MakeCodepointBitmapSubpixel(info: Ptr[stbtt_fontinfo], output: Ptr[CUnsignedChar], out_w: CInt, out_h: CInt, out_stride: CInt, scale_x: Float, scale_y: Float, shift_x: Float, shift_y: Float, codepoint: CInt): Unit = extern

  def stbtt_MakeCodepointBitmapSubpixelPrefilter(info: Ptr[stbtt_fontinfo], output: Ptr[CUnsignedChar], out_w: CInt, out_h: CInt, out_stride: CInt, scale_x: Float, scale_y: Float, shift_x: Float, shift_y: Float, oversample_x: CInt, oversample_y: CInt, sub_x: Ptr[Float], sub_y: Ptr[Float], codepoint: CInt): Unit = extern

  def stbtt_MakeGlyphBitmap(info: Ptr[stbtt_fontinfo], output: Ptr[CUnsignedChar], out_w: CInt, out_h: CInt, out_stride: CInt, scale_x: Float, scale_y: Float, glyph: CInt): Unit = extern

  def stbtt_MakeGlyphBitmapSubpixel(info: Ptr[stbtt_fontinfo], output: Ptr[CUnsignedChar], out_w: CInt, out_h: CInt, out_stride: CInt, scale_x: Float, scale_y: Float, shift_x: Float, shift_y: Float, glyph: CInt): Unit = extern

  def stbtt_MakeGlyphBitmapSubpixelPrefilter(info: Ptr[stbtt_fontinfo], output: Ptr[CUnsignedChar], out_w: CInt, out_h: CInt, out_stride: CInt, scale_x: Float, scale_y: Float, shift_x: Float, shift_y: Float, oversample_x: CInt, oversample_y: CInt, sub_x: Ptr[Float], sub_y: Ptr[Float], glyph: CInt): Unit = extern

  def stbtt_PackBegin(spc: Ptr[stbtt_pack_context], pixels: Ptr[CUnsignedChar], width: CInt, height: CInt, stride_in_bytes: CInt, padding: CInt, alloc_context: Ptr[Byte]): CInt = extern

  def stbtt_PackEnd(spc: Ptr[stbtt_pack_context]): Unit = extern

  def stbtt_PackFontRange(spc: Ptr[stbtt_pack_context], fontdata: Ptr[CUnsignedChar], font_index: CInt, font_size: Float, first_unicode_char_in_range: CInt, num_chars_in_range: CInt, chardata_for_range: Ptr[stbtt_packedchar]): CInt = extern

  def stbtt_PackFontRanges(spc: Ptr[stbtt_pack_context], fontdata: Ptr[CUnsignedChar], font_index: CInt, ranges: Ptr[stbtt_pack_range], num_ranges: CInt): CInt = extern

  def stbtt_PackFontRangesGatherRects(spc: Ptr[stbtt_pack_context], info: Ptr[stbtt_fontinfo], ranges: Ptr[stbtt_pack_range], num_ranges: CInt, rects: Ptr[stbrp_rect]): CInt = extern

  def stbtt_PackFontRangesPackRects(spc: Ptr[stbtt_pack_context], rects: Ptr[stbrp_rect], num_rects: CInt): Unit = extern

  def stbtt_PackFontRangesRenderIntoRects(spc: Ptr[stbtt_pack_context], info: Ptr[stbtt_fontinfo], ranges: Ptr[stbtt_pack_range], num_ranges: CInt, rects: Ptr[stbrp_rect]): CInt = extern

  def stbtt_PackSetOversampling(spc: Ptr[stbtt_pack_context], h_oversample: CUnsignedInt, v_oversample: CUnsignedInt): Unit = extern

  def stbtt_PackSetSkipMissingCodepoints(spc: Ptr[stbtt_pack_context], skip: CInt): Unit = extern

  def stbtt_Rasterize(result: Ptr[stbtt__bitmap], flatness_in_pixels: Float, vertices: Ptr[stbtt_vertex], num_verts: CInt, scale_x: Float, scale_y: Float, shift_x: Float, shift_y: Float, x_off: CInt, y_off: CInt, invert: CInt, userdata: Ptr[Byte]): Unit = extern

  def stbtt_ScaleForMappingEmToPixels(info: Ptr[stbtt_fontinfo], pixels: Float): Float = extern

  def stbtt_ScaleForPixelHeight(info: Ptr[stbtt_fontinfo], pixels: Float): Float = extern

object functions: 
  import types.*, extern_functions.*

  export extern_functions.*

  def nk_begin(ctx: Ptr[nk_context], title: CString, bounds: nk_rect, flags: nk_flags)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    __sn_wrap_nk_begin(ctx, title, _ptr_2, flags)

  def nk_begin_titled(ctx: Ptr[nk_context], name: CString, title: CString, bounds: nk_rect, flags: nk_flags)(using Zone): nk_bool = 
    val _ptr_3 = alloc[nk_rect](1)
    !_ptr_3 = bounds
    __sn_wrap_nk_begin_titled(ctx, name, title, _ptr_3, flags)

  def nk_button_behavior(state: Ptr[nk_flags], r: nk_rect, i: Ptr[nk_input], behavior: nk_button_behavior)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = r
    __sn_wrap_nk_button_behavior(state, _ptr_1, i, behavior)

  def nk_button_color(ctx: Ptr[nk_context], color: nk_color)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_color](1)
    !_ptr_1 = color
    __sn_wrap_nk_button_color(ctx, _ptr_1)

  def nk_button_image(ctx: Ptr[nk_context], img: nk_image)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_button_image(ctx, _ptr_1)

  def nk_button_image_label(ctx: Ptr[nk_context], img: nk_image, label: CString, align: nk_flags)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_button_image_label(ctx, _ptr_1, label, align)

  def nk_button_image_label_styled(ctx: Ptr[nk_context], style: Ptr[nk_style_button], img: nk_image, label: CString, text_alignment: nk_flags)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_image](1)
    !_ptr_2 = img
    __sn_wrap_nk_button_image_label_styled(ctx, style, _ptr_2, label, text_alignment)

  def nk_button_image_styled(ctx: Ptr[nk_context], style: Ptr[nk_style_button], img: nk_image)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_image](1)
    !_ptr_2 = img
    __sn_wrap_nk_button_image_styled(ctx, style, _ptr_2)

  def nk_button_image_text(ctx: Ptr[nk_context], img: nk_image, text: CString, len: CInt, align: nk_flags)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_button_image_text(ctx, _ptr_1, text, len, align)

  def nk_button_image_text_styled(ctx: Ptr[nk_context], style: Ptr[nk_style_button], img: nk_image, text: CString, len: CInt, align: nk_flags)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_image](1)
    !_ptr_2 = img
    __sn_wrap_nk_button_image_text_styled(ctx, style, _ptr_2, text, len, align)

  def nk_chart_add_slot_colored(ctx: Ptr[nk_context], `type`: nk_chart_type, color: nk_color, highlight: nk_color, count: CInt, min_value: Float, max_value: Float)(using Zone): Unit = 
    val _ptr_2 = alloc[nk_color](1)
    !_ptr_2 = color
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = highlight
    __sn_wrap_nk_chart_add_slot_colored(ctx, `type`, _ptr_2, _ptr_3, count, min_value, max_value)

  def nk_chart_begin_colored(ctx: Ptr[nk_context], `type`: nk_chart_type, color: nk_color, highlight: nk_color, count: CInt, min_value: Float, max_value: Float)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_color](1)
    !_ptr_2 = color
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = highlight
    __sn_wrap_nk_chart_begin_colored(ctx, `type`, _ptr_2, _ptr_3, count, min_value, max_value)

  def nk_color_cf(in: nk_color)(using Zone): nk_colorf = 
    val _ptr_0 = alloc[nk_color](1)
    !_ptr_0 = in
    val _ptr_return = alloc[nk_colorf](1)
    __sn_wrap_nk_color_cf(_ptr_0, _ptr_return)
    !_ptr_return

  def nk_color_d(r: Ptr[Double], g: Ptr[Double], b: Ptr[Double], a: Ptr[Double], in: nk_color)(using Zone): Unit = 
    val _ptr_4 = alloc[nk_color](1)
    !_ptr_4 = in
    __sn_wrap_nk_color_d(r, g, b, a, _ptr_4)

  def nk_color_dv(c: Ptr[Double], in: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_color](1)
    !_ptr_1 = in
    __sn_wrap_nk_color_dv(c, _ptr_1)

  def nk_color_f(r: Ptr[Float], g: Ptr[Float], b: Ptr[Float], a: Ptr[Float], in: nk_color)(using Zone): Unit = 
    val _ptr_4 = alloc[nk_color](1)
    !_ptr_4 = in
    __sn_wrap_nk_color_f(r, g, b, a, _ptr_4)

  def nk_color_fv(c: Ptr[Float], in: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_color](1)
    !_ptr_1 = in
    __sn_wrap_nk_color_fv(c, _ptr_1)

  def nk_color_hex_rgb(output: CString, col: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_color](1)
    !_ptr_1 = col
    __sn_wrap_nk_color_hex_rgb(output, _ptr_1)

  def nk_color_hex_rgba(output: CString, col: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_color](1)
    !_ptr_1 = col
    __sn_wrap_nk_color_hex_rgba(output, _ptr_1)

  def nk_color_hsv_b(out_h: Ptr[nk_byte], out_s: Ptr[nk_byte], out_v: Ptr[nk_byte], in: nk_color)(using Zone): Unit = 
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = in
    __sn_wrap_nk_color_hsv_b(out_h, out_s, out_v, _ptr_3)

  def nk_color_hsv_bv(out: Ptr[nk_byte], in: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_color](1)
    !_ptr_1 = in
    __sn_wrap_nk_color_hsv_bv(out, _ptr_1)

  def nk_color_hsv_f(out_h: Ptr[Float], out_s: Ptr[Float], out_v: Ptr[Float], in: nk_color)(using Zone): Unit = 
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = in
    __sn_wrap_nk_color_hsv_f(out_h, out_s, out_v, _ptr_3)

  def nk_color_hsv_fv(out: Ptr[Float], in: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_color](1)
    !_ptr_1 = in
    __sn_wrap_nk_color_hsv_fv(out, _ptr_1)

  def nk_color_hsv_i(out_h: Ptr[CInt], out_s: Ptr[CInt], out_v: Ptr[CInt], in: nk_color)(using Zone): Unit = 
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = in
    __sn_wrap_nk_color_hsv_i(out_h, out_s, out_v, _ptr_3)

  def nk_color_hsv_iv(out: Ptr[CInt], in: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_color](1)
    !_ptr_1 = in
    __sn_wrap_nk_color_hsv_iv(out, _ptr_1)

  def nk_color_hsva_b(h: Ptr[nk_byte], s: Ptr[nk_byte], v: Ptr[nk_byte], a: Ptr[nk_byte], in: nk_color)(using Zone): Unit = 
    val _ptr_4 = alloc[nk_color](1)
    !_ptr_4 = in
    __sn_wrap_nk_color_hsva_b(h, s, v, a, _ptr_4)

  def nk_color_hsva_bv(out: Ptr[nk_byte], in: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_color](1)
    !_ptr_1 = in
    __sn_wrap_nk_color_hsva_bv(out, _ptr_1)

  def nk_color_hsva_f(out_h: Ptr[Float], out_s: Ptr[Float], out_v: Ptr[Float], out_a: Ptr[Float], in: nk_color)(using Zone): Unit = 
    val _ptr_4 = alloc[nk_color](1)
    !_ptr_4 = in
    __sn_wrap_nk_color_hsva_f(out_h, out_s, out_v, out_a, _ptr_4)

  def nk_color_hsva_fv(out: Ptr[Float], in: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_color](1)
    !_ptr_1 = in
    __sn_wrap_nk_color_hsva_fv(out, _ptr_1)

  def nk_color_hsva_i(out_h: Ptr[CInt], out_s: Ptr[CInt], out_v: Ptr[CInt], out_a: Ptr[CInt], in: nk_color)(using Zone): Unit = 
    val _ptr_4 = alloc[nk_color](1)
    !_ptr_4 = in
    __sn_wrap_nk_color_hsva_i(out_h, out_s, out_v, out_a, _ptr_4)

  def nk_color_hsva_iv(out: Ptr[CInt], in: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_color](1)
    !_ptr_1 = in
    __sn_wrap_nk_color_hsva_iv(out, _ptr_1)

  def nk_color_picker(ctx: Ptr[nk_context], color: nk_colorf, fmt: nk_color_format)(using Zone): nk_colorf = 
    val _ptr_1 = alloc[nk_colorf](1)
    !_ptr_1 = color
    val _ptr_return = alloc[nk_colorf](1)
    __sn_wrap_nk_color_picker(ctx, _ptr_1, fmt, _ptr_return)
    !_ptr_return

  def nk_color_u32(in: nk_color)(using Zone): nk_uint = 
    val _ptr_0 = alloc[nk_color](1)
    !_ptr_0 = in
    __sn_wrap_nk_color_u32(_ptr_0)

  def nk_colorf_hsva_f(out_h: Ptr[Float], out_s: Ptr[Float], out_v: Ptr[Float], out_a: Ptr[Float], in: nk_colorf)(using Zone): Unit = 
    val _ptr_4 = alloc[nk_colorf](1)
    !_ptr_4 = in
    __sn_wrap_nk_colorf_hsva_f(out_h, out_s, out_v, out_a, _ptr_4)

  def nk_colorf_hsva_fv(hsva: Ptr[Float], in: nk_colorf)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_colorf](1)
    !_ptr_1 = in
    __sn_wrap_nk_colorf_hsva_fv(hsva, _ptr_1)

  def nk_combo(ctx: Ptr[nk_context], items: Ptr[CString], count: CInt, selected: CInt, item_height: CInt, size: nk_vec2)(using Zone): CInt = 
    val _ptr_5 = alloc[nk_vec2](1)
    !_ptr_5 = size
    __sn_wrap_nk_combo(ctx, items, count, selected, item_height, _ptr_5)

  def nk_combo_begin(ctx: Ptr[nk_context], win: Ptr[nk_window], size: nk_vec2, is_clicked: nk_bool, header: nk_rect)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_vec2](1)
    !_ptr_2 = size
    val _ptr_4 = alloc[nk_rect](1)
    !_ptr_4 = header
    __sn_wrap_nk_combo_begin(ctx, win, _ptr_2, is_clicked, _ptr_4)

  def nk_combo_begin_color(ctx: Ptr[nk_context], color: nk_color, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_color](1)
    !_ptr_1 = color
    val _ptr_2 = alloc[nk_vec2](1)
    !_ptr_2 = size
    __sn_wrap_nk_combo_begin_color(ctx, _ptr_1, _ptr_2)

  def nk_combo_begin_image(ctx: Ptr[nk_context], img: nk_image, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    val _ptr_2 = alloc[nk_vec2](1)
    !_ptr_2 = size
    __sn_wrap_nk_combo_begin_image(ctx, _ptr_1, _ptr_2)

  def nk_combo_begin_image_label(ctx: Ptr[nk_context], selected: CString, img: nk_image, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_image](1)
    !_ptr_2 = img
    val _ptr_3 = alloc[nk_vec2](1)
    !_ptr_3 = size
    __sn_wrap_nk_combo_begin_image_label(ctx, selected, _ptr_2, _ptr_3)

  def nk_combo_begin_image_text(ctx: Ptr[nk_context], selected: CString, len: CInt, img: nk_image, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_3 = alloc[nk_image](1)
    !_ptr_3 = img
    val _ptr_4 = alloc[nk_vec2](1)
    !_ptr_4 = size
    __sn_wrap_nk_combo_begin_image_text(ctx, selected, len, _ptr_3, _ptr_4)

  def nk_combo_begin_label(ctx: Ptr[nk_context], selected: CString, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_vec2](1)
    !_ptr_2 = size
    __sn_wrap_nk_combo_begin_label(ctx, selected, _ptr_2)

  def nk_combo_begin_symbol(ctx: Ptr[nk_context], symbol: nk_symbol_type, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_vec2](1)
    !_ptr_2 = size
    __sn_wrap_nk_combo_begin_symbol(ctx, symbol, _ptr_2)

  def nk_combo_begin_symbol_label(ctx: Ptr[nk_context], selected: CString, `type`: nk_symbol_type, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_3 = alloc[nk_vec2](1)
    !_ptr_3 = size
    __sn_wrap_nk_combo_begin_symbol_label(ctx, selected, `type`, _ptr_3)

  def nk_combo_begin_symbol_text(ctx: Ptr[nk_context], selected: CString, len: CInt, symbol: nk_symbol_type, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_4 = alloc[nk_vec2](1)
    !_ptr_4 = size
    __sn_wrap_nk_combo_begin_symbol_text(ctx, selected, len, symbol, _ptr_4)

  def nk_combo_begin_text(ctx: Ptr[nk_context], selected: CString, len: CInt, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_3 = alloc[nk_vec2](1)
    !_ptr_3 = size
    __sn_wrap_nk_combo_begin_text(ctx, selected, len, _ptr_3)

  def nk_combo_callback(ctx: Ptr[nk_context], item_getter: CFuncPtr3[Ptr[Byte], CInt, Ptr[CString], Unit], userdata: Ptr[Byte], selected: CInt, count: CInt, item_height: CInt, size: nk_vec2)(using Zone): CInt = 
    val _ptr_6 = alloc[nk_vec2](1)
    !_ptr_6 = size
    __sn_wrap_nk_combo_callback(ctx, item_getter, userdata, selected, count, item_height, _ptr_6)

  def nk_combo_item_image_label(ctx: Ptr[nk_context], img: nk_image, text: CString, alignment: nk_flags)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_combo_item_image_label(ctx, _ptr_1, text, alignment)

  def nk_combo_item_image_text(ctx: Ptr[nk_context], img: nk_image, text: CString, len: CInt, alignment: nk_flags)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_combo_item_image_text(ctx, _ptr_1, text, len, alignment)

  def nk_combo_separator(ctx: Ptr[nk_context], items_separated_by_separator: CString, separator: CInt, selected: CInt, count: CInt, item_height: CInt, size: nk_vec2)(using Zone): CInt = 
    val _ptr_6 = alloc[nk_vec2](1)
    !_ptr_6 = size
    __sn_wrap_nk_combo_separator(ctx, items_separated_by_separator, separator, selected, count, item_height, _ptr_6)

  def nk_combo_string(ctx: Ptr[nk_context], items_separated_by_zeros: CString, selected: CInt, count: CInt, item_height: CInt, size: nk_vec2)(using Zone): CInt = 
    val _ptr_5 = alloc[nk_vec2](1)
    !_ptr_5 = size
    __sn_wrap_nk_combo_string(ctx, items_separated_by_zeros, selected, count, item_height, _ptr_5)

  def nk_combobox(ctx: Ptr[nk_context], items: Ptr[CString], count: CInt, selected: Ptr[CInt], item_height: CInt, size: nk_vec2)(using Zone): Unit = 
    val _ptr_5 = alloc[nk_vec2](1)
    !_ptr_5 = size
    __sn_wrap_nk_combobox(ctx, items, count, selected, item_height, _ptr_5)

  def nk_combobox_callback(ctx: Ptr[nk_context], item_getter: CFuncPtr3[Ptr[Byte], CInt, Ptr[CString], Unit], userdata: Ptr[Byte], selected: Ptr[CInt], count: CInt, item_height: CInt, size: nk_vec2)(using Zone): Unit = 
    val _ptr_6 = alloc[nk_vec2](1)
    !_ptr_6 = size
    __sn_wrap_nk_combobox_callback(ctx, item_getter, userdata, selected, count, item_height, _ptr_6)

  def nk_combobox_separator(ctx: Ptr[nk_context], items_separated_by_separator: CString, separator: CInt, selected: Ptr[CInt], count: CInt, item_height: CInt, size: nk_vec2)(using Zone): Unit = 
    val _ptr_6 = alloc[nk_vec2](1)
    !_ptr_6 = size
    __sn_wrap_nk_combobox_separator(ctx, items_separated_by_separator, separator, selected, count, item_height, _ptr_6)

  def nk_combobox_string(ctx: Ptr[nk_context], items_separated_by_zeros: CString, selected: Ptr[CInt], count: CInt, item_height: CInt, size: nk_vec2)(using Zone): Unit = 
    val _ptr_5 = alloc[nk_vec2](1)
    !_ptr_5 = size
    __sn_wrap_nk_combobox_string(ctx, items_separated_by_zeros, selected, count, item_height, _ptr_5)

  def nk_contextual_begin(ctx: Ptr[nk_context], flags: nk_flags, size: nk_vec2, trigger_bounds: nk_rect)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_vec2](1)
    !_ptr_2 = size
    val _ptr_3 = alloc[nk_rect](1)
    !_ptr_3 = trigger_bounds
    __sn_wrap_nk_contextual_begin(ctx, flags, _ptr_2, _ptr_3)

  def nk_contextual_item_image_label(ctx: Ptr[nk_context], img: nk_image, label: CString, align: nk_flags)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_contextual_item_image_label(ctx, _ptr_1, label, align)

  def nk_contextual_item_image_text(ctx: Ptr[nk_context], img: nk_image, text: CString, len: CInt, align: nk_flags)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_contextual_item_image_text(ctx, _ptr_1, text, len, align)

  def nk_do_button(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], r: nk_rect, style: Ptr[nk_style_button], in: Ptr[nk_input], behavior: nk_button_behavior, content: Ptr[nk_rect])(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = r
    __sn_wrap_nk_do_button(state, out, _ptr_2, style, in, behavior, content)

  def nk_do_button_image(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: nk_rect, img: nk_image, b: nk_button_behavior, style: Ptr[nk_style_button], in: Ptr[nk_input])(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    val _ptr_3 = alloc[nk_image](1)
    !_ptr_3 = img
    __sn_wrap_nk_do_button_image(state, out, _ptr_2, _ptr_3, b, style, in)

  def nk_do_button_symbol(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: nk_rect, symbol: nk_symbol_type, behavior: nk_button_behavior, style: Ptr[nk_style_button], in: Ptr[nk_input], font: Ptr[nk_user_font])(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    __sn_wrap_nk_do_button_symbol(state, out, _ptr_2, symbol, behavior, style, in, font)

  def nk_do_button_text(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: nk_rect, string: CString, len: CInt, align: nk_flags, behavior: nk_button_behavior, style: Ptr[nk_style_button], in: Ptr[nk_input], font: Ptr[nk_user_font])(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    __sn_wrap_nk_do_button_text(state, out, _ptr_2, string, len, align, behavior, style, in, font)

  def nk_do_button_text_image(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: nk_rect, img: nk_image, str: CString, len: CInt, align: nk_flags, behavior: nk_button_behavior, style: Ptr[nk_style_button], font: Ptr[nk_user_font], in: Ptr[nk_input])(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    val _ptr_3 = alloc[nk_image](1)
    !_ptr_3 = img
    __sn_wrap_nk_do_button_text_image(state, out, _ptr_2, _ptr_3, str, len, align, behavior, style, font, in)

  def nk_do_button_text_symbol(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: nk_rect, symbol: nk_symbol_type, str: CString, len: CInt, align: nk_flags, behavior: nk_button_behavior, style: Ptr[nk_style_button], font: Ptr[nk_user_font], in: Ptr[nk_input])(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    __sn_wrap_nk_do_button_text_symbol(state, out, _ptr_2, symbol, str, len, align, behavior, style, font, in)

  def nk_do_color_picker(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], col: Ptr[nk_colorf], fmt: nk_color_format, bounds: nk_rect, padding: nk_vec2, in: Ptr[nk_input], font: Ptr[nk_user_font])(using Zone): nk_bool = 
    val _ptr_4 = alloc[nk_rect](1)
    !_ptr_4 = bounds
    val _ptr_5 = alloc[nk_vec2](1)
    !_ptr_5 = padding
    __sn_wrap_nk_do_color_picker(state, out, col, fmt, _ptr_4, _ptr_5, in, font)

  def nk_do_edit(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: nk_rect, flags: nk_flags, filter: nk_plugin_filter, edit: Ptr[nk_text_edit], style: Ptr[nk_style_edit], in: Ptr[nk_input], font: Ptr[nk_user_font])(using Zone): nk_flags = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    __sn_wrap_nk_do_edit(state, out, _ptr_2, flags, filter, edit, style, in, font)

  def nk_do_progress(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: nk_rect, value: nk_size, max: nk_size, modifiable: nk_bool, style: Ptr[nk_style_progress], in: Ptr[nk_input])(using Zone): nk_size = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    __sn_wrap_nk_do_progress(state, out, _ptr_2, value, max, modifiable, style, in)

  def nk_do_property(ws: Ptr[nk_flags], out: Ptr[nk_command_buffer], property: nk_rect, name: CString, variant: Ptr[nk_property_variant], inc_per_pixel: Float, buffer: CString, len: Ptr[CInt], state: Ptr[CInt], cursor: Ptr[CInt], select_begin: Ptr[CInt], select_end: Ptr[CInt], style: Ptr[nk_style_property], filter: nk_property_filter, in: Ptr[nk_input], font: Ptr[nk_user_font], text_edit: Ptr[nk_text_edit], behavior: nk_button_behavior)(using Zone): Unit = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = property
    __sn_wrap_nk_do_property(ws, out, _ptr_2, name, variant, inc_per_pixel, buffer, len, state, cursor, select_begin, select_end, style, filter, in, font, text_edit, behavior)

  def nk_do_scrollbarh(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], scroll: nk_rect, has_scrolling: CInt, offset: Float, target: Float, step: Float, button_pixel_inc: Float, style: Ptr[nk_style_scrollbar], in: Ptr[nk_input], font: Ptr[nk_user_font])(using Zone): Float = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = scroll
    __sn_wrap_nk_do_scrollbarh(state, out, _ptr_2, has_scrolling, offset, target, step, button_pixel_inc, style, in, font)

  def nk_do_scrollbarv(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], scroll: nk_rect, has_scrolling: CInt, offset: Float, target: Float, step: Float, button_pixel_inc: Float, style: Ptr[nk_style_scrollbar], in: Ptr[nk_input], font: Ptr[nk_user_font])(using Zone): Float = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = scroll
    __sn_wrap_nk_do_scrollbarv(state, out, _ptr_2, has_scrolling, offset, target, step, button_pixel_inc, style, in, font)

  def nk_do_selectable(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: nk_rect, str: CString, len: CInt, align: nk_flags, value: Ptr[nk_bool], style: Ptr[nk_style_selectable], in: Ptr[nk_input], font: Ptr[nk_user_font])(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    __sn_wrap_nk_do_selectable(state, out, _ptr_2, str, len, align, value, style, in, font)

  def nk_do_selectable_image(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: nk_rect, str: CString, len: CInt, align: nk_flags, value: Ptr[nk_bool], img: Ptr[nk_image], style: Ptr[nk_style_selectable], in: Ptr[nk_input], font: Ptr[nk_user_font])(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    __sn_wrap_nk_do_selectable_image(state, out, _ptr_2, str, len, align, value, img, style, in, font)

  def nk_do_selectable_symbol(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: nk_rect, str: CString, len: CInt, align: nk_flags, value: Ptr[nk_bool], sym: nk_symbol_type, style: Ptr[nk_style_selectable], in: Ptr[nk_input], font: Ptr[nk_user_font])(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    __sn_wrap_nk_do_selectable_symbol(state, out, _ptr_2, str, len, align, value, sym, style, in, font)

  def nk_do_slider(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], bounds: nk_rect, min: Float, `val`: Float, max: Float, step: Float, style: Ptr[nk_style_slider], in: Ptr[nk_input], font: Ptr[nk_user_font])(using Zone): Float = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    __sn_wrap_nk_do_slider(state, out, _ptr_2, min, `val`, max, step, style, in, font)

  def nk_do_toggle(state: Ptr[nk_flags], out: Ptr[nk_command_buffer], r: nk_rect, active: Ptr[nk_bool], str: CString, len: CInt, `type`: nk_toggle_type, style: Ptr[nk_style_toggle], in: Ptr[nk_input], font: Ptr[nk_user_font])(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = r
    __sn_wrap_nk_do_toggle(state, out, _ptr_2, active, str, len, `type`, style, in, font)

  def nk_drag_behavior(state: Ptr[nk_flags], in: Ptr[nk_input], drag: nk_rect, variant: Ptr[nk_property_variant], inc_per_pixel: Float)(using Zone): Unit = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = drag
    __sn_wrap_nk_drag_behavior(state, in, _ptr_2, variant, inc_per_pixel)

  def nk_draw_color_picker(o: Ptr[nk_command_buffer], matrix: Ptr[nk_rect], hue_bar: Ptr[nk_rect], alpha_bar: Ptr[nk_rect], col: nk_colorf)(using Zone): Unit = 
    val _ptr_4 = alloc[nk_colorf](1)
    !_ptr_4 = col
    __sn_wrap_nk_draw_color_picker(o, matrix, hue_bar, alpha_bar, _ptr_4)

  def nk_draw_image(b: Ptr[nk_command_buffer], r: nk_rect, img: Ptr[nk_image], col: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = r
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = col
    __sn_wrap_nk_draw_image(b, _ptr_1, img, _ptr_3)

  def nk_draw_nine_slice(b: Ptr[nk_command_buffer], r: nk_rect, slc: Ptr[nk_nine_slice], col: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = r
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = col
    __sn_wrap_nk_draw_nine_slice(b, _ptr_1, slc, _ptr_3)

  def nk_draw_symbol(out: Ptr[nk_command_buffer], `type`: nk_symbol_type, content: nk_rect, background: nk_color, foreground: nk_color, border_width: Float, font: Ptr[nk_user_font])(using Zone): Unit = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = content
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = background
    val _ptr_4 = alloc[nk_color](1)
    !_ptr_4 = foreground
    __sn_wrap_nk_draw_symbol(out, `type`, _ptr_2, _ptr_3, _ptr_4, border_width, font)

  def nk_draw_text(b: Ptr[nk_command_buffer], r: nk_rect, string: CString, length: CInt, font: Ptr[nk_user_font], bg: nk_color, fg: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = r
    val _ptr_5 = alloc[nk_color](1)
    !_ptr_5 = bg
    val _ptr_6 = alloc[nk_color](1)
    !_ptr_6 = fg
    __sn_wrap_nk_draw_text(b, _ptr_1, string, length, font, _ptr_5, _ptr_6)

  def nk_edit_draw_text(out: Ptr[nk_command_buffer], style: Ptr[nk_style_edit], pos_x: Float, pos_y: Float, x_offset: Float, text: CString, byte_len: CInt, row_height: Float, font: Ptr[nk_user_font], background: nk_color, foreground: nk_color, is_selected: nk_bool)(using Zone): Unit = 
    val _ptr_9 = alloc[nk_color](1)
    !_ptr_9 = background
    val _ptr_10 = alloc[nk_color](1)
    !_ptr_10 = foreground
    __sn_wrap_nk_edit_draw_text(out, style, pos_x, pos_y, x_offset, text, byte_len, row_height, font, _ptr_9, _ptr_10, is_selected)

  def nk_fill_arc(b: Ptr[nk_command_buffer], cx: Float, cy: Float, radius: Float, a_min: Float, a_max: Float, c: nk_color)(using Zone): Unit = 
    val _ptr_6 = alloc[nk_color](1)
    !_ptr_6 = c
    __sn_wrap_nk_fill_arc(b, cx, cy, radius, a_min, a_max, _ptr_6)

  def nk_fill_circle(b: Ptr[nk_command_buffer], r: nk_rect, c: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = r
    val _ptr_2 = alloc[nk_color](1)
    !_ptr_2 = c
    __sn_wrap_nk_fill_circle(b, _ptr_1, _ptr_2)

  def nk_fill_polygon(b: Ptr[nk_command_buffer], points: Ptr[Float], point_count: CInt, col: nk_color)(using Zone): Unit = 
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = col
    __sn_wrap_nk_fill_polygon(b, points, point_count, _ptr_3)

  def nk_fill_rect(b: Ptr[nk_command_buffer], rect: nk_rect, rounding: Float, c: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = rect
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = c
    __sn_wrap_nk_fill_rect(b, _ptr_1, rounding, _ptr_3)

  def nk_fill_rect_multi_color(b: Ptr[nk_command_buffer], rect: nk_rect, left: nk_color, top: nk_color, right: nk_color, bottom: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = rect
    val _ptr_2 = alloc[nk_color](1)
    !_ptr_2 = left
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = top
    val _ptr_4 = alloc[nk_color](1)
    !_ptr_4 = right
    val _ptr_5 = alloc[nk_color](1)
    !_ptr_5 = bottom
    __sn_wrap_nk_fill_rect_multi_color(b, _ptr_1, _ptr_2, _ptr_3, _ptr_4, _ptr_5)

  def nk_fill_triangle(b: Ptr[nk_command_buffer], x0: Float, y0: Float, x1: Float, y1: Float, x2: Float, y2: Float, c: nk_color)(using Zone): Unit = 
    val _ptr_7 = alloc[nk_color](1)
    !_ptr_7 = c
    __sn_wrap_nk_fill_triangle(b, x0, y0, x1, y1, x2, y2, _ptr_7)

  def nk_get_null_rect()(using Zone): nk_rect = 
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_get_null_rect(_ptr_return)
    !_ptr_return

  def nk_hsv(h: CInt, s: CInt, v: CInt)(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_hsv(h, s, v, _ptr_return)
    !_ptr_return

  def nk_hsv_bv(c: Ptr[nk_byte])(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_hsv_bv(c, _ptr_return)
    !_ptr_return

  def nk_hsv_f(h: Float, s: Float, v: Float)(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_hsv_f(h, s, v, _ptr_return)
    !_ptr_return

  def nk_hsv_fv(hsv: Ptr[Float])(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_hsv_fv(hsv, _ptr_return)
    !_ptr_return

  def nk_hsv_iv(hsv: Ptr[CInt])(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_hsv_iv(hsv, _ptr_return)
    !_ptr_return

  def nk_hsva(h: CInt, s: CInt, v: CInt, a: CInt)(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_hsva(h, s, v, a, _ptr_return)
    !_ptr_return

  def nk_hsva_bv(c: Ptr[nk_byte])(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_hsva_bv(c, _ptr_return)
    !_ptr_return

  def nk_hsva_colorf(h: Float, s: Float, v: Float, a: Float)(using Zone): nk_colorf = 
    val _ptr_return = alloc[nk_colorf](1)
    __sn_wrap_nk_hsva_colorf(h, s, v, a, _ptr_return)
    !_ptr_return

  def nk_hsva_colorfv(c: Ptr[Float])(using Zone): nk_colorf = 
    val _ptr_return = alloc[nk_colorf](1)
    __sn_wrap_nk_hsva_colorfv(c, _ptr_return)
    !_ptr_return

  def nk_hsva_f(h: Float, s: Float, v: Float, a: Float)(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_hsva_f(h, s, v, a, _ptr_return)
    !_ptr_return

  def nk_hsva_fv(c: Ptr[Float])(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_hsva_fv(c, _ptr_return)
    !_ptr_return

  def nk_hsva_iv(hsva: Ptr[CInt])(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_hsva_iv(hsva, _ptr_return)
    !_ptr_return

  def nk_image(ctx: Ptr[nk_context], img: nk_image)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_image(ctx, _ptr_1)

  def nk_image_color(ctx: Ptr[nk_context], img: nk_image, col: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    val _ptr_2 = alloc[nk_color](1)
    !_ptr_2 = col
    __sn_wrap_nk_image_color(ctx, _ptr_1, _ptr_2)

  def nk_image_handle(handle: nk_handle)(using Zone): nk_image = 
    val _ptr_return = alloc[nk_image](1)
    __sn_wrap_nk_image_handle(handle, _ptr_return)
    !_ptr_return

  def nk_image_id(id: CInt)(using Zone): nk_image = 
    val _ptr_return = alloc[nk_image](1)
    __sn_wrap_nk_image_id(id, _ptr_return)
    !_ptr_return

  def nk_image_ptr(ptr: Ptr[Byte])(using Zone): nk_image = 
    val _ptr_return = alloc[nk_image](1)
    __sn_wrap_nk_image_ptr(ptr, _ptr_return)
    !_ptr_return

  def nk_input_any_mouse_click_in_rect(in: Ptr[nk_input], b: nk_rect)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = b
    __sn_wrap_nk_input_any_mouse_click_in_rect(in, _ptr_1)

  def nk_input_has_mouse_click_down_in_rect(i: Ptr[nk_input], id: nk_buttons, b: nk_rect, down: nk_bool)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = b
    __sn_wrap_nk_input_has_mouse_click_down_in_rect(i, id, _ptr_2, down)

  def nk_input_has_mouse_click_in_rect(i: Ptr[nk_input], id: nk_buttons, b: nk_rect)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = b
    __sn_wrap_nk_input_has_mouse_click_in_rect(i, id, _ptr_2)

  def nk_input_is_mouse_click_down_in_rect(i: Ptr[nk_input], id: nk_buttons, b: nk_rect, down: nk_bool)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = b
    __sn_wrap_nk_input_is_mouse_click_down_in_rect(i, id, _ptr_2, down)

  def nk_input_is_mouse_click_in_rect(i: Ptr[nk_input], id: nk_buttons, b: nk_rect)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = b
    __sn_wrap_nk_input_is_mouse_click_in_rect(i, id, _ptr_2)

  def nk_input_is_mouse_hovering_rect(i: Ptr[nk_input], rect: nk_rect)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = rect
    __sn_wrap_nk_input_is_mouse_hovering_rect(i, _ptr_1)

  def nk_input_is_mouse_prev_hovering_rect(i: Ptr[nk_input], rect: nk_rect)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = rect
    __sn_wrap_nk_input_is_mouse_prev_hovering_rect(i, _ptr_1)

  def nk_input_mouse_clicked(i: Ptr[nk_input], id: nk_buttons, rect: nk_rect)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = rect
    __sn_wrap_nk_input_mouse_clicked(i, id, _ptr_2)

  def nk_input_scroll(ctx: Ptr[nk_context], `val`: nk_vec2)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_vec2](1)
    !_ptr_1 = `val`
    __sn_wrap_nk_input_scroll(ctx, _ptr_1)

  def nk_label_colored(ctx: Ptr[nk_context], str: CString, align: nk_flags, color: nk_color)(using Zone): Unit = 
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = color
    __sn_wrap_nk_label_colored(ctx, str, align, _ptr_3)

  def nk_label_colored_wrap(ctx: Ptr[nk_context], str: CString, color: nk_color)(using Zone): Unit = 
    val _ptr_2 = alloc[nk_color](1)
    !_ptr_2 = color
    __sn_wrap_nk_label_colored_wrap(ctx, str, _ptr_2)

  def nk_layout_space_bounds(ctx: Ptr[nk_context])(using Zone): nk_rect = 
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_layout_space_bounds(ctx, _ptr_return)
    !_ptr_return

  def nk_layout_space_push(ctx: Ptr[nk_context], rect: nk_rect)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = rect
    __sn_wrap_nk_layout_space_push(ctx, _ptr_1)

  def nk_layout_space_rect_to_local(ctx: Ptr[nk_context], ret: nk_rect)(using Zone): nk_rect = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = ret
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_layout_space_rect_to_local(ctx, _ptr_1, _ptr_return)
    !_ptr_return

  def nk_layout_space_rect_to_screen(ctx: Ptr[nk_context], ret: nk_rect)(using Zone): nk_rect = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = ret
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_layout_space_rect_to_screen(ctx, _ptr_1, _ptr_return)
    !_ptr_return

  def nk_layout_space_to_local(ctx: Ptr[nk_context], ret: nk_vec2)(using Zone): nk_vec2 = 
    val _ptr_1 = alloc[nk_vec2](1)
    !_ptr_1 = ret
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_layout_space_to_local(ctx, _ptr_1, _ptr_return)
    !_ptr_return

  def nk_layout_space_to_screen(ctx: Ptr[nk_context], ret: nk_vec2)(using Zone): nk_vec2 = 
    val _ptr_1 = alloc[nk_vec2](1)
    !_ptr_1 = ret
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_layout_space_to_screen(ctx, _ptr_1, _ptr_return)
    !_ptr_return

  def nk_layout_widget_bounds(ctx: Ptr[nk_context])(using Zone): nk_rect = 
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_layout_widget_bounds(ctx, _ptr_return)
    !_ptr_return

  def nk_menu_begin(ctx: Ptr[nk_context], win: Ptr[nk_window], id: CString, is_clicked: CInt, header: nk_rect, size: nk_vec2)(using Zone): CInt = 
    val _ptr_4 = alloc[nk_rect](1)
    !_ptr_4 = header
    val _ptr_5 = alloc[nk_vec2](1)
    !_ptr_5 = size
    __sn_wrap_nk_menu_begin(ctx, win, id, is_clicked, _ptr_4, _ptr_5)

  def nk_menu_begin_image(ctx: Ptr[nk_context], id: CString, img: nk_image, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_image](1)
    !_ptr_2 = img
    val _ptr_3 = alloc[nk_vec2](1)
    !_ptr_3 = size
    __sn_wrap_nk_menu_begin_image(ctx, id, _ptr_2, _ptr_3)

  def nk_menu_begin_image_label(ctx: Ptr[nk_context], title: CString, align: nk_flags, img: nk_image, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_3 = alloc[nk_image](1)
    !_ptr_3 = img
    val _ptr_4 = alloc[nk_vec2](1)
    !_ptr_4 = size
    __sn_wrap_nk_menu_begin_image_label(ctx, title, align, _ptr_3, _ptr_4)

  def nk_menu_begin_image_text(ctx: Ptr[nk_context], title: CString, len: CInt, align: nk_flags, img: nk_image, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_4 = alloc[nk_image](1)
    !_ptr_4 = img
    val _ptr_5 = alloc[nk_vec2](1)
    !_ptr_5 = size
    __sn_wrap_nk_menu_begin_image_text(ctx, title, len, align, _ptr_4, _ptr_5)

  def nk_menu_begin_label(ctx: Ptr[nk_context], text: CString, align: nk_flags, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_3 = alloc[nk_vec2](1)
    !_ptr_3 = size
    __sn_wrap_nk_menu_begin_label(ctx, text, align, _ptr_3)

  def nk_menu_begin_symbol(ctx: Ptr[nk_context], id: CString, sym: nk_symbol_type, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_3 = alloc[nk_vec2](1)
    !_ptr_3 = size
    __sn_wrap_nk_menu_begin_symbol(ctx, id, sym, _ptr_3)

  def nk_menu_begin_symbol_label(ctx: Ptr[nk_context], title: CString, align: nk_flags, sym: nk_symbol_type, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_4 = alloc[nk_vec2](1)
    !_ptr_4 = size
    __sn_wrap_nk_menu_begin_symbol_label(ctx, title, align, sym, _ptr_4)

  def nk_menu_begin_symbol_text(ctx: Ptr[nk_context], title: CString, len: CInt, align: nk_flags, sym: nk_symbol_type, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_5 = alloc[nk_vec2](1)
    !_ptr_5 = size
    __sn_wrap_nk_menu_begin_symbol_text(ctx, title, len, align, sym, _ptr_5)

  def nk_menu_begin_text(ctx: Ptr[nk_context], title: CString, len: CInt, align: nk_flags, size: nk_vec2)(using Zone): nk_bool = 
    val _ptr_4 = alloc[nk_vec2](1)
    !_ptr_4 = size
    __sn_wrap_nk_menu_begin_text(ctx, title, len, align, _ptr_4)

  def nk_menu_item_image_label(ctx: Ptr[nk_context], img: nk_image, label: CString, align: nk_flags)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_menu_item_image_label(ctx, _ptr_1, label, align)

  def nk_menu_item_image_text(ctx: Ptr[nk_context], img: nk_image, text: CString, len: CInt, align: nk_flags)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_menu_item_image_text(ctx, _ptr_1, text, len, align)

  def nk_nine_slice_handle(handle: nk_handle, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort)(using Zone): nk_nine_slice = 
    val _ptr_return = alloc[nk_nine_slice](1)
    __sn_wrap_nk_nine_slice_handle(handle, l, t, r, b, _ptr_return)
    !_ptr_return

  def nk_nine_slice_id(id: CInt, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort)(using Zone): nk_nine_slice = 
    val _ptr_return = alloc[nk_nine_slice](1)
    __sn_wrap_nk_nine_slice_id(id, l, t, r, b, _ptr_return)
    !_ptr_return

  def nk_nine_slice_ptr(ptr: Ptr[Byte], l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort)(using Zone): nk_nine_slice = 
    val _ptr_return = alloc[nk_nine_slice](1)
    __sn_wrap_nk_nine_slice_ptr(ptr, l, t, r, b, _ptr_return)
    !_ptr_return

  def nk_nonblock_begin(ctx: Ptr[nk_context], flags: nk_flags, body: nk_rect, header: nk_rect, panel_type: nk_panel_type)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = body
    val _ptr_3 = alloc[nk_rect](1)
    !_ptr_3 = header
    __sn_wrap_nk_nonblock_begin(ctx, flags, _ptr_2, _ptr_3, panel_type)

  def nk_pad_rect(r: nk_rect, pad: nk_vec2)(using Zone): nk_rect = 
    val _ptr_0 = alloc[nk_rect](1)
    !_ptr_0 = r
    val _ptr_1 = alloc[nk_vec2](1)
    !_ptr_1 = pad
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_pad_rect(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def nk_panel_get_border_color(style: Ptr[nk_style], `type`: nk_panel_type)(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_panel_get_border_color(style, `type`, _ptr_return)
    !_ptr_return

  def nk_panel_get_padding(style: Ptr[nk_style], `type`: nk_panel_type)(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_panel_get_padding(style, `type`, _ptr_return)
    !_ptr_return

  def nk_popup_begin(ctx: Ptr[nk_context], `type`: nk_popup_type, title: CString, flags: nk_flags, rect: nk_rect)(using Zone): nk_bool = 
    val _ptr_4 = alloc[nk_rect](1)
    !_ptr_4 = rect
    __sn_wrap_nk_popup_begin(ctx, `type`, title, flags, _ptr_4)

  def nk_progress_behavior(state: Ptr[nk_flags], in: Ptr[nk_input], r: nk_rect, cursor: nk_rect, max: nk_size, value: nk_size, modifiable: nk_bool)(using Zone): nk_size = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = r
    val _ptr_3 = alloc[nk_rect](1)
    !_ptr_3 = cursor
    __sn_wrap_nk_progress_behavior(state, in, _ptr_2, _ptr_3, max, value, modifiable)

  def nk_property_behavior(ws: Ptr[nk_flags], in: Ptr[nk_input], property: nk_rect, label: nk_rect, edit: nk_rect, empty: nk_rect, state: Ptr[CInt], variant: Ptr[nk_property_variant], inc_per_pixel: Float)(using Zone): Unit = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = property
    val _ptr_3 = alloc[nk_rect](1)
    !_ptr_3 = label
    val _ptr_4 = alloc[nk_rect](1)
    !_ptr_4 = edit
    val _ptr_5 = alloc[nk_rect](1)
    !_ptr_5 = empty
    __sn_wrap_nk_property_behavior(ws, in, _ptr_2, _ptr_3, _ptr_4, _ptr_5, state, variant, inc_per_pixel)

  def nk_property_variant_double(value: Double, min_value: Double, max_value: Double, step: Double)(using Zone): nk_property_variant = 
    val _ptr_return = alloc[nk_property_variant](1)
    __sn_wrap_nk_property_variant_double(value, min_value, max_value, step, _ptr_return)
    !_ptr_return

  def nk_property_variant_float(value: Float, min_value: Float, max_value: Float, step: Float)(using Zone): nk_property_variant = 
    val _ptr_return = alloc[nk_property_variant](1)
    __sn_wrap_nk_property_variant_float(value, min_value, max_value, step, _ptr_return)
    !_ptr_return

  def nk_property_variant_int(value: CInt, min_value: CInt, max_value: CInt, step: CInt)(using Zone): nk_property_variant = 
    val _ptr_return = alloc[nk_property_variant](1)
    __sn_wrap_nk_property_variant_int(value, min_value, max_value, step, _ptr_return)
    !_ptr_return

  def nk_push_custom(b: Ptr[nk_command_buffer], r: nk_rect, cb: nk_command_custom_callback, usr: nk_handle)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = r
    __sn_wrap_nk_push_custom(b, _ptr_1, cb, usr)

  def nk_push_scissor(b: Ptr[nk_command_buffer], r: nk_rect)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = r
    __sn_wrap_nk_push_scissor(b, _ptr_1)

  def nk_rect(x: Float, y: Float, w: Float, h: Float)(using Zone): nk_rect = 
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_rect(x, y, w, h, _ptr_return)
    !_ptr_return

  def nk_rect_pos(r: nk_rect)(using Zone): nk_vec2 = 
    val _ptr_0 = alloc[nk_rect](1)
    !_ptr_0 = r
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_rect_pos(_ptr_0, _ptr_return)
    !_ptr_return

  def nk_rect_size(r: nk_rect)(using Zone): nk_vec2 = 
    val _ptr_0 = alloc[nk_rect](1)
    !_ptr_0 = r
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_rect_size(_ptr_0, _ptr_return)
    !_ptr_return

  def nk_recta(pos: nk_vec2, size: nk_vec2)(using Zone): nk_rect = 
    val _ptr_0 = alloc[nk_vec2](1)
    !_ptr_0 = pos
    val _ptr_1 = alloc[nk_vec2](1)
    !_ptr_1 = size
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_recta(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def nk_recti(x: CInt, y: CInt, w: CInt, h: CInt)(using Zone): nk_rect = 
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_recti(x, y, w, h, _ptr_return)
    !_ptr_return

  def nk_rectiv(r: Ptr[CInt])(using Zone): nk_rect = 
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_rectiv(r, _ptr_return)
    !_ptr_return

  def nk_rectv(xywh: Ptr[Float])(using Zone): nk_rect = 
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_rectv(xywh, _ptr_return)
    !_ptr_return

  def nk_rgb(r: CInt, g: CInt, b: CInt)(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgb(r, g, b, _ptr_return)
    !_ptr_return

  def nk_rgb_bv(c: Ptr[nk_byte])(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgb_bv(c, _ptr_return)
    !_ptr_return

  def nk_rgb_cf(c: nk_colorf)(using Zone): nk_color = 
    val _ptr_0 = alloc[nk_colorf](1)
    !_ptr_0 = c
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgb_cf(_ptr_0, _ptr_return)
    !_ptr_return

  def nk_rgb_f(r: Float, g: Float, b: Float)(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgb_f(r, g, b, _ptr_return)
    !_ptr_return

  def nk_rgb_fv(c: Ptr[Float])(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgb_fv(c, _ptr_return)
    !_ptr_return

  def nk_rgb_hex(rgb: CString)(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgb_hex(rgb, _ptr_return)
    !_ptr_return

  def nk_rgb_iv(c: Ptr[CInt])(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgb_iv(c, _ptr_return)
    !_ptr_return

  def nk_rgba(r: CInt, g: CInt, b: CInt, a: CInt)(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgba(r, g, b, a, _ptr_return)
    !_ptr_return

  def nk_rgba_bv(rgba: Ptr[nk_byte])(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgba_bv(rgba, _ptr_return)
    !_ptr_return

  def nk_rgba_cf(c: nk_colorf)(using Zone): nk_color = 
    val _ptr_0 = alloc[nk_colorf](1)
    !_ptr_0 = c
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgba_cf(_ptr_0, _ptr_return)
    !_ptr_return

  def nk_rgba_f(r: Float, g: Float, b: Float, a: Float)(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgba_f(r, g, b, a, _ptr_return)
    !_ptr_return

  def nk_rgba_fv(c: Ptr[Float])(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgba_fv(c, _ptr_return)
    !_ptr_return

  def nk_rgba_hex(rgb: CString)(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgba_hex(rgb, _ptr_return)
    !_ptr_return

  def nk_rgba_iv(rgba: Ptr[CInt])(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgba_iv(rgba, _ptr_return)
    !_ptr_return

  def nk_rgba_u32(in: nk_uint)(using Zone): nk_color = 
    val _ptr_return = alloc[nk_color](1)
    __sn_wrap_nk_rgba_u32(in, _ptr_return)
    !_ptr_return

  def nk_select_image_label(ctx: Ptr[nk_context], img: nk_image, str: CString, align: nk_flags, value: nk_bool)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_select_image_label(ctx, _ptr_1, str, align, value)

  def nk_select_image_text(ctx: Ptr[nk_context], img: nk_image, str: CString, len: CInt, align: nk_flags, value: nk_bool)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_select_image_text(ctx, _ptr_1, str, len, align, value)

  def nk_selectable_image_label(ctx: Ptr[nk_context], img: nk_image, str: CString, align: nk_flags, value: Ptr[nk_bool])(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_selectable_image_label(ctx, _ptr_1, str, align, value)

  def nk_selectable_image_text(ctx: Ptr[nk_context], img: nk_image, str: CString, len: CInt, align: nk_flags, value: Ptr[nk_bool])(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_image](1)
    !_ptr_1 = img
    __sn_wrap_nk_selectable_image_text(ctx, _ptr_1, str, len, align, value)

  def nk_shrink_rect(r: nk_rect, amount: Float)(using Zone): nk_rect = 
    val _ptr_0 = alloc[nk_rect](1)
    !_ptr_0 = r
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_shrink_rect(_ptr_0, amount, _ptr_return)
    !_ptr_return

  def nk_slider_behavior(state: Ptr[nk_flags], logical_cursor: Ptr[nk_rect], visual_cursor: Ptr[nk_rect], in: Ptr[nk_input], bounds: nk_rect, slider_min: Float, slider_max: Float, slider_value: Float, slider_step: Float, slider_steps: Float)(using Zone): Float = 
    val _ptr_4 = alloc[nk_rect](1)
    !_ptr_4 = bounds
    __sn_wrap_nk_slider_behavior(state, logical_cursor, visual_cursor, in, _ptr_4, slider_min, slider_max, slider_value, slider_step, slider_steps)

  def nk_stroke_arc(b: Ptr[nk_command_buffer], cx: Float, cy: Float, radius: Float, a_min: Float, a_max: Float, line_thickness: Float, c: nk_color)(using Zone): Unit = 
    val _ptr_7 = alloc[nk_color](1)
    !_ptr_7 = c
    __sn_wrap_nk_stroke_arc(b, cx, cy, radius, a_min, a_max, line_thickness, _ptr_7)

  def nk_stroke_circle(b: Ptr[nk_command_buffer], r: nk_rect, line_thickness: Float, c: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = r
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = c
    __sn_wrap_nk_stroke_circle(b, _ptr_1, line_thickness, _ptr_3)

  def nk_stroke_curve(b: Ptr[nk_command_buffer], ax: Float, ay: Float, ctrl0x: Float, ctrl0y: Float, ctrl1x: Float, ctrl1y: Float, bx: Float, by: Float, line_thickness: Float, col: nk_color)(using Zone): Unit = 
    val _ptr_10 = alloc[nk_color](1)
    !_ptr_10 = col
    __sn_wrap_nk_stroke_curve(b, ax, ay, ctrl0x, ctrl0y, ctrl1x, ctrl1y, bx, by, line_thickness, _ptr_10)

  def nk_stroke_line(b: Ptr[nk_command_buffer], x0: Float, y0: Float, x1: Float, y1: Float, line_thickness: Float, c: nk_color)(using Zone): Unit = 
    val _ptr_6 = alloc[nk_color](1)
    !_ptr_6 = c
    __sn_wrap_nk_stroke_line(b, x0, y0, x1, y1, line_thickness, _ptr_6)

  def nk_stroke_polygon(b: Ptr[nk_command_buffer], points: Ptr[Float], point_count: CInt, line_thickness: Float, col: nk_color)(using Zone): Unit = 
    val _ptr_4 = alloc[nk_color](1)
    !_ptr_4 = col
    __sn_wrap_nk_stroke_polygon(b, points, point_count, line_thickness, _ptr_4)

  def nk_stroke_polyline(b: Ptr[nk_command_buffer], points: Ptr[Float], point_count: CInt, line_thickness: Float, col: nk_color)(using Zone): Unit = 
    val _ptr_4 = alloc[nk_color](1)
    !_ptr_4 = col
    __sn_wrap_nk_stroke_polyline(b, points, point_count, line_thickness, _ptr_4)

  def nk_stroke_rect(b: Ptr[nk_command_buffer], rect: nk_rect, rounding: Float, line_thickness: Float, c: nk_color)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = rect
    val _ptr_4 = alloc[nk_color](1)
    !_ptr_4 = c
    __sn_wrap_nk_stroke_rect(b, _ptr_1, rounding, line_thickness, _ptr_4)

  def nk_stroke_triangle(b: Ptr[nk_command_buffer], x0: Float, y0: Float, x1: Float, y1: Float, x2: Float, y2: Float, line_thickness: Float, c: nk_color)(using Zone): Unit = 
    val _ptr_8 = alloc[nk_color](1)
    !_ptr_8 = c
    __sn_wrap_nk_stroke_triangle(b, x0, y0, x1, y1, x2, y2, line_thickness, _ptr_8)

  def nk_style_item_color(col: nk_color)(using Zone): nk_style_item = 
    val _ptr_0 = alloc[nk_color](1)
    !_ptr_0 = col
    val _ptr_return = alloc[nk_style_item](1)
    __sn_wrap_nk_style_item_color(_ptr_0, _ptr_return)
    !_ptr_return

  def nk_style_item_hide()(using Zone): nk_style_item = 
    val _ptr_return = alloc[nk_style_item](1)
    __sn_wrap_nk_style_item_hide(_ptr_return)
    !_ptr_return

  def nk_style_item_image(img: nk_image)(using Zone): nk_style_item = 
    val _ptr_0 = alloc[nk_image](1)
    !_ptr_0 = img
    val _ptr_return = alloc[nk_style_item](1)
    __sn_wrap_nk_style_item_image(_ptr_0, _ptr_return)
    !_ptr_return

  def nk_style_item_nine_slice(slice: nk_nine_slice)(using Zone): nk_style_item = 
    val _ptr_0 = alloc[nk_nine_slice](1)
    !_ptr_0 = slice
    val _ptr_return = alloc[nk_style_item](1)
    __sn_wrap_nk_style_item_nine_slice(_ptr_0, _ptr_return)
    !_ptr_return

  def nk_style_push_color(ctx: Ptr[nk_context], address: Ptr[nk_color], value: nk_color)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_color](1)
    !_ptr_2 = value
    __sn_wrap_nk_style_push_color(ctx, address, _ptr_2)

  def nk_style_push_style_item(ctx: Ptr[nk_context], address: Ptr[nk_style_item], value: nk_style_item)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_style_item](1)
    !_ptr_2 = value
    __sn_wrap_nk_style_push_style_item(ctx, address, _ptr_2)

  def nk_style_push_vec2(ctx: Ptr[nk_context], address: Ptr[nk_vec2], value: nk_vec2)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_vec2](1)
    !_ptr_2 = value
    __sn_wrap_nk_style_push_vec2(ctx, address, _ptr_2)

  def nk_sub9slice_handle(handle: nk_handle, w: nk_ushort, h: nk_ushort, rgn: nk_rect, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort)(using Zone): nk_nine_slice = 
    val _ptr_3 = alloc[nk_rect](1)
    !_ptr_3 = rgn
    val _ptr_return = alloc[nk_nine_slice](1)
    __sn_wrap_nk_sub9slice_handle(handle, w, h, _ptr_3, l, t, r, b, _ptr_return)
    !_ptr_return

  def nk_sub9slice_id(id: CInt, w: nk_ushort, h: nk_ushort, rgn: nk_rect, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort)(using Zone): nk_nine_slice = 
    val _ptr_3 = alloc[nk_rect](1)
    !_ptr_3 = rgn
    val _ptr_return = alloc[nk_nine_slice](1)
    __sn_wrap_nk_sub9slice_id(id, w, h, _ptr_3, l, t, r, b, _ptr_return)
    !_ptr_return

  def nk_sub9slice_ptr(ptr: Ptr[Byte], w: nk_ushort, h: nk_ushort, rgn: nk_rect, l: nk_ushort, t: nk_ushort, r: nk_ushort, b: nk_ushort)(using Zone): nk_nine_slice = 
    val _ptr_3 = alloc[nk_rect](1)
    !_ptr_3 = rgn
    val _ptr_return = alloc[nk_nine_slice](1)
    __sn_wrap_nk_sub9slice_ptr(ptr, w, h, _ptr_3, l, t, r, b, _ptr_return)
    !_ptr_return

  def nk_subimage_handle(handle: nk_handle, w: nk_ushort, h: nk_ushort, r: nk_rect)(using Zone): nk_image = 
    val _ptr_3 = alloc[nk_rect](1)
    !_ptr_3 = r
    val _ptr_return = alloc[nk_image](1)
    __sn_wrap_nk_subimage_handle(handle, w, h, _ptr_3, _ptr_return)
    !_ptr_return

  def nk_subimage_id(id: CInt, w: nk_ushort, h: nk_ushort, r: nk_rect)(using Zone): nk_image = 
    val _ptr_3 = alloc[nk_rect](1)
    !_ptr_3 = r
    val _ptr_return = alloc[nk_image](1)
    __sn_wrap_nk_subimage_id(id, w, h, _ptr_3, _ptr_return)
    !_ptr_return

  def nk_subimage_ptr(ptr: Ptr[Byte], w: nk_ushort, h: nk_ushort, r: nk_rect)(using Zone): nk_image = 
    val _ptr_3 = alloc[nk_rect](1)
    !_ptr_3 = r
    val _ptr_return = alloc[nk_image](1)
    __sn_wrap_nk_subimage_ptr(ptr, w, h, _ptr_3, _ptr_return)
    !_ptr_return

  def nk_text_calculate_text_bounds(font: Ptr[nk_user_font], begin: CString, byte_len: CInt, row_height: Float, remaining: Ptr[CString], out_offset: Ptr[nk_vec2], glyphs: Ptr[CInt], op: CInt)(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_text_calculate_text_bounds(font, begin, byte_len, row_height, remaining, out_offset, glyphs, op, _ptr_return)
    !_ptr_return

  def nk_text_colored(ctx: Ptr[nk_context], str: CString, len: CInt, alignment: nk_flags, color: nk_color)(using Zone): Unit = 
    val _ptr_4 = alloc[nk_color](1)
    !_ptr_4 = color
    __sn_wrap_nk_text_colored(ctx, str, len, alignment, _ptr_4)

  def nk_text_wrap_colored(ctx: Ptr[nk_context], str: CString, len: CInt, color: nk_color)(using Zone): Unit = 
    val _ptr_3 = alloc[nk_color](1)
    !_ptr_3 = color
    __sn_wrap_nk_text_wrap_colored(ctx, str, len, _ptr_3)

  def nk_toggle_behavior(in: Ptr[nk_input], select: nk_rect, state: Ptr[nk_flags], active: nk_bool)(using Zone): nk_bool = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = select
    __sn_wrap_nk_toggle_behavior(in, _ptr_1, state, active)

  def nk_tree_element_image_push_hashed(ctx: Ptr[nk_context], `type`: nk_tree_type, img: nk_image, title: CString, initial_state: nk_collapse_states, selected: Ptr[nk_bool], hash: CString, len: CInt, seed: CInt)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_image](1)
    !_ptr_2 = img
    __sn_wrap_nk_tree_element_image_push_hashed(ctx, `type`, _ptr_2, title, initial_state, selected, hash, len, seed)

  def nk_tree_image_push_hashed(ctx: Ptr[nk_context], `type`: nk_tree_type, img: nk_image, title: CString, initial_state: nk_collapse_states, hash: CString, len: CInt, seed: CInt)(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_image](1)
    !_ptr_2 = img
    __sn_wrap_nk_tree_image_push_hashed(ctx, `type`, _ptr_2, title, initial_state, hash, len, seed)

  def nk_tree_state_image_push(ctx: Ptr[nk_context], `type`: nk_tree_type, img: nk_image, title: CString, state: Ptr[nk_collapse_states])(using Zone): nk_bool = 
    val _ptr_2 = alloc[nk_image](1)
    !_ptr_2 = img
    __sn_wrap_nk_tree_state_image_push(ctx, `type`, _ptr_2, title, state)

  def nk_triangle_from_direction(result: Ptr[nk_vec2], r: nk_rect, pad_x: Float, pad_y: Float, direction: nk_heading)(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = r
    __sn_wrap_nk_triangle_from_direction(result, _ptr_1, pad_x, pad_y, direction)

  def nk_vec2(x: Float, y: Float)(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_vec2(x, y, _ptr_return)
    !_ptr_return

  def nk_vec2i(x: CInt, y: CInt)(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_vec2i(x, y, _ptr_return)
    !_ptr_return

  def nk_vec2iv(xy: Ptr[CInt])(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_vec2iv(xy, _ptr_return)
    !_ptr_return

  def nk_vec2v(xy: Ptr[Float])(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_vec2v(xy, _ptr_return)
    !_ptr_return

  def nk_widget_bounds(ctx: Ptr[nk_context])(using Zone): nk_rect = 
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_widget_bounds(ctx, _ptr_return)
    !_ptr_return

  def nk_widget_fitting(bounds: Ptr[nk_rect], ctx: Ptr[nk_context], item_padding: nk_vec2)(using Zone): nk_widget_layout_states = 
    val _ptr_2 = alloc[nk_vec2](1)
    !_ptr_2 = item_padding
    __sn_wrap_nk_widget_fitting(bounds, ctx, _ptr_2)

  def nk_widget_position(ctx: Ptr[nk_context])(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_widget_position(ctx, _ptr_return)
    !_ptr_return

  def nk_widget_size(ctx: Ptr[nk_context])(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_widget_size(ctx, _ptr_return)
    !_ptr_return

  def nk_widget_text(o: Ptr[nk_command_buffer], b: nk_rect, string: CString, len: CInt, t: Ptr[nk_text], a: nk_flags, f: Ptr[nk_user_font])(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = b
    __sn_wrap_nk_widget_text(o, _ptr_1, string, len, t, a, f)

  def nk_widget_text_wrap(o: Ptr[nk_command_buffer], b: nk_rect, string: CString, len: CInt, t: Ptr[nk_text], f: Ptr[nk_user_font])(using Zone): Unit = 
    val _ptr_1 = alloc[nk_rect](1)
    !_ptr_1 = b
    __sn_wrap_nk_widget_text_wrap(o, _ptr_1, string, len, t, f)

  def nk_window_get_bounds(ctx: Ptr[nk_context])(using Zone): nk_rect = 
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_window_get_bounds(ctx, _ptr_return)
    !_ptr_return

  def nk_window_get_content_region(ctx: Ptr[nk_context])(using Zone): nk_rect = 
    val _ptr_return = alloc[nk_rect](1)
    __sn_wrap_nk_window_get_content_region(ctx, _ptr_return)
    !_ptr_return

  def nk_window_get_content_region_max(ctx: Ptr[nk_context])(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_window_get_content_region_max(ctx, _ptr_return)
    !_ptr_return

  def nk_window_get_content_region_min(ctx: Ptr[nk_context])(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_window_get_content_region_min(ctx, _ptr_return)
    !_ptr_return

  def nk_window_get_content_region_size(ctx: Ptr[nk_context])(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_window_get_content_region_size(ctx, _ptr_return)
    !_ptr_return

  def nk_window_get_position(ctx: Ptr[nk_context])(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_window_get_position(ctx, _ptr_return)
    !_ptr_return

  def nk_window_get_size(ctx: Ptr[nk_context])(using Zone): nk_vec2 = 
    val _ptr_return = alloc[nk_vec2](1)
    __sn_wrap_nk_window_get_size(ctx, _ptr_return)
    !_ptr_return

  def nk_window_set_bounds(ctx: Ptr[nk_context], name: CString, bounds: nk_rect)(using Zone): Unit = 
    val _ptr_2 = alloc[nk_rect](1)
    !_ptr_2 = bounds
    __sn_wrap_nk_window_set_bounds(ctx, name, _ptr_2)

  def nk_window_set_position(ctx: Ptr[nk_context], name: CString, pos: nk_vec2)(using Zone): Unit = 
    val _ptr_2 = alloc[nk_vec2](1)
    !_ptr_2 = pos
    __sn_wrap_nk_window_set_position(ctx, name, _ptr_2)

  def nk_window_set_size(ctx: Ptr[nk_context], name: CString, size: nk_vec2)(using Zone): Unit = 
    val _ptr_2 = alloc[nk_vec2](1)
    !_ptr_2 = size
    __sn_wrap_nk_window_set_size(ctx, name, _ptr_2)

