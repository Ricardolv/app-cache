package com.richard.domain;

import java.io.Serializable;

public record Product(Long id, String category, String description) implements Serializable {
}
