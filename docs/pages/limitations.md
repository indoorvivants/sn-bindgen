---
title: Limitations
order: 5
---

## (very old versions, before 0.0.16) Variadic functions are not rendered 

**Note: in `bindgen >= 0.0.17` and Scala Native 0.4.12+ you can now have variadic functions**

Scala Native does support constructing a `va_list`, but a function taking such list must exist in the first place.

In the case of, for example, cURL, the [public interface](https://github.com/curl/curl/blob/master/include/curl/curl.h#L2889) is defined in terms of `...` and there's 
nothing in C that allows you to call a variadic function if all you have is a value of `va_list`.

The layout of said `va_list` also varies by platform.
