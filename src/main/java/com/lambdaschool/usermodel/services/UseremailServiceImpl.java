package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.Useremail;
import com.lambdaschool.usermodel.repository.UseremailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "useremailService")
public class UseremailServiceImpl implements UseremailService
{
    @Autowired
    private UseremailRepository useremailrepos;

    @Override
    public List<Useremail> findAll()
    {
        List<Useremail> list = new ArrayList<>();
        useremailrepos.findAll()
                      .iterator()
                      .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Useremail findUseremailById(long id)
    {
        return useremailrepos.findById(id)
                             .orElseThrow(() -> new EntityNotFoundException("Useremail with id " + id + " Not Found!"));
    }

    @Override
    public void delete(long id)
    {
        if (useremailrepos.findById(id)
                          .isPresent())
        {
            useremailrepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException("Useremail with id " + id + " Not Found!");
        }
    }

    @Override
    public Useremail update(long useremailid,
                            String emailaddress)
    {
        if (useremailrepos.findById(useremailid)
                          .isPresent())
        {
            Useremail useremail = findUseremailById(useremailid);
            useremail.setUseremail(emailaddress.toLowerCase());
            return useremailrepos.save(useremail);
        } else
        {
            throw new EntityNotFoundException("Useremail with id " + useremailid + " Not Found!");
        }
    }
}
