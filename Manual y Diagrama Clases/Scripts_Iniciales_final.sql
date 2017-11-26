INSERT INTO public.usuario(id, apellido, celular, contrasenia, direccion,  
            nombre, telefono, fch_nac) VALUES ('aallois', 'ALLOIS', '098327640', '123456', 'COLON 1316',  
            'ANTHONY', '', '10/02/1982');


INSERT INTO public.acceso(agenda, consultas, estadisticas, opciones, pacientes, pagos, reportes, usuario_id, migracion)
    VALUES (true, true, true, true, true, true, true, 'aallois',true);



INSERT INTO public.opcion(
            id, descripcion, valor)
    VALUES ('1', 'Nro. Factura Inicial', '111111');
    
INSERT INTO public.opcion(
            id, descripcion, valor)
    VALUES ('2', 'Path BackUp', 'E:\BackUps\');    


