#include <string.h>
#include <nuklear.h>


nk_bool __sn_wrap_nk_begin(struct nk_context * ctx, const char * title, struct nk_rect *bounds, nk_flags flags) {
 return nk_begin(ctx, title, *bounds, flags);
};

nk_bool __sn_wrap_nk_begin_titled(struct nk_context * ctx, const char * name, const char * title, struct nk_rect *bounds, nk_flags flags) {
 return nk_begin_titled(ctx, name, title, *bounds, flags);
};

nk_bool __sn_wrap_nk_button_behavior(nk_flags * state, struct nk_rect *r, const struct nk_input * i, enum nk_button_behavior behavior) {
 return nk_button_behavior(state, *r, i, behavior);
};

nk_bool __sn_wrap_nk_button_color(struct nk_context * ctx, struct nk_color *color) {
 return nk_button_color(ctx, *color);
};

nk_bool __sn_wrap_nk_button_image(struct nk_context * ctx, struct nk_image *img) {
 return nk_button_image(ctx, *img);
};

nk_bool __sn_wrap_nk_button_image_label(struct nk_context * ctx, struct nk_image *img, const char * label, nk_flags align) {
 return nk_button_image_label(ctx, *img, label, align);
};

nk_bool __sn_wrap_nk_button_image_label_styled(struct nk_context * ctx, const struct nk_style_button * style, struct nk_image *img, const char * label, nk_flags text_alignment) {
 return nk_button_image_label_styled(ctx, style, *img, label, text_alignment);
};

nk_bool __sn_wrap_nk_button_image_styled(struct nk_context * ctx, const struct nk_style_button * style, struct nk_image *img) {
 return nk_button_image_styled(ctx, style, *img);
};

nk_bool __sn_wrap_nk_button_image_text(struct nk_context * ctx, struct nk_image *img, const char * text, int len, nk_flags align) {
 return nk_button_image_text(ctx, *img, text, len, align);
};

nk_bool __sn_wrap_nk_button_image_text_styled(struct nk_context * ctx, const struct nk_style_button * style, struct nk_image *img, const char * text, int len, nk_flags align) {
 return nk_button_image_text_styled(ctx, style, *img, text, len, align);
};

void __sn_wrap_nk_chart_add_slot_colored(struct nk_context * ctx, const enum nk_chart_type type, struct nk_color *color, struct nk_color *highlight, int count, float min_value, float max_value) {
 nk_chart_add_slot_colored(ctx, type, *color, *highlight, count, min_value, max_value);
};

nk_bool __sn_wrap_nk_chart_begin_colored(struct nk_context * ctx, enum nk_chart_type type, struct nk_color *color, struct nk_color *highlight, int count, float min_value, float max_value) {
 return nk_chart_begin_colored(ctx, type, *color, *highlight, count, min_value, max_value);
};

void __sn_wrap_nk_color_cf(struct nk_color *in, struct nk_colorf *__return) {
  nk_colorf ____ret = nk_color_cf(*in);
  memcpy(__return, &____ret, sizeof(nk_colorf));
}

void __sn_wrap_nk_color_d(double * r, double * g, double * b, double * a, struct nk_color *in) {
 nk_color_d(r, g, b, a, *in);
};

void __sn_wrap_nk_color_dv(double * c, struct nk_color *in) {
 nk_color_dv(c, *in);
};

void __sn_wrap_nk_color_f(float * r, float * g, float * b, float * a, struct nk_color *in) {
 nk_color_f(r, g, b, a, *in);
};

void __sn_wrap_nk_color_fv(float * c, struct nk_color *in) {
 nk_color_fv(c, *in);
};

void __sn_wrap_nk_color_hex_rgb(char * output, struct nk_color *col) {
 nk_color_hex_rgb(output, *col);
};

void __sn_wrap_nk_color_hex_rgba(char * output, struct nk_color *col) {
 nk_color_hex_rgba(output, *col);
};

void __sn_wrap_nk_color_hsv_b(nk_byte * out_h, nk_byte * out_s, nk_byte * out_v, struct nk_color *in) {
 nk_color_hsv_b(out_h, out_s, out_v, *in);
};

void __sn_wrap_nk_color_hsv_bv(nk_byte * out, struct nk_color *in) {
 nk_color_hsv_bv(out, *in);
};

void __sn_wrap_nk_color_hsv_f(float * out_h, float * out_s, float * out_v, struct nk_color *in) {
 nk_color_hsv_f(out_h, out_s, out_v, *in);
};

void __sn_wrap_nk_color_hsv_fv(float * out, struct nk_color *in) {
 nk_color_hsv_fv(out, *in);
};

void __sn_wrap_nk_color_hsv_i(int * out_h, int * out_s, int * out_v, struct nk_color *in) {
 nk_color_hsv_i(out_h, out_s, out_v, *in);
};

void __sn_wrap_nk_color_hsv_iv(int * out, struct nk_color *in) {
 nk_color_hsv_iv(out, *in);
};

void __sn_wrap_nk_color_hsva_b(nk_byte * h, nk_byte * s, nk_byte * v, nk_byte * a, struct nk_color *in) {
 nk_color_hsva_b(h, s, v, a, *in);
};

void __sn_wrap_nk_color_hsva_bv(nk_byte * out, struct nk_color *in) {
 nk_color_hsva_bv(out, *in);
};

void __sn_wrap_nk_color_hsva_f(float * out_h, float * out_s, float * out_v, float * out_a, struct nk_color *in) {
 nk_color_hsva_f(out_h, out_s, out_v, out_a, *in);
};

void __sn_wrap_nk_color_hsva_fv(float * out, struct nk_color *in) {
 nk_color_hsva_fv(out, *in);
};

void __sn_wrap_nk_color_hsva_i(int * out_h, int * out_s, int * out_v, int * out_a, struct nk_color *in) {
 nk_color_hsva_i(out_h, out_s, out_v, out_a, *in);
};

void __sn_wrap_nk_color_hsva_iv(int * out, struct nk_color *in) {
 nk_color_hsva_iv(out, *in);
};

void __sn_wrap_nk_color_picker(struct nk_context * ctx, struct nk_colorf *color, enum nk_color_format fmt, struct nk_colorf *__return) {
  nk_colorf ____ret = nk_color_picker(ctx, *color, fmt);
  memcpy(__return, &____ret, sizeof(nk_colorf));
}

nk_uint __sn_wrap_nk_color_u32(struct nk_color *in) {
 return nk_color_u32(*in);
};

void __sn_wrap_nk_colorf_hsva_f(float * out_h, float * out_s, float * out_v, float * out_a, struct nk_colorf *in) {
 nk_colorf_hsva_f(out_h, out_s, out_v, out_a, *in);
};

void __sn_wrap_nk_colorf_hsva_fv(float * hsva, struct nk_colorf *in) {
 nk_colorf_hsva_fv(hsva, *in);
};

int __sn_wrap_nk_combo(struct nk_context * ctx, const char ** items, int count, int selected, int item_height, struct nk_vec2 *size) {
 return nk_combo(ctx, items, count, selected, item_height, *size);
};

nk_bool __sn_wrap_nk_combo_begin(struct nk_context * ctx, struct nk_window * win, struct nk_vec2 *size, nk_bool is_clicked, struct nk_rect *header) {
 return nk_combo_begin(ctx, win, *size, is_clicked, *header);
};

nk_bool __sn_wrap_nk_combo_begin_color(struct nk_context * ctx, struct nk_color *color, struct nk_vec2 *size) {
 return nk_combo_begin_color(ctx, *color, *size);
};

nk_bool __sn_wrap_nk_combo_begin_image(struct nk_context * ctx, struct nk_image *img, struct nk_vec2 *size) {
 return nk_combo_begin_image(ctx, *img, *size);
};

nk_bool __sn_wrap_nk_combo_begin_image_label(struct nk_context * ctx, const char * selected, struct nk_image *img, struct nk_vec2 *size) {
 return nk_combo_begin_image_label(ctx, selected, *img, *size);
};

nk_bool __sn_wrap_nk_combo_begin_image_text(struct nk_context * ctx, const char * selected, int len, struct nk_image *img, struct nk_vec2 *size) {
 return nk_combo_begin_image_text(ctx, selected, len, *img, *size);
};

nk_bool __sn_wrap_nk_combo_begin_label(struct nk_context * ctx, const char * selected, struct nk_vec2 *size) {
 return nk_combo_begin_label(ctx, selected, *size);
};

nk_bool __sn_wrap_nk_combo_begin_symbol(struct nk_context * ctx, enum nk_symbol_type symbol, struct nk_vec2 *size) {
 return nk_combo_begin_symbol(ctx, symbol, *size);
};

nk_bool __sn_wrap_nk_combo_begin_symbol_label(struct nk_context * ctx, const char * selected, enum nk_symbol_type type, struct nk_vec2 *size) {
 return nk_combo_begin_symbol_label(ctx, selected, type, *size);
};

nk_bool __sn_wrap_nk_combo_begin_symbol_text(struct nk_context * ctx, const char * selected, int len, enum nk_symbol_type symbol, struct nk_vec2 *size) {
 return nk_combo_begin_symbol_text(ctx, selected, len, symbol, *size);
};

nk_bool __sn_wrap_nk_combo_begin_text(struct nk_context * ctx, const char * selected, int len, struct nk_vec2 *size) {
 return nk_combo_begin_text(ctx, selected, len, *size);
};

int __sn_wrap_nk_combo_callback(struct nk_context * ctx, void (*)(void *, int, const char **) item_getter, void * userdata, int selected, int count, int item_height, struct nk_vec2 *size) {
 return nk_combo_callback(ctx, item_getter, userdata, selected, count, item_height, *size);
};

nk_bool __sn_wrap_nk_combo_item_image_label(struct nk_context * ctx, struct nk_image *img, const char * text, nk_flags alignment) {
 return nk_combo_item_image_label(ctx, *img, text, alignment);
};

nk_bool __sn_wrap_nk_combo_item_image_text(struct nk_context * ctx, struct nk_image *img, const char * text, int len, nk_flags alignment) {
 return nk_combo_item_image_text(ctx, *img, text, len, alignment);
};

int __sn_wrap_nk_combo_separator(struct nk_context * ctx, const char * items_separated_by_separator, int separator, int selected, int count, int item_height, struct nk_vec2 *size) {
 return nk_combo_separator(ctx, items_separated_by_separator, separator, selected, count, item_height, *size);
};

int __sn_wrap_nk_combo_string(struct nk_context * ctx, const char * items_separated_by_zeros, int selected, int count, int item_height, struct nk_vec2 *size) {
 return nk_combo_string(ctx, items_separated_by_zeros, selected, count, item_height, *size);
};

void __sn_wrap_nk_combobox(struct nk_context * ctx, const char ** items, int count, int * selected, int item_height, struct nk_vec2 *size) {
 nk_combobox(ctx, items, count, selected, item_height, *size);
};

void __sn_wrap_nk_combobox_callback(struct nk_context * ctx, void (*)(void *, int, const char **) item_getter, void * userdata, int * selected, int count, int item_height, struct nk_vec2 *size) {
 nk_combobox_callback(ctx, item_getter, userdata, selected, count, item_height, *size);
};

void __sn_wrap_nk_combobox_separator(struct nk_context * ctx, const char * items_separated_by_separator, int separator, int * selected, int count, int item_height, struct nk_vec2 *size) {
 nk_combobox_separator(ctx, items_separated_by_separator, separator, selected, count, item_height, *size);
};

void __sn_wrap_nk_combobox_string(struct nk_context * ctx, const char * items_separated_by_zeros, int * selected, int count, int item_height, struct nk_vec2 *size) {
 nk_combobox_string(ctx, items_separated_by_zeros, selected, count, item_height, *size);
};

nk_bool __sn_wrap_nk_contextual_begin(struct nk_context * ctx, nk_flags flags, struct nk_vec2 *size, struct nk_rect *trigger_bounds) {
 return nk_contextual_begin(ctx, flags, *size, *trigger_bounds);
};

nk_bool __sn_wrap_nk_contextual_item_image_label(struct nk_context * ctx, struct nk_image *img, const char * label, nk_flags align) {
 return nk_contextual_item_image_label(ctx, *img, label, align);
};

nk_bool __sn_wrap_nk_contextual_item_image_text(struct nk_context * ctx, struct nk_image *img, const char * text, int len, nk_flags align) {
 return nk_contextual_item_image_text(ctx, *img, text, len, align);
};

nk_bool __sn_wrap_nk_do_button(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *r, const struct nk_style_button * style, const struct nk_input * in, enum nk_button_behavior behavior, struct nk_rect * content) {
 return nk_do_button(state, out, *r, style, in, behavior, content);
};

nk_bool __sn_wrap_nk_do_button_image(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *bounds, struct nk_image *img, enum nk_button_behavior b, const struct nk_style_button * style, const struct nk_input * in) {
 return nk_do_button_image(state, out, *bounds, *img, b, style, in);
};

nk_bool __sn_wrap_nk_do_button_symbol(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *bounds, enum nk_symbol_type symbol, enum nk_button_behavior behavior, const struct nk_style_button * style, const struct nk_input * in, const struct nk_user_font * font) {
 return nk_do_button_symbol(state, out, *bounds, symbol, behavior, style, in, font);
};

nk_bool __sn_wrap_nk_do_button_text(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *bounds, const char * string, int len, nk_flags align, enum nk_button_behavior behavior, const struct nk_style_button * style, const struct nk_input * in, const struct nk_user_font * font) {
 return nk_do_button_text(state, out, *bounds, string, len, align, behavior, style, in, font);
};

nk_bool __sn_wrap_nk_do_button_text_image(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *bounds, struct nk_image *img, const char * str, int len, nk_flags align, enum nk_button_behavior behavior, const struct nk_style_button * style, const struct nk_user_font * font, const struct nk_input * in) {
 return nk_do_button_text_image(state, out, *bounds, *img, str, len, align, behavior, style, font, in);
};

nk_bool __sn_wrap_nk_do_button_text_symbol(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *bounds, enum nk_symbol_type symbol, const char * str, int len, nk_flags align, enum nk_button_behavior behavior, const struct nk_style_button * style, const struct nk_user_font * font, const struct nk_input * in) {
 return nk_do_button_text_symbol(state, out, *bounds, symbol, str, len, align, behavior, style, font, in);
};

nk_bool __sn_wrap_nk_do_color_picker(nk_flags * state, struct nk_command_buffer * out, struct nk_colorf * col, enum nk_color_format fmt, struct nk_rect *bounds, struct nk_vec2 *padding, const struct nk_input * in, const struct nk_user_font * font) {
 return nk_do_color_picker(state, out, col, fmt, *bounds, *padding, in, font);
};

nk_flags __sn_wrap_nk_do_edit(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *bounds, nk_flags flags, nk_plugin_filter filter, struct nk_text_edit * edit, const struct nk_style_edit * style, struct nk_input * in, const struct nk_user_font * font) {
 return nk_do_edit(state, out, *bounds, flags, filter, edit, style, in, font);
};

nk_size __sn_wrap_nk_do_progress(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *bounds, nk_size value, nk_size max, nk_bool modifiable, const struct nk_style_progress * style, struct nk_input * in) {
 return nk_do_progress(state, out, *bounds, value, max, modifiable, style, in);
};

void __sn_wrap_nk_do_property(nk_flags * ws, struct nk_command_buffer * out, struct nk_rect *property, const char * name, struct nk_property_variant * variant, float inc_per_pixel, char * buffer, int * len, int * state, int * cursor, int * select_begin, int * select_end, const struct nk_style_property * style, enum nk_property_filter filter, struct nk_input * in, const struct nk_user_font * font, struct nk_text_edit * text_edit, enum nk_button_behavior behavior) {
 nk_do_property(ws, out, *property, name, variant, inc_per_pixel, buffer, len, state, cursor, select_begin, select_end, style, filter, in, font, text_edit, behavior);
};

float __sn_wrap_nk_do_scrollbarh(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *scroll, int has_scrolling, float offset, float target, float step, float button_pixel_inc, const struct nk_style_scrollbar * style, struct nk_input * in, const struct nk_user_font * font) {
 return nk_do_scrollbarh(state, out, *scroll, has_scrolling, offset, target, step, button_pixel_inc, style, in, font);
};

float __sn_wrap_nk_do_scrollbarv(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *scroll, int has_scrolling, float offset, float target, float step, float button_pixel_inc, const struct nk_style_scrollbar * style, struct nk_input * in, const struct nk_user_font * font) {
 return nk_do_scrollbarv(state, out, *scroll, has_scrolling, offset, target, step, button_pixel_inc, style, in, font);
};

nk_bool __sn_wrap_nk_do_selectable(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *bounds, const char * str, int len, nk_flags align, nk_bool * value, const struct nk_style_selectable * style, const struct nk_input * in, const struct nk_user_font * font) {
 return nk_do_selectable(state, out, *bounds, str, len, align, value, style, in, font);
};

nk_bool __sn_wrap_nk_do_selectable_image(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *bounds, const char * str, int len, nk_flags align, nk_bool * value, const struct nk_image * img, const struct nk_style_selectable * style, const struct nk_input * in, const struct nk_user_font * font) {
 return nk_do_selectable_image(state, out, *bounds, str, len, align, value, img, style, in, font);
};

nk_bool __sn_wrap_nk_do_selectable_symbol(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *bounds, const char * str, int len, nk_flags align, nk_bool * value, enum nk_symbol_type sym, const struct nk_style_selectable * style, const struct nk_input * in, const struct nk_user_font * font) {
 return nk_do_selectable_symbol(state, out, *bounds, str, len, align, value, sym, style, in, font);
};

float __sn_wrap_nk_do_slider(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *bounds, float min, float val, float max, float step, const struct nk_style_slider * style, struct nk_input * in, const struct nk_user_font * font) {
 return nk_do_slider(state, out, *bounds, min, val, max, step, style, in, font);
};

nk_bool __sn_wrap_nk_do_toggle(nk_flags * state, struct nk_command_buffer * out, struct nk_rect *r, nk_bool * active, const char * str, int len, enum nk_toggle_type type, const struct nk_style_toggle * style, const struct nk_input * in, const struct nk_user_font * font) {
 return nk_do_toggle(state, out, *r, active, str, len, type, style, in, font);
};

void __sn_wrap_nk_drag_behavior(nk_flags * state, const struct nk_input * in, struct nk_rect *drag, struct nk_property_variant * variant, float inc_per_pixel) {
 nk_drag_behavior(state, in, *drag, variant, inc_per_pixel);
};

void __sn_wrap_nk_draw_color_picker(struct nk_command_buffer * o, const struct nk_rect * matrix, const struct nk_rect * hue_bar, const struct nk_rect * alpha_bar, struct nk_colorf *col) {
 nk_draw_color_picker(o, matrix, hue_bar, alpha_bar, *col);
};

void __sn_wrap_nk_draw_image(struct nk_command_buffer * b, struct nk_rect *r, const struct nk_image * img, struct nk_color *col) {
 nk_draw_image(b, *r, img, *col);
};

void __sn_wrap_nk_draw_nine_slice(struct nk_command_buffer * b, struct nk_rect *r, const struct nk_nine_slice * slc, struct nk_color *col) {
 nk_draw_nine_slice(b, *r, slc, *col);
};

void __sn_wrap_nk_draw_symbol(struct nk_command_buffer * out, enum nk_symbol_type type, struct nk_rect *content, struct nk_color *background, struct nk_color *foreground, float border_width, const struct nk_user_font * font) {
 nk_draw_symbol(out, type, *content, *background, *foreground, border_width, font);
};

void __sn_wrap_nk_draw_text(struct nk_command_buffer * b, struct nk_rect *r, const char * string, int length, const struct nk_user_font * font, struct nk_color *bg, struct nk_color *fg) {
 nk_draw_text(b, *r, string, length, font, *bg, *fg);
};

void __sn_wrap_nk_edit_draw_text(struct nk_command_buffer * out, const struct nk_style_edit * style, float pos_x, float pos_y, float x_offset, const char * text, int byte_len, float row_height, const struct nk_user_font * font, struct nk_color *background, struct nk_color *foreground, nk_bool is_selected) {
 nk_edit_draw_text(out, style, pos_x, pos_y, x_offset, text, byte_len, row_height, font, *background, *foreground, is_selected);
};

void __sn_wrap_nk_fill_arc(struct nk_command_buffer * b, float cx, float cy, float radius, float a_min, float a_max, struct nk_color *c) {
 nk_fill_arc(b, cx, cy, radius, a_min, a_max, *c);
};

void __sn_wrap_nk_fill_circle(struct nk_command_buffer * b, struct nk_rect *r, struct nk_color *c) {
 nk_fill_circle(b, *r, *c);
};

void __sn_wrap_nk_fill_polygon(struct nk_command_buffer * b, float * points, int point_count, struct nk_color *col) {
 nk_fill_polygon(b, points, point_count, *col);
};

void __sn_wrap_nk_fill_rect(struct nk_command_buffer * b, struct nk_rect *rect, float rounding, struct nk_color *c) {
 nk_fill_rect(b, *rect, rounding, *c);
};

void __sn_wrap_nk_fill_rect_multi_color(struct nk_command_buffer * b, struct nk_rect *rect, struct nk_color *left, struct nk_color *top, struct nk_color *right, struct nk_color *bottom) {
 nk_fill_rect_multi_color(b, *rect, *left, *top, *right, *bottom);
};

void __sn_wrap_nk_fill_triangle(struct nk_command_buffer * b, float x0, float y0, float x1, float y1, float x2, float y2, struct nk_color *c) {
 nk_fill_triangle(b, x0, y0, x1, y1, x2, y2, *c);
};

void __sn_wrap_nk_get_null_rect(struct nk_rect *__return) {
  nk_rect ____ret = nk_get_null_rect();
  memcpy(__return, &____ret, sizeof(nk_rect));
}

void __sn_wrap_nk_hsv(int h, int s, int v, struct nk_color *__return) {
  nk_color ____ret = nk_hsv(h, s, v);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_hsv_f(float h, float s, float v, struct nk_color *__return) {
  nk_color ____ret = nk_hsv_f(h, s, v);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_hsva(int h, int s, int v, int a, struct nk_color *__return) {
  nk_color ____ret = nk_hsva(h, s, v, a);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_hsva_colorf(float h, float s, float v, float a, struct nk_colorf *__return) {
  nk_colorf ____ret = nk_hsva_colorf(h, s, v, a);
  memcpy(__return, &____ret, sizeof(nk_colorf));
}

void __sn_wrap_nk_hsva_colorfv(float * c, struct nk_colorf *__return) {
  nk_colorf ____ret = nk_hsva_colorfv(c);
  memcpy(__return, &____ret, sizeof(nk_colorf));
}

void __sn_wrap_nk_hsva_f(float h, float s, float v, float a, struct nk_color *__return) {
  nk_color ____ret = nk_hsva_f(h, s, v, a);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_image(struct nk_context * ctx, struct nk_image *img) {
 nk_image(ctx, *img);
};

void __sn_wrap_nk_image_color(struct nk_context * ctx, struct nk_image *img, struct nk_color *col) {
 nk_image_color(ctx, *img, *col);
};

void __sn_wrap_nk_image_handle(nk_handle handle, struct nk_image *__return) {
  nk_image ____ret = nk_image_handle(handle);
  memcpy(__return, &____ret, sizeof(nk_image));
}

void __sn_wrap_nk_image_id(int id, struct nk_image *__return) {
  nk_image ____ret = nk_image_id(id);
  memcpy(__return, &____ret, sizeof(nk_image));
}

void __sn_wrap_nk_image_ptr(void * ptr, struct nk_image *__return) {
  nk_image ____ret = nk_image_ptr(ptr);
  memcpy(__return, &____ret, sizeof(nk_image));
}

nk_bool __sn_wrap_nk_input_any_mouse_click_in_rect(const struct nk_input * in, struct nk_rect *b) {
 return nk_input_any_mouse_click_in_rect(in, *b);
};

nk_bool __sn_wrap_nk_input_has_mouse_click_down_in_rect(const struct nk_input * i, enum nk_buttons id, struct nk_rect *b, nk_bool down) {
 return nk_input_has_mouse_click_down_in_rect(i, id, *b, down);
};

nk_bool __sn_wrap_nk_input_has_mouse_click_in_rect(const struct nk_input * i, enum nk_buttons id, struct nk_rect *b) {
 return nk_input_has_mouse_click_in_rect(i, id, *b);
};

nk_bool __sn_wrap_nk_input_is_mouse_click_down_in_rect(const struct nk_input * i, enum nk_buttons id, struct nk_rect *b, nk_bool down) {
 return nk_input_is_mouse_click_down_in_rect(i, id, *b, down);
};

nk_bool __sn_wrap_nk_input_is_mouse_click_in_rect(const struct nk_input * i, enum nk_buttons id, struct nk_rect *b) {
 return nk_input_is_mouse_click_in_rect(i, id, *b);
};

nk_bool __sn_wrap_nk_input_is_mouse_hovering_rect(const struct nk_input * i, struct nk_rect *rect) {
 return nk_input_is_mouse_hovering_rect(i, *rect);
};

nk_bool __sn_wrap_nk_input_is_mouse_prev_hovering_rect(const struct nk_input * i, struct nk_rect *rect) {
 return nk_input_is_mouse_prev_hovering_rect(i, *rect);
};

nk_bool __sn_wrap_nk_input_mouse_clicked(const struct nk_input * i, enum nk_buttons id, struct nk_rect *rect) {
 return nk_input_mouse_clicked(i, id, *rect);
};

void __sn_wrap_nk_input_scroll(struct nk_context * ctx, struct nk_vec2 *val) {
 nk_input_scroll(ctx, *val);
};

void __sn_wrap_nk_label_colored(struct nk_context * ctx, const char * str, nk_flags align, struct nk_color *color) {
 nk_label_colored(ctx, str, align, *color);
};

void __sn_wrap_nk_label_colored_wrap(struct nk_context * ctx, const char * str, struct nk_color *color) {
 nk_label_colored_wrap(ctx, str, *color);
};

void __sn_wrap_nk_layout_space_bounds(struct nk_context * ctx, struct nk_rect *__return) {
  nk_rect ____ret = nk_layout_space_bounds(ctx);
  memcpy(__return, &____ret, sizeof(nk_rect));
}

void __sn_wrap_nk_layout_space_push(struct nk_context * ctx, struct nk_rect *rect) {
 nk_layout_space_push(ctx, *rect);
};

void __sn_wrap_nk_layout_space_rect_to_local(struct nk_context * ctx, struct nk_rect *ret, struct nk_rect *__return) {
  nk_rect ____ret = nk_layout_space_rect_to_local(ctx, *ret);
  memcpy(__return, &____ret, sizeof(nk_rect));
}

void __sn_wrap_nk_layout_space_rect_to_screen(struct nk_context * ctx, struct nk_rect *ret, struct nk_rect *__return) {
  nk_rect ____ret = nk_layout_space_rect_to_screen(ctx, *ret);
  memcpy(__return, &____ret, sizeof(nk_rect));
}

void __sn_wrap_nk_layout_space_to_local(struct nk_context * ctx, struct nk_vec2 *ret, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_layout_space_to_local(ctx, *ret);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_layout_space_to_screen(struct nk_context * ctx, struct nk_vec2 *ret, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_layout_space_to_screen(ctx, *ret);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_layout_widget_bounds(struct nk_context * ctx, struct nk_rect *__return) {
  nk_rect ____ret = nk_layout_widget_bounds(ctx);
  memcpy(__return, &____ret, sizeof(nk_rect));
}

int __sn_wrap_nk_menu_begin(struct nk_context * ctx, struct nk_window * win, const char * id, int is_clicked, struct nk_rect *header, struct nk_vec2 *size) {
 return nk_menu_begin(ctx, win, id, is_clicked, *header, *size);
};

nk_bool __sn_wrap_nk_menu_begin_image(struct nk_context * ctx, const char * id, struct nk_image *img, struct nk_vec2 *size) {
 return nk_menu_begin_image(ctx, id, *img, *size);
};

nk_bool __sn_wrap_nk_menu_begin_image_label(struct nk_context * ctx, const char * title, nk_flags align, struct nk_image *img, struct nk_vec2 *size) {
 return nk_menu_begin_image_label(ctx, title, align, *img, *size);
};

nk_bool __sn_wrap_nk_menu_begin_image_text(struct nk_context * ctx, const char * title, int len, nk_flags align, struct nk_image *img, struct nk_vec2 *size) {
 return nk_menu_begin_image_text(ctx, title, len, align, *img, *size);
};

nk_bool __sn_wrap_nk_menu_begin_label(struct nk_context * ctx, const char * text, nk_flags align, struct nk_vec2 *size) {
 return nk_menu_begin_label(ctx, text, align, *size);
};

nk_bool __sn_wrap_nk_menu_begin_symbol(struct nk_context * ctx, const char * id, enum nk_symbol_type sym, struct nk_vec2 *size) {
 return nk_menu_begin_symbol(ctx, id, sym, *size);
};

nk_bool __sn_wrap_nk_menu_begin_symbol_label(struct nk_context * ctx, const char * title, nk_flags align, enum nk_symbol_type sym, struct nk_vec2 *size) {
 return nk_menu_begin_symbol_label(ctx, title, align, sym, *size);
};

nk_bool __sn_wrap_nk_menu_begin_symbol_text(struct nk_context * ctx, const char * title, int len, nk_flags align, enum nk_symbol_type sym, struct nk_vec2 *size) {
 return nk_menu_begin_symbol_text(ctx, title, len, align, sym, *size);
};

nk_bool __sn_wrap_nk_menu_begin_text(struct nk_context * ctx, const char * title, int len, nk_flags align, struct nk_vec2 *size) {
 return nk_menu_begin_text(ctx, title, len, align, *size);
};

nk_bool __sn_wrap_nk_menu_item_image_label(struct nk_context * ctx, struct nk_image *img, const char * label, nk_flags align) {
 return nk_menu_item_image_label(ctx, *img, label, align);
};

nk_bool __sn_wrap_nk_menu_item_image_text(struct nk_context * ctx, struct nk_image *img, const char * text, int len, nk_flags align) {
 return nk_menu_item_image_text(ctx, *img, text, len, align);
};

void __sn_wrap_nk_nine_slice_handle(nk_handle handle, nk_ushort l, nk_ushort t, nk_ushort r, nk_ushort b, struct nk_nine_slice *__return) {
  nk_nine_slice ____ret = nk_nine_slice_handle(handle, l, t, r, b);
  memcpy(__return, &____ret, sizeof(nk_nine_slice));
}

void __sn_wrap_nk_nine_slice_id(int id, nk_ushort l, nk_ushort t, nk_ushort r, nk_ushort b, struct nk_nine_slice *__return) {
  nk_nine_slice ____ret = nk_nine_slice_id(id, l, t, r, b);
  memcpy(__return, &____ret, sizeof(nk_nine_slice));
}

void __sn_wrap_nk_nine_slice_ptr(void * ptr, nk_ushort l, nk_ushort t, nk_ushort r, nk_ushort b, struct nk_nine_slice *__return) {
  nk_nine_slice ____ret = nk_nine_slice_ptr(ptr, l, t, r, b);
  memcpy(__return, &____ret, sizeof(nk_nine_slice));
}

nk_bool __sn_wrap_nk_nonblock_begin(struct nk_context * ctx, nk_flags flags, struct nk_rect *body, struct nk_rect *header, enum nk_panel_type panel_type) {
 return nk_nonblock_begin(ctx, flags, *body, *header, panel_type);
};

void __sn_wrap_nk_pad_rect(struct nk_rect *r, struct nk_vec2 *pad, struct nk_rect *__return) {
  nk_rect ____ret = nk_pad_rect(*r, *pad);
  memcpy(__return, &____ret, sizeof(nk_rect));
}

void __sn_wrap_nk_panel_get_border_color(const struct nk_style * style, enum nk_panel_type type, struct nk_color *__return) {
  nk_color ____ret = nk_panel_get_border_color(style, type);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_panel_get_padding(const struct nk_style * style, enum nk_panel_type type, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_panel_get_padding(style, type);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

nk_bool __sn_wrap_nk_popup_begin(struct nk_context * ctx, enum nk_popup_type type, const char * title, nk_flags flags, struct nk_rect *rect) {
 return nk_popup_begin(ctx, type, title, flags, *rect);
};

nk_size __sn_wrap_nk_progress_behavior(nk_flags * state, struct nk_input * in, struct nk_rect *r, struct nk_rect *cursor, nk_size max, nk_size value, nk_bool modifiable) {
 return nk_progress_behavior(state, in, *r, *cursor, max, value, modifiable);
};

void __sn_wrap_nk_property_behavior(nk_flags * ws, const struct nk_input * in, struct nk_rect *property, struct nk_rect *label, struct nk_rect *edit, struct nk_rect *empty, int * state, struct nk_property_variant * variant, float inc_per_pixel) {
 nk_property_behavior(ws, in, *property, *label, *edit, *empty, state, variant, inc_per_pixel);
};

void __sn_wrap_nk_property_variant_double(double value, double min_value, double max_value, double step, struct nk_property_variant *__return) {
  nk_property_variant ____ret = nk_property_variant_double(value, min_value, max_value, step);
  memcpy(__return, &____ret, sizeof(nk_property_variant));
}

void __sn_wrap_nk_property_variant_float(float value, float min_value, float max_value, float step, struct nk_property_variant *__return) {
  nk_property_variant ____ret = nk_property_variant_float(value, min_value, max_value, step);
  memcpy(__return, &____ret, sizeof(nk_property_variant));
}

void __sn_wrap_nk_property_variant_int(int value, int min_value, int max_value, int step, struct nk_property_variant *__return) {
  nk_property_variant ____ret = nk_property_variant_int(value, min_value, max_value, step);
  memcpy(__return, &____ret, sizeof(nk_property_variant));
}

void __sn_wrap_nk_push_custom(struct nk_command_buffer * b, struct nk_rect *r, nk_command_custom_callback cb, nk_handle usr) {
 nk_push_custom(b, *r, cb, usr);
};

void __sn_wrap_nk_push_scissor(struct nk_command_buffer * b, struct nk_rect *r) {
 nk_push_scissor(b, *r);
};

void __sn_wrap_nk_rect(float x, float y, float w, float h, struct nk_rect *__return) {
  nk_rect ____ret = nk_rect(x, y, w, h);
  memcpy(__return, &____ret, sizeof(nk_rect));
}

void __sn_wrap_nk_rect_pos(struct nk_rect *r, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_rect_pos(*r);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_rect_size(struct nk_rect *r, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_rect_size(*r);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_recta(struct nk_vec2 *pos, struct nk_vec2 *size, struct nk_rect *__return) {
  nk_rect ____ret = nk_recta(*pos, *size);
  memcpy(__return, &____ret, sizeof(nk_rect));
}

void __sn_wrap_nk_recti(int x, int y, int w, int h, struct nk_rect *__return) {
  nk_rect ____ret = nk_recti(x, y, w, h);
  memcpy(__return, &____ret, sizeof(nk_rect));
}

void __sn_wrap_nk_rgb(int r, int g, int b, struct nk_color *__return) {
  nk_color ____ret = nk_rgb(r, g, b);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_rgb_cf(struct nk_colorf *c, struct nk_color *__return) {
  nk_color ____ret = nk_rgb_cf(*c);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_rgb_f(float r, float g, float b, struct nk_color *__return) {
  nk_color ____ret = nk_rgb_f(r, g, b);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_rgb_hex(const char * rgb, struct nk_color *__return) {
  nk_color ____ret = nk_rgb_hex(rgb);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_rgba(int r, int g, int b, int a, struct nk_color *__return) {
  nk_color ____ret = nk_rgba(r, g, b, a);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_rgba_cf(struct nk_colorf *c, struct nk_color *__return) {
  nk_color ____ret = nk_rgba_cf(*c);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_rgba_f(float r, float g, float b, float a, struct nk_color *__return) {
  nk_color ____ret = nk_rgba_f(r, g, b, a);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_rgba_hex(const char * rgb, struct nk_color *__return) {
  nk_color ____ret = nk_rgba_hex(rgb);
  memcpy(__return, &____ret, sizeof(nk_color));
}

void __sn_wrap_nk_rgba_u32(nk_uint in, struct nk_color *__return) {
  nk_color ____ret = nk_rgba_u32(in);
  memcpy(__return, &____ret, sizeof(nk_color));
}

nk_bool __sn_wrap_nk_select_image_label(struct nk_context * ctx, struct nk_image *img, const char * str, nk_flags align, nk_bool value) {
 return nk_select_image_label(ctx, *img, str, align, value);
};

nk_bool __sn_wrap_nk_select_image_text(struct nk_context * ctx, struct nk_image *img, const char * str, int len, nk_flags align, nk_bool value) {
 return nk_select_image_text(ctx, *img, str, len, align, value);
};

nk_bool __sn_wrap_nk_selectable_image_label(struct nk_context * ctx, struct nk_image *img, const char * str, nk_flags align, nk_bool * value) {
 return nk_selectable_image_label(ctx, *img, str, align, value);
};

nk_bool __sn_wrap_nk_selectable_image_text(struct nk_context * ctx, struct nk_image *img, const char * str, int len, nk_flags align, nk_bool * value) {
 return nk_selectable_image_text(ctx, *img, str, len, align, value);
};

void __sn_wrap_nk_shrink_rect(struct nk_rect *r, float amount, struct nk_rect *__return) {
  nk_rect ____ret = nk_shrink_rect(*r, amount);
  memcpy(__return, &____ret, sizeof(nk_rect));
}

float __sn_wrap_nk_slider_behavior(nk_flags * state, struct nk_rect * logical_cursor, struct nk_rect * visual_cursor, struct nk_input * in, struct nk_rect *bounds, float slider_min, float slider_max, float slider_value, float slider_step, float slider_steps) {
 return nk_slider_behavior(state, logical_cursor, visual_cursor, in, *bounds, slider_min, slider_max, slider_value, slider_step, slider_steps);
};

void __sn_wrap_nk_stroke_arc(struct nk_command_buffer * b, float cx, float cy, float radius, float a_min, float a_max, float line_thickness, struct nk_color *c) {
 nk_stroke_arc(b, cx, cy, radius, a_min, a_max, line_thickness, *c);
};

void __sn_wrap_nk_stroke_circle(struct nk_command_buffer * b, struct nk_rect *r, float line_thickness, struct nk_color *c) {
 nk_stroke_circle(b, *r, line_thickness, *c);
};

void __sn_wrap_nk_stroke_curve(struct nk_command_buffer * b, float ax, float ay, float ctrl0x, float ctrl0y, float ctrl1x, float ctrl1y, float bx, float by, float line_thickness, struct nk_color *col) {
 nk_stroke_curve(b, ax, ay, ctrl0x, ctrl0y, ctrl1x, ctrl1y, bx, by, line_thickness, *col);
};

void __sn_wrap_nk_stroke_line(struct nk_command_buffer * b, float x0, float y0, float x1, float y1, float line_thickness, struct nk_color *c) {
 nk_stroke_line(b, x0, y0, x1, y1, line_thickness, *c);
};

void __sn_wrap_nk_stroke_polygon(struct nk_command_buffer * b, float * points, int point_count, float line_thickness, struct nk_color *col) {
 nk_stroke_polygon(b, points, point_count, line_thickness, *col);
};

void __sn_wrap_nk_stroke_polyline(struct nk_command_buffer * b, float * points, int point_count, float line_thickness, struct nk_color *col) {
 nk_stroke_polyline(b, points, point_count, line_thickness, *col);
};

void __sn_wrap_nk_stroke_rect(struct nk_command_buffer * b, struct nk_rect *rect, float rounding, float line_thickness, struct nk_color *c) {
 nk_stroke_rect(b, *rect, rounding, line_thickness, *c);
};

void __sn_wrap_nk_stroke_triangle(struct nk_command_buffer * b, float x0, float y0, float x1, float y1, float x2, float y2, float line_thickness, struct nk_color *c) {
 nk_stroke_triangle(b, x0, y0, x1, y1, x2, y2, line_thickness, *c);
};

void __sn_wrap_nk_style_item_color(struct nk_color *col, struct nk_style_item *__return) {
  nk_style_item ____ret = nk_style_item_color(*col);
  memcpy(__return, &____ret, sizeof(nk_style_item));
}

void __sn_wrap_nk_style_item_hide(struct nk_style_item *__return) {
  nk_style_item ____ret = nk_style_item_hide();
  memcpy(__return, &____ret, sizeof(nk_style_item));
}

void __sn_wrap_nk_style_item_image(struct nk_image *img, struct nk_style_item *__return) {
  nk_style_item ____ret = nk_style_item_image(*img);
  memcpy(__return, &____ret, sizeof(nk_style_item));
}

void __sn_wrap_nk_style_item_nine_slice(struct nk_nine_slice *slice, struct nk_style_item *__return) {
  nk_style_item ____ret = nk_style_item_nine_slice(*slice);
  memcpy(__return, &____ret, sizeof(nk_style_item));
}

nk_bool __sn_wrap_nk_style_push_color(struct nk_context * ctx, struct nk_color * address, struct nk_color *value) {
 return nk_style_push_color(ctx, address, *value);
};

nk_bool __sn_wrap_nk_style_push_style_item(struct nk_context * ctx, struct nk_style_item * address, struct nk_style_item *value) {
 return nk_style_push_style_item(ctx, address, *value);
};

nk_bool __sn_wrap_nk_style_push_vec2(struct nk_context * ctx, struct nk_vec2 * address, struct nk_vec2 *value) {
 return nk_style_push_vec2(ctx, address, *value);
};

void __sn_wrap_nk_sub9slice_handle(nk_handle handle, nk_ushort w, nk_ushort h, struct nk_rect *rgn, nk_ushort l, nk_ushort t, nk_ushort r, nk_ushort b, struct nk_nine_slice *__return) {
  nk_nine_slice ____ret = nk_sub9slice_handle(handle, w, h, *rgn, l, t, r, b);
  memcpy(__return, &____ret, sizeof(nk_nine_slice));
}

void __sn_wrap_nk_sub9slice_id(int id, nk_ushort w, nk_ushort h, struct nk_rect *rgn, nk_ushort l, nk_ushort t, nk_ushort r, nk_ushort b, struct nk_nine_slice *__return) {
  nk_nine_slice ____ret = nk_sub9slice_id(id, w, h, *rgn, l, t, r, b);
  memcpy(__return, &____ret, sizeof(nk_nine_slice));
}

void __sn_wrap_nk_sub9slice_ptr(void * ptr, nk_ushort w, nk_ushort h, struct nk_rect *rgn, nk_ushort l, nk_ushort t, nk_ushort r, nk_ushort b, struct nk_nine_slice *__return) {
  nk_nine_slice ____ret = nk_sub9slice_ptr(ptr, w, h, *rgn, l, t, r, b);
  memcpy(__return, &____ret, sizeof(nk_nine_slice));
}

void __sn_wrap_nk_subimage_handle(nk_handle handle, nk_ushort w, nk_ushort h, struct nk_rect *r, struct nk_image *__return) {
  nk_image ____ret = nk_subimage_handle(handle, w, h, *r);
  memcpy(__return, &____ret, sizeof(nk_image));
}

void __sn_wrap_nk_subimage_id(int id, nk_ushort w, nk_ushort h, struct nk_rect *r, struct nk_image *__return) {
  nk_image ____ret = nk_subimage_id(id, w, h, *r);
  memcpy(__return, &____ret, sizeof(nk_image));
}

void __sn_wrap_nk_subimage_ptr(void * ptr, nk_ushort w, nk_ushort h, struct nk_rect *r, struct nk_image *__return) {
  nk_image ____ret = nk_subimage_ptr(ptr, w, h, *r);
  memcpy(__return, &____ret, sizeof(nk_image));
}

void __sn_wrap_nk_text_calculate_text_bounds(const struct nk_user_font * font, const char * begin, int byte_len, float row_height, const char ** remaining, struct nk_vec2 * out_offset, int * glyphs, int op, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_text_calculate_text_bounds(font, begin, byte_len, row_height, remaining, out_offset, glyphs, op);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_text_colored(struct nk_context * ctx, const char * str, int len, nk_flags alignment, struct nk_color *color) {
 nk_text_colored(ctx, str, len, alignment, *color);
};

void __sn_wrap_nk_text_wrap_colored(struct nk_context * ctx, const char * str, int len, struct nk_color *color) {
 nk_text_wrap_colored(ctx, str, len, *color);
};

nk_bool __sn_wrap_nk_toggle_behavior(const struct nk_input * in, struct nk_rect *select, nk_flags * state, nk_bool active) {
 return nk_toggle_behavior(in, *select, state, active);
};

nk_bool __sn_wrap_nk_tree_element_image_push_hashed(struct nk_context * ctx, enum nk_tree_type type, struct nk_image *img, const char * title, enum nk_collapse_states initial_state, nk_bool * selected, const char * hash, int len, int seed) {
 return nk_tree_element_image_push_hashed(ctx, type, *img, title, initial_state, selected, hash, len, seed);
};

nk_bool __sn_wrap_nk_tree_image_push_hashed(struct nk_context * ctx, enum nk_tree_type type, struct nk_image *img, const char * title, enum nk_collapse_states initial_state, const char * hash, int len, int seed) {
 return nk_tree_image_push_hashed(ctx, type, *img, title, initial_state, hash, len, seed);
};

nk_bool __sn_wrap_nk_tree_state_image_push(struct nk_context * ctx, enum nk_tree_type type, struct nk_image *img, const char * title, enum nk_collapse_states * state) {
 return nk_tree_state_image_push(ctx, type, *img, title, state);
};

void __sn_wrap_nk_triangle_from_direction(struct nk_vec2 * result, struct nk_rect *r, float pad_x, float pad_y, enum nk_heading direction) {
 nk_triangle_from_direction(result, *r, pad_x, pad_y, direction);
};

void __sn_wrap_nk_vec2(float x, float y, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_vec2(x, y);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_vec2i(int x, int y, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_vec2i(x, y);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_widget_bounds(struct nk_context * ctx, struct nk_rect *__return) {
  nk_rect ____ret = nk_widget_bounds(ctx);
  memcpy(__return, &____ret, sizeof(nk_rect));
}

enum nk_widget_layout_states __sn_wrap_nk_widget_fitting(struct nk_rect * bounds, struct nk_context * ctx, struct nk_vec2 *item_padding) {
 return nk_widget_fitting(bounds, ctx, *item_padding);
};

void __sn_wrap_nk_widget_position(struct nk_context * ctx, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_widget_position(ctx);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_widget_size(struct nk_context * ctx, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_widget_size(ctx);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_widget_text(struct nk_command_buffer * o, struct nk_rect *b, const char * string, int len, const struct nk_text * t, nk_flags a, const struct nk_user_font * f) {
 nk_widget_text(o, *b, string, len, t, a, f);
};

void __sn_wrap_nk_widget_text_wrap(struct nk_command_buffer * o, struct nk_rect *b, const char * string, int len, const struct nk_text * t, const struct nk_user_font * f) {
 nk_widget_text_wrap(o, *b, string, len, t, f);
};

void __sn_wrap_nk_window_get_bounds(const struct nk_context * ctx, struct nk_rect *__return) {
  nk_rect ____ret = nk_window_get_bounds(ctx);
  memcpy(__return, &____ret, sizeof(nk_rect));
}

void __sn_wrap_nk_window_get_content_region(struct nk_context * ctx, struct nk_rect *__return) {
  nk_rect ____ret = nk_window_get_content_region(ctx);
  memcpy(__return, &____ret, sizeof(nk_rect));
}

void __sn_wrap_nk_window_get_content_region_max(struct nk_context * ctx, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_window_get_content_region_max(ctx);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_window_get_content_region_min(struct nk_context * ctx, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_window_get_content_region_min(ctx);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_window_get_content_region_size(struct nk_context * ctx, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_window_get_content_region_size(ctx);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_window_get_position(const struct nk_context * ctx, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_window_get_position(ctx);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_window_get_size(const struct nk_context * ctx, struct nk_vec2 *__return) {
  nk_vec2 ____ret = nk_window_get_size(ctx);
  memcpy(__return, &____ret, sizeof(nk_vec2));
}

void __sn_wrap_nk_window_set_bounds(struct nk_context * ctx, const char * name, struct nk_rect *bounds) {
 nk_window_set_bounds(ctx, name, *bounds);
};

void __sn_wrap_nk_window_set_position(struct nk_context * ctx, const char * name, struct nk_vec2 *pos) {
 nk_window_set_position(ctx, name, *pos);
};

void __sn_wrap_nk_window_set_size(struct nk_context * ctx, const char * name, struct nk_vec2 *size) {
 nk_window_set_size(ctx, name, *size);
};


