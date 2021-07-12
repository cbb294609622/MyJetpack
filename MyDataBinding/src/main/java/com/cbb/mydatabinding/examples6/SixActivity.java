package com.cbb.mydatabinding.examples6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.cbb.mydatabinding.R;
import com.cbb.mydatabinding.databinding.ActivitySixBinding;

import java.util.ArrayList;
import java.util.List;

public class SixActivity extends AppCompatActivity {

    private List<Idol> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        ActivitySixBinding sixBinding = DataBindingUtil.setContentView(this, R.layout.activity_six);
        sixBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(mList);
        sixBinding.recyclerView.setAdapter(mAdapter);

    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add(new Idol("刘亦菲1","liuyifei","https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180116%2F4a9b64202a724f6abd76426ee03a09a5.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628667963&t=7f928254dcfd31e7122fe9e27c27ad6d"));
        mList.add(new Idol("刘亦菲2","liuyifei","https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180116%2F4a9b64202a724f6abd76426ee03a09a5.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628667963&t=7f928254dcfd31e7122fe9e27c27ad6d"));
        mList.add(new Idol("刘亦菲3","liuyifei","https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180116%2F4a9b64202a724f6abd76426ee03a09a5.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628667963&t=7f928254dcfd31e7122fe9e27c27ad6d"));
        mList.add(new Idol("刘亦菲4","liuyifei","https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180116%2F4a9b64202a724f6abd76426ee03a09a5.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628667963&t=7f928254dcfd31e7122fe9e27c27ad6d"));
        mList.add(new Idol("刘亦菲5","liuyifei","https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180116%2F4a9b64202a724f6abd76426ee03a09a5.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628667963&t=7f928254dcfd31e7122fe9e27c27ad6d"));
        mList.add(new Idol("刘亦菲6","liuyifei","https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180116%2F4a9b64202a724f6abd76426ee03a09a5.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628667963&t=7f928254dcfd31e7122fe9e27c27ad6d"));
        mList.add(new Idol("刘亦菲7","liuyifei","https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180116%2F4a9b64202a724f6abd76426ee03a09a5.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628667963&t=7f928254dcfd31e7122fe9e27c27ad6d"));
        mList.add(new Idol("刘亦菲8","liuyifei","https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180116%2F4a9b64202a724f6abd76426ee03a09a5.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628667963&t=7f928254dcfd31e7122fe9e27c27ad6d"));
        mList.add(new Idol("刘亦菲9","liuyifei","https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180116%2F4a9b64202a724f6abd76426ee03a09a5.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628667963&t=7f928254dcfd31e7122fe9e27c27ad6d"));
        mList.add(new Idol("刘亦菲10","liuyifei","https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180116%2F4a9b64202a724f6abd76426ee03a09a5.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628667963&t=7f928254dcfd31e7122fe9e27c27ad6d"));
        mList.add(new Idol("刘亦菲11","liuyifei","https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180116%2F4a9b64202a724f6abd76426ee03a09a5.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628667963&t=7f928254dcfd31e7122fe9e27c27ad6d"));
        mList.add(new Idol("刘亦菲12","liuyifei","https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180116%2F4a9b64202a724f6abd76426ee03a09a5.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628667963&t=7f928254dcfd31e7122fe9e27c27ad6d"));
    }
}
