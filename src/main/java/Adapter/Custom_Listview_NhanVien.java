package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.o7.planning.qlnhanvien.R;


import java.util.List;

import DTO.NhanVienDTO;


public class Custom_Listview_NhanVien extends ArrayAdapter<NhanVienDTO> {
    Context context;
    int resource;
    List<NhanVienDTO> objects;
    public Custom_Listview_NhanVien ( Context context, int resource, List<NhanVienDTO> objects){
        super(context,resource,objects);
        this.objects=objects;
        this.resource=resource;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewrow = inflater.inflate(R.layout.custom_layout_nhanvien,parent,false);

        TextView vTenNhanVien=(TextView)viewrow.findViewById(R.id.vTenNhanVien);
        TextView vGioiTing=(TextView)viewrow.findViewById(R.id.vGioiTinh);
        TextView vSoDienThoai=(TextView)viewrow.findViewById(R.id.vSoDienThoai);
        TextView vMaNhanVien=(TextView)viewrow.findViewById(R.id.MaNV);


        NhanVienDTO nhanvien=objects.get(position);
        vTenNhanVien.setText(nhanvien.getTennv());
        vGioiTing.setText(nhanvien.getGioitinh());
        vSoDienThoai.setText(nhanvien.getSdt());
        vMaNhanVien.setText(String.valueOf(" Mã " + nhanvien.getManv()));

        return viewrow;
    }
}

