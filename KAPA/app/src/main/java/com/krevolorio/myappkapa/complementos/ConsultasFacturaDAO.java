package com.krevolorio.myappkapa.complementos;

import android.content.Context;

import com.krevolorio.myappkapa.basededatossw.DetalleVO;
import com.krevolorio.myappkapa.basededatossw.FacturaVO;

public interface ConsultasFacturaDAO {
    
    public boolean facturaSW(FacturaVO cvo, Context context);
    public boolean detalleFacturaSW(DetalleVO cvo, Context context);
}
