CREATE TABLE Respuestas (
    id BIGINT AUTO_INCREMENT,
    mensaje TEXT NOT NULL,
    fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    autor BIGINT NOT NULL,
    topico BIGINT NOT NULL,
    solucion BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (autor) REFERENCES Usuarios(id),
    FOREIGN KEY (topico) REFERENCES Topicos(id),
    PRIMARY KEY(id)
);